package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * xxx
 * Created by seyMour on 2016/11/24.
 * ☞Keenyoda☜
 */
@Controller
public class MainController {

    @RequestMapping(value = "/s1", method = RequestMethod.GET)
    public String index() {
        return "index1";
    }
}
