package jun.study.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

/**
 * @author playjun
 * @since 2019 10 07
 */
public class MonoTest {

    @Test
    void empty() {
        Mono.empty();
    }

    @Test
    void onComplete() {
        Mono.empty();
    }

    @Test
    void just() {
        Mono.just("foo");
    }

    @Test
    void error() {
        Mono.error(IllegalStateException::new);
    }

}
