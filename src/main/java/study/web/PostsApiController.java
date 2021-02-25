package study.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.service.posts.PostsService;
import study.web.dto.PostsResponseDto;
import study.web.dto.PostsSaveRequestDto;
import study.web.dto.PostsUpdateRequestDto;

// 사용 이유? 생성자 주입을 위해 사용
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
