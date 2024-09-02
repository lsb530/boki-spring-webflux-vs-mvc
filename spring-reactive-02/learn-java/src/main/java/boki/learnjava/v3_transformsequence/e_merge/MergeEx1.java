package boki.learnjava.v3_transformsequence.e_merge;

import boki.learnjava.utils.Logger;
import boki.learnjava.utils.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * merge 기본 개념 예제
 *  - 파라미터로 입력된 Publisher Sequence에서 emit된 데이터를 emit된 시간이 빠른 순서대로 merge한다.
 */
public class MergeEx1 {
    public static void main(String[] args) {
        Flux
            .merge(
                Flux.just(1, 2, 3).delayElements(Duration.ofMillis(300L)),
                Flux.just(4, 5, 6).delayElements(Duration.ofMillis(500L))
            )
            .subscribe(Logger::onNext);
        // 예상결과: 1, 4, 2, 3, 5, 6 -> ok

        TimeUtils.sleep(3500L);
    }
}
