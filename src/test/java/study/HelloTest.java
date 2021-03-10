package study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import study.config.auth.SecurityConfig;
import study.config.interceptor.LoginInterceptor;
import study.web.HelloController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class,
excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        ,@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = LoginInterceptor.class)
})
public class HelloTest {

    @Autowired
    private MockMvc mock;

    @WithMockUser(roles = "USER")
    @Test
    public void hello_반환() throws Exception {
        String hello = "hello";

        mock.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @WithMockUser(roles = "USER")
    @Test
    public void 이름_나이_입력() {
        String name = "유형민";
        int age = 10;
    }
}
