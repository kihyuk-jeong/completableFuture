package org.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * allOf 로 묶인 future 들의 실행이 완료될 때 까지 기다린다.
 */
public class AllOf {
    public static void main(String[] args) {

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Hello";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "KI HYUK!";
        });

        // case 1. 리턴값 없는 케이스
        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(future, future2);
        allOfFuture.join();

        // case 2. 리턴값 존재하는 케이스
        List<CompletableFuture<String>> futures = List.of(future, future2);
        CompletableFuture<List<String>> listCompletableFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .thenApply(v -> futures.stream().
                        map(CompletableFuture::join).
                        collect(Collectors.toList()));

        listCompletableFuture.join()
                .forEach(System.out::println);

    }
}
