package boki.learnjava.scheduler.parallel;

import boki.learnjava.util.Logger;
import reactor.core.publisher.Flux;

/**
 * parallel()만 사용할 경우에는 병렬로 작업을 수행하지 않는다.
 */
public class ParallelEx1 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15})
            .parallel()
            .subscribe(Logger::onNext);
    }
}
