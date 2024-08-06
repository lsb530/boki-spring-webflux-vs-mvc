package boki.learnjava.scheduler.parallel;

import boki.learnjava.util.Logger;
import boki.learnjava.util.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * - parallel()만 사용할 경우에는 병렬로 작업을 수행하지 않는다.
 * - runOn()을 사용해서 Scheduler를 할당해주어야 병렬로 작업을 수행한다.
 * - CPU 코어 갯수내에서 worker thread를 할당한다
 */
public class ParallelEx3 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19})
            .parallel()
            .runOn(Schedulers.parallel())
            .subscribe(Logger::onNext);

        TimeUtils.sleep(100L);
    }
}
