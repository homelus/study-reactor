package jun.study.reactor;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import jun.study.reactor.model.SampleSubscriber;

import java.util.Arrays;
import java.util.List;

/**
 * @author playjun
 * @since 2019 11 05
 */
public class ReactorCoreFeatures {

    @Test
    void createString() {
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");

        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);
    }

    @Test
    void factoryMethod() {
        Mono<String> noData = Mono.empty();
        Mono<String> data = Mono.just("foo");

        Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);
    }

    @Test
    void subscribeNoArg() {
        Flux<Integer> ints = Flux.range(1, 3);
        ints.subscribe();
    }

    @Test
    void subscribeWithVisible() {
        Flux<Integer> ints = Flux.range(1, 3);
        ints.subscribe(i -> System.out.println(i));
    }

    @Test
    void subscribeWithError() {
        Flux<Integer> ints = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("Got to 4");
                });

        ints.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error: " + error));
    }

    @Test
    void subscribeWithErrorAndComplete() {
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(System.out::println,
                error -> System.err.println("Error: " + error),
                () -> System.out.println("Done"));
    }

    @Test
    void subscribeWithSubscription() {
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(System.out::println,
                error -> System.out.println("Error: " + error),
                () -> System.out.println("Done"),
                sub -> sub.request(10));
    }

    @Test
    void sampleSubscriber() {
        SampleSubscriber<Integer> ss = new SampleSubscriber<Integer>();
        Flux<Integer> ints = Flux.range(1, 4);
        ints.subscribe(System.out::println,
                error -> System.out.println("Error: " + error),
                () -> System.out.println("Done"),
                s -> s.request(10));
        ints.subscribe(ss);
    }

    @Test
    void backpressure() {
        Flux.range(1, 10)
                .doOnRequest(r  -> System.out.println("reqeust of " + r))
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        System.out.println("Cancelling after having received " + value);
                        cancel();
                    }
                });
    }

}
