# completableFuture

### Future 
- Future 는 Java5 에서 추가 되었으며, 비동기 작업에 대한 결과값 처리가 가능하다.
- 하지만 Future 는 여러가지 한계가 존재한다.
- 외부에서 완료시킬 수 없고, get 메소드 (블로킹) 을 통해서만 이후의 결과를 처리할 수 있었다.
- 또한 여러 개의 Future 작업을 조합하여 실행할 수 없었다.

### CompletableFuture
- Future 의 단점을 보완하여 Java 8 에 출시되었으며, 마찬가지로 비동기 작업에 대한 결과값 처리가 가능하다.
- 여러 비동기 작업들을 조합하여 실행할 수 있고, 예외 처리 기능 또한 제공한다.
- 작업을 완료시키는 메소드가 get() 외에 Join() 이 추가되었다.
- 다양한 콜백 기능을 제공한다.
 

### CompletableFuture 주요 메소드
- runAsync : CompletableFuture 로 감싼 메소드를 비동기로 실행하며, 해당 메소드의 반환값이 존재하지 않는 경우 또는 필요 없는 경우에 사용
- suuplyAsync : CompletableFuture 로 감싼 메소드를 비동기로 실행하며, 해당 메소드가 반환값이 존재하는 경우 사용
- thenApply : CompletableFuture 로 감싼 메소드의 실행 결과를 받아서, 다른 값을 반환하는 콜백 (파라미터로 Function)
- thenAccept : CompletableFuture 로 감싼 메소드의 실행 결과를 사용하되, 콜백 메소드의 리턴 타입이 Void (파라미터로 consumer)
- thenRun : 반환 값을 받지 않고, 다른 작업을 실행한다. 주로 비동기 작업을 완료한 후 바로 새로운 작업을 실행하고 싶을 때 사용한다. (비동기 작업 이후 로깅 또는 알림 전송 등)
- thenCompose : 두 작업을 이어서 실행하도록 조합하고, 앞선 작업 (먼저 실행된 작업) 의 결과를 받아서 두 번째 작업에 사용할 수 있다.
- thenCombine : 두 작업을 독립적으로 실행하고, 두 작업이 모두 완료 되었을 때 콜백을 실행하낟.
- allOf : 비동기 작업을 여러 개 동시에 실행하고, 모든 작업 결과에 대해 콜백을 실행한다. (또는 모든 작업이 완료될 때 까지 기다리는 용도로 사용할 수 있다.)
- anyOf : 여러 작업들 중 가장 빨리 끝난 하나의 결과에 대해 콜백을 실행한다.
- exeptionally : 비동기 작업 실행 중 발생한 에러를 받아서 예외를 처리한다.
- handle : (결과,에러) 를 받아서, 에러가 발생한 경우와 성공적으로 처리된 경우 (상황에 따라) 모두를 처리할 수 있다.

### get vs join
- completableFuture 로 실행한 작업의 결과를 가져오는 메소드는 get() 과 join() 이 존재한다.
- get() 메소드는 CompletableFuter 이전에 Future 에서 주로 사용하던 메소드로, 비동기로 메소드를 실행하던 중 예외가 발생하면 현재 스레드를 차단한다. 즉, 스레드가 인터럽트 되어 실행이 중지되며 Checked Exception 인 ExecutionException 과 InterruptedException 을 던진다. 따라서 try-catch 로 해당 메소드를 묶어주거나, throws 키워드를 통해 상위 메소드로 예외 처리를 위임해야 한다.
- join() 메소드는 CompletableFuter 와 함께 등장한 메소드로, 비동기 처리에 대한 결과를 가져오는 get() 과 근본적인 기능은 동일하지만 get() 과 다르게 비동기 작업 중 발생한 예외를 unChecked Exception 으로 처리한다. 따라서 예외가 발생하여도 해당 스레드가 인터럽트 되지 않으며 try-catch 블록으로 감싸지 않고도 사용할 수 있다.

**결론: CompletableFuter 를 사용하는 경우 join() 을 사용하자.**

reference : https://brunch.co.kr/@springboot/267
