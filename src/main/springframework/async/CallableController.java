package async;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 * async
 * Created by seyMour on 2016/11/24.
 * ☞Keenyoda☜
 */

@Controller
@RequestMapping("/async/callable")
public class CallableController {

    @RequestMapping(value = "/s2", method = RequestMethod.GET)
    public String index() {
        return "index1";
    }

    @RequestMapping("/response-body")
    @ResponseBody
    public Callable<String> callable() {

        System.out.println("d");

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Callable result";
            }
        };
    }

    @RequestMapping("/view")
    public Callable<String> callableWithView(final Model model) {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                model.addAttribute("foo", "bar");
                model.addAttribute("fruit", "apple");
                return "views/html";
            }
        };
    }

    @RequestMapping("/exception")
    public
    @ResponseBody
    Callable<String> callableWithException(
            final @RequestParam(required = false, defaultValue = "true") boolean handled) {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                if (handled) {
                    // see handleException method further below
                    throw new IllegalStateException("Callable error");
                } else {
                    throw new IllegalArgumentException("Callable error");
                }
            }
        };
    }

    @RequestMapping("/custom-timeout-handling")
    public
    @ResponseBody
    WebAsyncTask<String> callableWithCustomTimeoutHandling() {

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Callable result";
            }
        };

        return new WebAsyncTask<String>(1000, callable);
    }

    @ExceptionHandler
    @ResponseBody
    public String handleException(IllegalStateException ex) {
        return "Handled exception: " + ex.getMessage();
    }

}
