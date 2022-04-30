package com.example.githubapihandler.router;

import com.example.githubapihandler.handler.GithubHandler;
import com.example.githubapihandler.model.Github;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class GithubRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GithubHandler handler) {
        return RouterFunctions
                .route(GET("/users/{profile}").and(accept(MediaType.APPLICATION_JSON)),
                        handler::getProfile);
    }
}
