package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
//        ReactiveSources.intNumbersFluxWithException().subscribe(ele -> System.out.println(ele),
//                err -> System.out.println(err.getMessage())
//        );

//        ReactiveSources.intNumbersFluxWithException()
//                .doOnError(e -> System.out.println("Error Happened"))
//                .subscribe(ele -> System.out.println(ele));

        // Print values from intNumbersFluxWithException and continue on errors
//        ReactiveSources.intNumbersFluxWithException()
//                .onErrorContinue((err, item) -> System.out.println("Error happened " + item))
//                .subscribe(ele -> System.out.println(ele));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(ele -> System.out.println(ele));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
