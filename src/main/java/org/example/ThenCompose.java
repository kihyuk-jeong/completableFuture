package org.example;

import java.util.concurrent.CompletableFuture;

/**
 * thenCompose는 두 작업을 서로 이어서 실행되게 한다.
 * 앞선 작업의 결과를 받아서 사용할 수 있다.
 * 두 작업이 서로 의존적이라면 thenCompose 를 사용할 수 있다.
 */

public class ThenCompose {

    public static void main(String[] args) {

        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> "User123");
        CompletableFuture<String> stringCompletableFuture = userFuture.thenCompose(ThenCompose::getOrderHistory);

        stringCompletableFuture.join();
    }

    public static CompletableFuture<String> getOrderHistory(String userInfo) {
        return CompletableFuture.supplyAsync(() -> "Order history for " + userInfo);
    }
}
