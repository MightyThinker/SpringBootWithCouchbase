package com.pratyush.springcouchbase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.mapping.event.ValidatingCouchbaseEventListener;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.ClusterOptions;
import com.couchbase.client.java.env.ClusterEnvironment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.example.demo.repository"})
public class SpringCouchbaseConfig extends AbstractCouchbaseConfiguration {
	
	@Value("#{systemEnvironment['DB_CONN_STRING'] ?: '${spring.couchbase.connection-string}'}")
    private String connectionString;

	@Value("#{systemEnvironment['DB_USERNAME'] ?: '${spring.couchbase.username}'}")
    private String username;

	@Value("#{systemEnvironment['DB_PASSWORD'] ?: '${spring.couchbase.password}'}")
    private String password;

	@Value("#{systemEnvironment['DB_BUCKET_NAME'] ?: '${spring.couchbase.bucket.name}'}")
    private String bucketName;

	@Override
	public String getConnectionString() {
		return this.connectionString;
	}

	@Override
	public String getUserName() {
		return this.username;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getBucketName() {
		return this.bucketName;
	}
	
	@Bean
    public Cluster couchbaseCluster() {
		log.debug("--Couchbase Cluster--");
        ClusterEnvironment environment = ClusterEnvironment.builder().build();
        return Cluster.connect(connectionString, ClusterOptions.clusterOptions(username, password).environment(environment));
    }

    @Bean
    public Bucket couchbaseBucket() {
    	log.debug("--Couchbase Bucket--");
        return couchbaseCluster().bucket(bucketName);
    }
	
	@Bean
    public ValidatingCouchbaseEventListener validatingCouchbaseEventListener(LocalValidatorFactoryBean factory) {
		log.debug("--Validating Couchbase Event Listern--");
        return new ValidatingCouchbaseEventListener(factory);
    }

}
