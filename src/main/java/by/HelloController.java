package by;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/string")
    @ResponseBody //возвращает строку, если убрать будет файл jsp
    public String sample() {
        return "Test";
    }
}