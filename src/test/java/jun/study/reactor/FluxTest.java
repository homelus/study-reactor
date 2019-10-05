package jun.study.reactor;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
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

}
