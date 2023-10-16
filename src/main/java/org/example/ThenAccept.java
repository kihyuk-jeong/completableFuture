package org.example;

import java.util.concurrent.CompletableFuture;

/**
 * thenAccept는 반환 값을 받아서 사용하고, 값을 반환하지는 않는 콜백이다.
 */
public class ThenAccept {

    public static void main(String[] args) {

        thenAccept();
    }

    private static void thenAccept() {
        CompletableFuture<Void> thenApplyAsync = CompletableFuture.supplyAsync(() -> getString("thenAccept"))
                .thenAccept(s -> System.out.println(s + " thenAccept!!"));

        thenApplyAsync.join();
    }

    public static String getString(String message) {
        return message + Thread.currentThread().getName();
    }
}