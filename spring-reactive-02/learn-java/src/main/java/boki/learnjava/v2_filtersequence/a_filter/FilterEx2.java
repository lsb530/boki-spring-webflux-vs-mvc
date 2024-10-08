package boki.learnjava.v2_filtersequence.a_filter;

import boki.learnjava.common.SampleData;
import boki.learnjava.utils.Logger;
import reactor.core.publisher.Flux;

/**
 * 비트코인의 연간 최고가격이 1000만원을 넘는 연도와 가격을 필터링하는 예제
 */
public class FilterEx2 {
    public static void main(String[] args) {
        Flux
            .fromIterable(SampleData.btcTopPricesPerYear)
            .filter(tuple -> tuple.getT2() > 10_000_000)
            .subscribe(filtered -> Logger.onNext(filtered.getT1() + ":" + filtered.getT2()));
    }
}
