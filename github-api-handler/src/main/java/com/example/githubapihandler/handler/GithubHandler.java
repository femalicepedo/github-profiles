package com.example.githubapihandler.handler;

import com.example.githubapihandler.model.Github;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GithubHandler {

    private final WebClient client;

    public GithubHandler(WebClient.Builder builder) {
        this.client = builder.baseUrl("https://api.github.com/").build();
    }

    public Mono<ServerResponse> getProfile(ServerRequest serverRequest) {
        Mono<Github> githubMono = this.client.get()
                .uri(serverRequest.path())
                .retrieve()
                .bodyToMono(Github.class);

        return ServerResponse.ok()
                .body(githubMono, Github.class);
    }
}
