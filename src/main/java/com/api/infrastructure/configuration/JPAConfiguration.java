package com.api.infrastructure.configuration;

import com.api.infrastructure.repository.jpa.JPAOTPRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = JPAOTPRepository.class)
public class JPAConfiguration {

}
