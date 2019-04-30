package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    int number = 1;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Woled") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(TEMPLATE, name),
                            "",
                            "");
    }
}
