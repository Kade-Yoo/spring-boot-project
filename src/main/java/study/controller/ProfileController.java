package study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final Environment env;

    @GetMapping("/profile")
    public String profile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProfile = profiles.isEmpty() ? "default" : profiles.get(0);

        System.out.println("Profiles : " + profiles);
        System.out.println("DefaultFile : " + defaultProfile);
        // 리스트에서 realProfiles목록을 포함하고 있다면 출력
        return profiles.stream().filter(realProfiles::contains).findAny().orElse(defaultProfile);
    }
}
