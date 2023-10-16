package org.example;

import java.util.concurrent.CompletableFuture;

/**
 * thenApply는 값을 받아서 다른 값을 반환시켜주는 콜백이다.
 */

public class ThenApply {

    public static void main(String[] args) {

        thenApplyAsync();

    }

    private static void thenApplyAsync() {
        CompletableFuture<String> thenApplyAsync = CompletableFuture.supplyAsync(() -> getString("thenApply"))
                .thenApply(s -> s + " thenApplyAsync!!");

        System.out.println(thenApplyAsync.join());

    }

    public static String getString(String message) {
        return message + Thread.currentThread().getName();
    }

}
