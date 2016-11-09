package com.impetus.exploreignite;

import java.util.List;

import javax.cache.Cache.Entry;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.cache.query.SqlQuery;

import com.xyz.testignite.pojo.Offer;
import com.xyz.testignite.pojo.Organization;

public class TestCustomOfferOrgCacheJoin {

	public static void main(String[] args) {

		// Start Ignite node.

		try (Ignite ignite = Ignition.start(
				// "/home/impadmin/ignite/apache-ignite-fabric-1.7.0-bin/examples/config/example-cache-ss-cluster.xml"))
				// {
				"/home/IMPETUS/msheth/install/apache-ignite-fabric-1.7.0-bin/examples/config/example-cache-ss-cluster.xml")) {

			try (IgniteCache<String, Organization> customOrganizationCache = ignite
					.getOrCreateCache("customOrganizationCache");
					IgniteCache<String, Offer> customOfferCache = ignite.getOrCreateCache("customOfferCache")) {


				/*
				 * SqlFieldsQuery joinQuery = new SqlFieldsQuery(
				 * "select organization.displayName " +
				 * "from Organization as organization, \"customOfferCache\".Offer as offer"
				 * +
				 * " where organization._id = offer.relationships.customer.targets.key "
				 * + "and organization._id = ?");
				 */

				SqlFieldsQuery joinQuery = new SqlFieldsQuery("select organization.displayName "
						+ "from Organization as organization" + " where organization._id = ?");

				SqlFieldsQuery joinQuery1 = new SqlFieldsQuery(
						"select offer.displayName " + "from Offer as offer" + " where offer._id = ?");

				String joinSql = "from Organization as organization, \"customOfferCache\".Offer as offer"
						+ " where organization._id = offer.relationships.customer.targets.key "
						+ "and organization._id = ?";

				SqlQuery<String, Organization> joinQuery2 = new SqlQuery<String, Organization>(Organization.class,
						joinSql)
						.setArgs("542de0b83b2d445f0a0e0f53");

				joinQuery2.setDistributedJoins(true);

				long startTime = System.currentTimeMillis();
				try (QueryCursor<List<?>> joinCursor = customOrganizationCache
						.query(joinQuery.setArgs("542de0b83b2d445f0a0e0f53"))) {
					for (List<?> organizationEntry : joinCursor)
						System.out.println("Organizations display name: " + organizationEntry);
				}

				System.out.println("Time to fetch query record:" + (System.currentTimeMillis() - startTime));

				startTime = System.currentTimeMillis();
				try (QueryCursor<List<?>> joinCursor = customOfferCache
						.query(joinQuery1.setArgs("543c0e1f78d66d5c6a014041"))) {
					for (List<?> offerEntry : joinCursor)
						System.out.println("Offer display name: " + offerEntry);
				}

				System.out.println("Time to fetch query1 record:" + (System.currentTimeMillis() - startTime));

				startTime = System.currentTimeMillis();

				List<Entry<String, Organization>> orgList = customOrganizationCache.query(joinQuery2).getAll();

				for (Entry<String, Organization> org : orgList) {
					System.out.println("Join Result: " + org.getValue().toString());
				}

				System.out.println("Time to fetch join based record:" + (System.currentTimeMillis() - startTime));

			}

		}
	}

}
