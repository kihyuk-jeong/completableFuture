package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RunAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /**
         * runAsync : 반환 값이 없는 void 타입의 비동기 실행
         */

        runAsyncJoin();
        runAsyncGet();
    }

    private static void runAsyncGet() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> System.out.println(getString("runAsync")));
        runAsync.get();
    }

    private static void runAsyncJoin() {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> System.out.println(getString("runAsync")));
        runAsync.join();
    }

    public static String getString(String message) {
        return message + Thread.currentThread().getName();
    }

}