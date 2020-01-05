package com.example.demojpa.common.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class QuerydslConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }

}
