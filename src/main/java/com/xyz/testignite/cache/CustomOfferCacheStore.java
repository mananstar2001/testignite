package com.xyz.testignite.cache;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.cache.Cache;
import javax.cache.Cache.Entry;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.lang.IgniteBiInClosure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xyz.testignite.persistence.CustomSSHttpClient;
import com.xyz.testignite.pojo.DataNode;
import com.xyz.testignite.pojo.Offer;

public class CustomOfferCacheStore extends CacheStoreAdapter<String, Offer> {

	private static final String APPLICATION_BASE_URL = "http://172.26.45.69:9000/datafabric/ciscoinc/Offer/find";
	private static final String APPLICATION_PATH_SEPERATOR = "/";

	ObjectMapper JsonMapper = new ObjectMapper();

	// This mehtod is called whenever "get(...)" methods are called on
	// IgniteCache.
	@Override
	public Offer load(String key) {

		Offer requestString = null;

		CustomSSHttpClient client = new CustomSSHttpClient();
		String loadUrl = APPLICATION_BASE_URL + APPLICATION_PATH_SEPERATOR + key.toString();
		try {
			// System.out.println("Loading dynamically");
			requestString = JsonMapper.readValue(client.getRequest(loadUrl), Offer.class);
		} catch (IOException e) {
			throw new CacheLoaderException("Failed to load: " + key, e);
		}
		return requestString;
	}

	// This mehtod is called whenever "put(...)" methods are called on
	// IgniteCache.
	@Override
	public void write(Cache.Entry<? extends String, ? extends Offer> entry) {

		CustomSSHttpClient client = new CustomSSHttpClient();
		String loadUrl = APPLICATION_BASE_URL;
		try {
			client.putRequest(loadUrl, JsonMapper.writeValueAsString(entry.getValue()));
		} catch (IOException e) {
			throw new CacheWriterException("Failed to write [key=" + entry.getKey() + ", val=" + entry.getValue() + ']',
					e);
		}

	}

	// This mehtod is called whenever "remove(...)" methods are called on
	// IgniteCache.
	@Override
	public void delete(Object key) {

		CustomSSHttpClient client = new CustomSSHttpClient();
		String loadUrl = APPLICATION_BASE_URL + APPLICATION_PATH_SEPERATOR + key.toString();

		try {
			client.deleteRequest(loadUrl);
		} catch (IOException e) {
			throw new CacheWriterException("Failed to delete: " + key, e);
		}
	}

	// This mehtod is called whenever "loadCache()" and "localLoadCache()"
	// methods are called on IgniteCache. It is used for bulk-loading the cache.
	// If you don't need to bulk-load the cache, skip this method.
	@Override
	public void loadCache(IgniteBiInClosure<String, Offer> clo, Object... args) {

		final int entryCnt = (args == null || args.length == 0 || args[0] == null) ? -1 : (Integer) args[0];

		DataNode responseDataNode = null;

		CustomSSHttpClient client = new CustomSSHttpClient();
		String loadUrl = APPLICATION_BASE_URL;

		try {

			for (int i = 0; i < 10000; i += 100) {
				String request = "{ \"filter\": {},"
						+ "\"params\": { \"start\": startValue, \"limit\": 100,\"sort\":{\"_id\":1} }}";
				request = request.replace("startValue", Integer.toString(i));
				responseDataNode = JsonMapper.readValue(client.postFabricRequest(loadUrl, request), DataNode.class);

				int k = i;
				int loadCount = 0;

				for (Offer offerObject : responseDataNode.getData()) {

					if (entryCnt < 0) {
						clo.apply(offerObject.get_id(), offerObject);
					} else if (loadCount < entryCnt) {
						clo.apply(offerObject.get_id(), offerObject);
						loadCount++;
					}
					k++;
				}

				if (!responseDataNode.isHasMoreRecords())
					break;
				
				System.out.println("loaded records till now:" + (i+100));
			}

		} catch (IOException e) {
			throw new CacheLoaderException("Failed to load values from cache store.", e);
		}
	}

	// This mehtod is called whenever "getAll(...)" methods are called on
	// IgniteCache.
	@Override
	public Map<String, Offer> loadAll(Iterable<? extends String> keys) {

		Map<String, Offer> resultCache = new HashMap<String, Offer>();

		Offer requestString = null;

		CustomSSHttpClient client = new CustomSSHttpClient();

		try {

			for (String key : keys) {
				String loadUrl = APPLICATION_BASE_URL + APPLICATION_PATH_SEPERATOR + key.toString();

				requestString = JsonMapper.readValue(client.getRequest(loadUrl), Offer.class);
				resultCache.put(key, requestString);
			}

		} catch (IOException e) {
			throw new CacheLoaderException("Failed to loadAll: " + keys, e);
		}
		return resultCache;
	}

	// This mehtod is called whenever "putAll(...)" methods are called on
	// IgniteCache.
	@Override
	public void writeAll(Collection<Cache.Entry<? extends String, ? extends Offer>> entries) {

		CustomSSHttpClient client = new CustomSSHttpClient();

		try {

			for (Entry<? extends String, ? extends Offer> entry : entries) {
				String loadUrl = APPLICATION_BASE_URL + APPLICATION_PATH_SEPERATOR + entry.getKey().toString();

				client.putRequest(loadUrl, JsonMapper.writeValueAsString(entry.getValue()));
			}

		} catch (IOException e) {
			throw new CacheWriterException("Failed to writeAll: " + entries, e);
		}

	}

	// This mehtod is called whenever "removeAll(...)" methods are called on
	// IgniteCache.

	@Override
	public void deleteAll(Collection<?> keys) {

		CustomSSHttpClient client = new CustomSSHttpClient();

		try {

			for (Object key : keys) {
				String loadUrl = APPLICATION_BASE_URL + APPLICATION_PATH_SEPERATOR + key.toString();

				client.deleteRequest(loadUrl);
			}

		} catch (IOException e) {
			throw new CacheWriterException("Failed to deleteAll: " + keys, e);
		}
	}

}
