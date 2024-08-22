package boki.learnkt.v2_filtersequence.b_skip

import boki.learnkt.util.Logger
import boki.learnkt.util.TimeUtils
import reactor.core.publisher.Flux
import java.time.Duration

/**
 * skip 기본 개념 예제
 *  - 파라미터로 입력한 시간만큼 Upstream에서 emit되는 데이터를 건너뛴 후, 건너뛴 다음 데이터부터 Downstream으로 emit
 */
fun main() {
    Flux
        .interval(Duration.ofSeconds(1))
        .skip(Duration.ofMillis(2500))
        .subscribe { Logger.onNext(it) }

    TimeUtils.sleep(5000L)
}