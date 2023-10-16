package org.example;

import java.util.concurrent.CompletableFuture;

/**
 * 가장 빨리 끝난 1개의 작업에 대해서만 콜백이 실행된다.
 */

public class AnyOf {

    public static void main(String[] args) {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "Hello";
        });

        CompletableFuture<String> mangKyu = CompletableFuture.supplyAsync(() -> {
            return "ki hyuk";
        });

        CompletableFuture<Void> future = CompletableFuture.anyOf(hello, mangKyu).thenAccept(System.out::println);
        future.join();
    }
}
