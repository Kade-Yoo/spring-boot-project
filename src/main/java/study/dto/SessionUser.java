package study.dto;

import lombok.Getter;

import java.io.Serializable;

// 이 클래스에 직렬화를 하는 이유는?
// => 세션을 저장하기 위한 클래스
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
