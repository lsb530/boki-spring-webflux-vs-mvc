package boki.learnjava.v2_filtersequence.c_skipext;

import boki.learnjava.utils.Logger;
import boki.learnjava.utils.TimeUtils;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * 파라미터로 입력된 Publisher가 onNext 또는 onComplete signal을 발생시킬 때까지 Upstream에서 emit된 데이터를 건너뜀
 */
public class SkipExtendedEx3 {
    public static void main(String[] args) {
        Flux
            .interval(Duration.ofSeconds(1))
            .skipUntilOther(doSomeTask())
            .subscribe(Logger::onNext);

        TimeUtils.sleep(4000L);
    }

    private static Publisher<?> doSomeTask() {
        return Mono.delay(Duration.ofMillis(2500));
    }
}
