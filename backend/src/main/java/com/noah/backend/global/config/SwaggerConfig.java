package com.noah.backend.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "NOAH API 명세서",
                description = "NOAH 서비스 API 명세서",
                version = "v1"))
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi all() {
        return GroupedOpenApi.builder()
                .group("전체")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    public GroupedOpenApi bankGroup() {
        return GroupedOpenApi.builder()
                .group("은행")
                .pathsToMatch("/api/v1/bank/**")
                .build();
    }
    @Bean
    public GroupedOpenApi accountGroup() {
        return GroupedOpenApi.builder()
                .group("계좌")
                .pathsToMatch("/api/v1/account/**")
                .build();
    }
    @Bean
    public GroupedOpenApi groupAccountGroup() {
        return GroupedOpenApi.builder()
                .group("모임통장")
                .pathsToMatch("/api/v1/groupaccount/**")
                .build();
    }
    @Bean
    public GroupedOpenApi travelGroup() {
        return GroupedOpenApi.builder()
                .group("여행")
                .pathsToMatch("/api/v1/travel/**")
                .build();
    }

    @Bean
    public GroupedOpenApi reviewGroup() {
        return GroupedOpenApi.builder()
                .group("리뷰")
                .pathsToMatch("/api/v1/review/**")
                .build();
    }
    @Bean
    public GroupedOpenApi commentGroup() {
        return GroupedOpenApi.builder()
                .group("댓글")
                .pathsToMatch("/api/v1/comment/**")
                .build();
    }

    @Bean
    public GroupedOpenApi planGroup() {
        return GroupedOpenApi.builder()
                .group("계획")
                .pathsToMatch("/api/v1/plan/**")
                .build();
    }

    @Bean
    public GroupedOpenApi detailPlanGroup() {
        return GroupedOpenApi.builder()
                .group("세부계획")
                .pathsToMatch("/api/v1/detailPlan/**")
                .build();
    }

    @Bean
    public GroupedOpenApi ticketGroup() {
        return GroupedOpenApi.builder()
                .group("티켓")
                .pathsToMatch("/api/v1/ticket/**")
                .build();

    }

//    @Bean
//    public GroupedOpenApi flightGroup() {
//        return GroupedOpenApi.builder()
//                .group("항공")
//                .pathsToMatch("/api/v2/flight/**")
//                .build();
//    }
}
