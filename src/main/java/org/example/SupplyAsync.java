package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SupplyAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

            /**
            * supplyAsync : 반환 값이 있는 비동기 실행
            */
            supplyAsyncJoin();
            supplyAsyncGet();
    }

    private static void supplyAsyncJoin() {

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> getString("supplyAsync"));
        System.out.println(supplyAsync.join());

    }

    private static void supplyAsyncGet() throws ExecutionException, InterruptedException {
        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> getString("supplyAsync"));
        System.out.println(supplyAsync.get());

    }

    public static String getString(String message) {
        return message + Thread.currentThread().getName();
    }

}
