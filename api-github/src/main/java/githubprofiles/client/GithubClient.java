package githubprofiles.client;

import githubprofiles.model.Github;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GithubClient {

    private final WebClient client;

    public GithubClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8081/").build();
    }

    public Github getProfile(String profile) {
        return this.client.get()
                .uri("users/" + profile)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Github.class)
                .block();
    }
}
