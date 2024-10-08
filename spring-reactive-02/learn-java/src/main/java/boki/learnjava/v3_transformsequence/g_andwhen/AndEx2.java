package boki.learnjava.v3_transformsequence.g_andwhen;

import boki.learnjava.utils.Logger;
import boki.learnjava.utils.TimeUtils;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * and 활용 예제
 *  - 2 개의 task가 모두 끝났을 때, Complete Signal을 전달해서 추가 task를 수행하는 예제
 */
public class AndEx2 {
    public static void main(String[] args) {
        restartApplicationServer()
            .and(restartDBServer()) // Mono<Void> emit -> complete 시그널만 호출
            .subscribe(
                Logger::onNext,
                Logger::onError,
                () -> Logger.onComplete("Send an email to Administrator: " +
                    "All Servers are restarted successfully")
            );

        TimeUtils.sleep(6000L);
    }

    private static Mono<String> restartApplicationServer() {
        return Mono
            .just("Application Server was restarted successfully.")
            .delayElement(Duration.ofSeconds(2))
            .doOnNext(Logger::doOnNext);
    }

    private static Publisher<String> restartDBServer() {
        return Mono
            .just("DB Server was restarted successfully.")
            .delayElement(Duration.ofSeconds(4))
            .doOnNext(Logger::doOnNext);
    }
}
