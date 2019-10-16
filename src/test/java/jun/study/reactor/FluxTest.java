package jun.study.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static java.util.Arrays.asList;

public class FluxTest {

    @Test
    void fluxTest() {
        Flux.fromIterable(asList(1,2,3,4))
                .delayElements(Duration.ofMillis(500))
                .doOnNext(System.out::println)
                .map(d -> d * 2)
                .take(3)
                .subscribe(System.out::println);
    }

    @Test
    void fluxStream() {
        LazyService lazyService = new LazyService();

        Flux.just(1, 2, 3, 4, 5, 6, 7, 8)
                .doOnNext(lazyService::lazyAdd)
                .map(d -> d + 10)
                .take(6)
                .subscribe(System.out::println);
    }

    @Test
    void emptyFlux() {
        Flux.empty();
    }

    @Test
    void just() {
        Flux.just("foo", "bar");
    }

    @Test
    void error() {
        Flux<String> res = Flux.error(IllegalStateException::new);
    }

    @Test
    void interval() {
        Flux.interval(Duration.ofMillis(0))
            .take(10);
    }

    @Test
    void test() {
        Flux.just("a", "b")
                .map(String::toUpperCase)
                .take(1)
                .doOnNext(System.out::println)
                .subscribe();
    }




}
