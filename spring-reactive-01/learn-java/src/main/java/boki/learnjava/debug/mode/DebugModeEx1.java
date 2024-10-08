package boki.learnjava.debug.mode;

import boki.learnjava.util.Logger;
import reactor.core.publisher.Flux;

/**
 * Non-Debug mode
 */
public class DebugModeEx1 {
    public static void main(String[] args) {
        Flux.just(2, 4, 6, 8)
            .zipWith(Flux.just(1, 2, 3, 0), (x, y) -> x / y)
            .subscribe(Logger::onNext, Logger::onError);
    }
}
