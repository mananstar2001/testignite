package com.impetus.exploreignite;

import javax.cache.Cache.Entry;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlQuery;
import org.apache.ignite.lang.IgniteBiPredicate;

import com.xyz.testignite.pojo.Offer;

public class TestCustomOfferCache {

	public static void main(String[] args) {

		// Start Ignite node.

		try (Ignite ignite = Ignition.start(
				"/home/impadmin/ignite/apache-ignite-fabric-1.7.0-bin/examples/config/example-cache-ss-cluster.xml")) {

			try (IgniteCache<String, Offer> customOfferCache = ignite
					.getOrCreateCache("customOfferCache")) {


				IgniteBiPredicate<String, Offer> noFilter = new IgniteBiPredicate<String, Offer>() {
					@Override
					public boolean apply(String key, Offer offer) {
						return true;
					}
				};

				/* System.out.println(customCountryCache.get(3)); */

				// customOfferCache.loadCache(noFilter);

				long startTime = System.currentTimeMillis();
				System.out.println(customOfferCache.get("543c0f8adbde188d69010e7f"));
				System.out.println("Time to fetch ranndom record:" + (System.currentTimeMillis() - startTime));

				startTime = System.currentTimeMillis();
				System.out.println(customOfferCache.get("543c0e1f78d66d5c6a014041"));
				System.out.println("Time to fetch ranndom record:" + (System.currentTimeMillis() - startTime));

				SqlQuery sqlQuery = new SqlQuery(Offer.class, "displayName = ?");

				startTime = System.currentTimeMillis();
				// Find all persons earning more than 1,000.
				try (QueryCursor<Entry<String, Offer>> queryCursor = customOfferCache
						.query(sqlQuery.setArgs("33307984388_ESW_SAT_FY15Q2"))) {
					for (Entry<String, Offer> offerEntry : queryCursor)
						System.out.println("Filtered Offer through query:" + offerEntry.getValue().toString());
				}
				System.out
						.println("Time to fetch search by query 1 record:" + (System.currentTimeMillis() - startTime));

				startTime = System.currentTimeMillis();
				// Find all persons earning more than 1,000.
				try (QueryCursor<Entry<String, Offer>> queryCursor = customOfferCache
						.query(sqlQuery.setArgs("33307994905_ESW_SAT_FY15Q2"))) {
					for (Entry<String, Offer> offerEntry : queryCursor)
						System.out.println("Filtered Offer through query:" + offerEntry.getValue().toString());
				}
				System.out
						.println("Time to fetch search by query 2 record:" + (System.currentTimeMillis() - startTime));

				startTime = System.currentTimeMillis();
				// Find all persons earning more than 1,000.
				try (QueryCursor<Entry<String, Offer>> queryCursor = customOfferCache
						.query(sqlQuery.setArgs("33307983478_ESW_SAT_FY15Q2"))) {
					for (Entry<String, Offer> offerEntry : queryCursor)
						System.out.println("Filtered Offer through query:" + offerEntry.getValue().toString());
				}
				System.out
						.println("Time to fetch search by query 3 record:" + (System.currentTimeMillis() - startTime));
			}

		}
	}

}
