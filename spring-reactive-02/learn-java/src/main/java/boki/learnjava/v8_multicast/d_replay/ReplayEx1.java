package boki.learnjava.v8_multicast.d_replay;

import boki.learnjava.utils.Logger;
import boki.learnjava.utils.TimeUtils;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * replay() 개념 예제
 *  - 다수의 Subscriber와 Flux를 공유한다.
 *  - Cold Sequence를 Hot Sequence로 변환한다.
 *  - connect()가 호출 되기 전 까지는 데이터를 emit하지 않는다.
 *  - 구독 시점 이 전에 emit된 데이터를 모두 캐시한다.
 */
public class ReplayEx1 {
    public static void main(String[] args) {
        ConnectableFlux<Integer> flux =
            Flux
                .range(1, 5)
                .delayElements(Duration.ofMillis(300L))
                .replay();

        TimeUtils.sleep(500L);
        flux.subscribe(data -> Logger.onNext("subscriber1: ", data));

        TimeUtils.sleep(200L);
        flux.subscribe(data -> Logger.onNext("subscriber2: ", data));

        flux.connect();

        TimeUtils.sleep(1000L);
        // 한꺼번에 전달받음(replay로 인해) -> 1, 2, 3
        flux.subscribe(data -> Logger.onNext("subscriber3: ", data));

        TimeUtils.sleep(2000L);
    }
}
