package com.prudhviraj.production_ready_features.production_ready_features.config;

import com.prudhviraj.production_ready_features.production_ready_features.auth.AuditorAwareImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAwareImpl")
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public AuditorAware<String> getAuditorAwareImpl(){
        return  new AuditorAwareImpl(); //returning the class which is implementing auditor aware
    }
}
