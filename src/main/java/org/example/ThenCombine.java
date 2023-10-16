package org.example;

import java.util.concurrent.CompletableFuture;

/**
 * thenCombine은 각각의 작업들이 독립적으로 실행되고, 얻어진 두 결과를 조합해서 작업을 처리한다.
 */

public class ThenCombine {

    public static void main(String[] args) {

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        });

        CompletableFuture<String> stringCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            return "KI HYUK!";
        });

        CompletableFuture<String> result = stringCompletableFuture.thenCombine(stringCompletableFuture2, (x, y) -> x + " " + y);

        System.out.println(result.join());
    }
}
