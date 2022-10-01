package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.i
        // ntNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
      /*  ReactiveSources.intNumberMono().subscribe(
                numbers -> System.out.println(numbers),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );
        ReactiveSources.userMono().subscribe(
                users -> System.out.println(users),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );

        ReactiveSources.intNumbersFlux().subscribe(
                numbers -> System.out.println(numbers),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );

        ReactiveSources.userFlux().subscribe(
                users -> System.out.println(users),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );*/

        // Subscribe to a flux using an implementation of BaseSubscriber

        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe Happened");
        request(2);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString());
        request(1);
    }

}