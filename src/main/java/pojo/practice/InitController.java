package pojo.practice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class InitController {

    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/index";
    }

}
