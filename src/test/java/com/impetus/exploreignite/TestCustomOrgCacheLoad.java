package com.impetus.exploreignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteBiPredicate;

import com.xyz.testignite.pojo.Organization;

public class TestCustomOrgCacheLoad {

	public static void main(String[] args) {

		// Start Ignite node.

		try (Ignite ignite = Ignition.start(
				// "/home/impadmin/ignite/apache-ignite-fabric-1.7.0-bin/examples/config/example-cache-ss-cluster.xml"))
				// {
				"/home/IMPETUS/msheth/install/apache-ignite-fabric-1.7.0-bin/examples/config/example-cache-ss-cluster.xml")) {

			try (IgniteCache<String, Organization> customOrganizationCache = ignite
							.getOrCreateCache("customOrganizationCache")) {


				IgniteBiPredicate<String, Organization> noOrganizationFilter = new IgniteBiPredicate<String, Organization>() {
					@Override
					public boolean apply(String key, Organization offer) {
						return true;
					}
				};

				customOrganizationCache.loadCache(noOrganizationFilter);

				try {
					Thread.sleep(100000000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

}
