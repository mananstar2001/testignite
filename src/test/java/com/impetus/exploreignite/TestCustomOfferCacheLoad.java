package com.impetus.exploreignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteBiPredicate;

import com.xyz.testignite.pojo.Offer;

public class TestCustomOfferCacheLoad {

	public static void main(String[] args) {

		// Start Ignite node.

		try (Ignite ignite = Ignition.start(
				// "/home/impadmin/ignite/apache-ignite-fabric-1.7.0-bin/examples/config/example-cache-ss-cluster.xml"))
				// {
				"/home/IMPETUS/msheth/install/apache-ignite-fabric-1.7.0-bin/examples/config/example-cache-ss-cluster.xml")) {

			try (IgniteCache<String, Offer> customOfferCache = ignite
					.getOrCreateCache("customOfferCache")) {


				IgniteBiPredicate<String, Offer> noFilter = new IgniteBiPredicate<String, Offer>() {
					@Override
					public boolean apply(String key, Offer offer) {
						return true;
					}
				};

				customOfferCache.loadCache(noFilter);

				long startTime = System.currentTimeMillis();
				System.out.println(customOfferCache.get("543c0f8adbde188d69010e7f"));
				System.out.println("Time to fetch ranndom record:" + (System.currentTimeMillis() - startTime));

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
