//package com.ftninformatika.cris.config;
//
//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//import java.net.InetAddress;
//
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.ftninformatika.cris.repository")
//public class ElasticsearchConfiguration {
//
//
//
//    @Bean
//    public Client client() throws Exception {
////        TransportClient client = new TransportClient();
//        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY);
//        TransportAddress address = new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9200);
//        client.addTransportAddress(address);
//        return client;
//    }
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
//        return new ElasticsearchTemplate(client());
//    }
//}