package in.cg.main;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/fallback/users")
    public Mono<String> userFallback() {
        return Mono.just("User Service is temporarily unavailable. Please try again later.");
    }

    @GetMapping("/fallback/orders")
    public Mono<String> orderFallback() {
        return Mono.just("Order Service is temporarily unavailable. Please try again later.");
    }

}