package com.backend.v1.config.elastic;

import org.springframework.beans.factory.annotation.Autowired;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import com.backend.v1.common.util.PropertiesUtil;

import java.net.InetAddress;

/**
 * Elasticsearch Configuration
 *
 * @author wedul
 * @since 2019-02-09
 * 
 * https://wedul.site/576
 **/
@EnableElasticsearchRepositories
@Configuration
public class ElasticConfiguration {
	@Autowired PropertiesUtil propertiesUtil;
	
	@SuppressWarnings("static-access")
	@Bean
	public Client client() throws Exception {
		String host = propertiesUtil.getProperty("elasticsearch.host");
		int port = Integer.parseInt(propertiesUtil.getProperty("elasticsearch.port"));
		String clusterName = propertiesUtil.getProperty("elasticsearch.cluster_name");
		
		Settings settings = Settings.builder().put("cluster.name", clusterName).build();
		TransportClient client = new PreBuiltTransportClient(settings);
		client.addTransportAddress(new TransportAddress(InetAddress.getByName(host), port));
		return client;
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}

}