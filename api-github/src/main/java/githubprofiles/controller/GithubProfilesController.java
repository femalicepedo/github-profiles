package githubprofiles.controller;

import githubprofiles.client.GithubClient;
import githubprofiles.model.Github;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profiles")
public class GithubProfilesController {

    @Autowired
    private GithubClient client;

    @GetMapping("/{profile}")
    public Github user(@PathVariable("profile") String profile) {
        return client.getProfile(profile);
    }
}
