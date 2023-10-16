package org.example;

import java.util.concurrent.CompletableFuture;

public class ThenRun {

    public static void main(String[] args) {

            /**
            * thenRun은 반환 값을 받지도 않고, 소비하지도 않는 콜백이다.
            */

            thenRunAsync();

    }

    private static void thenRunAsync() {
        CompletableFuture<Void> thenRunAsync = CompletableFuture.supplyAsync(() -> getString("thenRun"))
                .thenRun(() -> System.out.println("thenRunAsync!!"));

        thenRunAsync.join();
    }

    public static String getString(String message) {
        return message + Thread.currentThread().getName();
    }
}