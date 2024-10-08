package boki.learnjava.v3_transformsequence.g_andwhen;

import boki.learnjava.utils.Logger;
import boki.learnjava.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * when 기본 개념 예제
 *  - 파라미터로 입력된 Publisher들이 종료할 때 까지 대기한 후, Mono<Void>를 반환한다.
 */
public class WhenEx1 {
    public static void main(String[] args) {
        Mono
            .when(
                Flux
                    .just("Hi", "Tom")
                    .delayElements(Duration.ofSeconds(2))
                    .doOnNext(Logger::doOnNext),
                Flux
                    .just("Hello", "David")
                    .delayElements(Duration.ofSeconds(1))
                    .doOnNext(Logger::doOnNext)
            )
            .subscribe(
                Logger::onNext,
                Logger::onError,
                Logger::onComplete
            );

        TimeUtils.sleep(5000);
    }
}
