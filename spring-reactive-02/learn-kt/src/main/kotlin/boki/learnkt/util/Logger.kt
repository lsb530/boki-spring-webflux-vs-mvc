package boki.learnkt.util

import org.reactivestreams.Subscription
import org.slf4j.LoggerFactory

object Logger {
    private val log = LoggerFactory.getLogger(Thread.currentThread().stackTrace[1].className)

    fun info(data: Any?) {
        log.info("{}", data)
    }

    fun info(msg: String?, data: Any?) {
        log.info(msg, data)
    }

    fun info(msg: String?, data1: Any?, data2: Any?) {
        log.info(msg, data1, data2)
    }

    fun doOnNext(data: Any?) {
        log.info("# doOnNext(): {}", data)
    }

    fun doOnNext(data1: Any?, data2: Any?) {
        log.info("# doOnNext(): {} {}", data1, data2)
    }

    fun doOnNext(taskName: String, operator: String, data: Any?) {
        log.info("# doOnNext() {} {}: {}", taskName, operator, data)
    }

    fun doOnSubscribe() {
        log.info("# doOnSubscribe()")
    }

    fun doOnSubscribe(data: Subscription) {
        log.info("# doOnSubscribe() in {} thread", Thread.currentThread().name)
    }

    fun doFirst() {
        log.info("# doFirst()")
    }

    fun doFinally(data: Any?) {
        log.info("# doFinally(): {}", data)
    }

    fun doOnRequest() {
        log.info("# doOnRequest()")
    }

    fun doOnRequest(data: Any?) {
        log.info("# doOnRequest()")
    }

    fun doOnComplete() {
        log.info("# doOnComplete()")
    }

    fun doOnTerminate() {
        log.info("# doOnTerminate()")
    }

    fun doOnTerminate(data: Any?) {
        log.info("# doOnTerminate() - {}", data)
    }

    fun doAfterTerminate(operator: String) {
        log.info("# doAfterTerminate() {}", operator)
    }

    fun onNext(data: Any?) {
        log.info("# onNext(): {}", data)
    }

    fun onNext(data1: Any?, data2: Any?) {
        log.info("# onNext(): {} : {}", data1, data2)
    }

    fun onNext(message: String, data1: Any?, data2: Any?) {
        log.info("# onNext() {}: {} {}", message, data1, data2)
    }

    fun onNextDropped(data: Any?) {
        log.info("# onNextDropped(): {}", data)
    }

    fun onError(message: String) {
        log.error(message)
    }

    fun onError(error: Throwable?) {
        log.error("error happened: ", error)
    }

    fun onError(message: String, error: Throwable, data: Any?) {
        log.error(message, error, data)
    }

    fun onComplete() {
        log.info("# onComplete()")
    }

    fun onComplete(data: Any?) {
        log.info("# onComplete(): {}", data)
    }

    fun onNext(message: String?, data: Any?) {
        log.info("# {} onNext(): {}", message, data)
    }

    fun filter(data: Any?) {
        log.info("# filter(): {}", data)
    }

    fun map(data: Any?) {
        log.info("# map(): {}", data)
    }
}