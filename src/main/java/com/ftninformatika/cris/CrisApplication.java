package com.ftninformatika.cris;

import com.ftninformatika.cris.config.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.UnknownHostException;

@SpringBootApplication
@ComponentScan("com.ftninformatika")
@EnableJpaRepositories("com.ftninformatika")
@EntityScan("com.ftninformatika")
public class CrisApplication extends SpringApplication {

	public static void main(String[] args) throws UnknownHostException {
//	    Server.createTcpServer().start();
	    SpringApplication.run(CrisApplication.class, args);
	}


	@Override
	protected void configureProfiles(final ConfigurableEnvironment environment, final String[] args) {
		super.configureProfiles(environment, args);

		final boolean developmentActive = environment.acceptsProfiles(Profiles.DEVELOPMENT);
		final boolean development2Active = environment.acceptsProfiles(Profiles.DEVELOPMENT2);
		final boolean testActive = environment.acceptsProfiles(Profiles.TEST);
		final boolean stagingActive = environment.acceptsProfiles(Profiles.STAGING);
		final boolean productionActive = environment.acceptsProfiles(Profiles.PRODUCTION);

		if (stagingActive && productionActive) {
			throw new IllegalStateException("Cannot activate staging and production profiles at the same time.");
		} else if (productionActive || stagingActive) {
			System.out.println("Activating " +
					(productionActive ? Profiles.PRODUCTION : Profiles.STAGING) + " profile.");
		} else if (developmentActive) {
			System.out.println("Activating the development profile.");
		} else if (testActive) {
			System.out.println("Activating the test profile.");
		} else {
			throw new IllegalStateException(
					"Unknown profiles specified. Please specify one of development, test, staging or production.");
		}
	}
}
