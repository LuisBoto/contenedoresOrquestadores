package es.codeurjc.kubetest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.Hazelcast4IndexedSessionRepository;
import org.springframework.session.hazelcast.Hazelcast4PrincipalNameExtractor;
import org.springframework.session.hazelcast.config.annotation.SpringSessionHazelcastInstance;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.AttributeConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.IndexConfig;
import com.hazelcast.config.IndexType;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@EnableHazelcastHttpSession
@Configuration
public class SessionConfig {

	@Bean
	@SpringSessionHazelcastInstance
	public HazelcastInstance hazelcastInstance() {
		AttributeConfig attributeConfig = new AttributeConfig()
				.setName(Hazelcast4IndexedSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
				.setExtractorClassName(Hazelcast4PrincipalNameExtractor.class.getName());

		Config config = new Config();

		config.getMapConfig(Hazelcast4IndexedSessionRepository.DEFAULT_SESSION_MAP_NAME)
				.addAttributeConfig(attributeConfig)
				.addIndexConfig(
						new IndexConfig()
						.addAttribute(Hazelcast4IndexedSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
						.setType(IndexType.HASH));

		return Hazelcast.newHazelcastInstance(config);
	}

}