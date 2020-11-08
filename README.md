Demo project for Spring Coroutines `@Transactional` support.

Current issue: [#25998](https://github.com/spring-projects/spring-framework/issues/25998) @Transactional on suspending function returning a value always rollbacks. To reproduce:

Reactive returning no value works as expected.
```
http POST http://localhost:8080/reactive/create-two

Initializing transaction synchronization
Getting transaction for [com.example.FooReactiveService.createMessages]
Completing transaction for [com.example.FooReactiveService.createMessages]
Clearing transaction synchronization
```

Reactive returning a value works as expected.
```
http POST http://localhost:8080/reactive/create-one

Initializing transaction synchronization
Getting transaction for [com.example.FooReactiveService.createMessage]
Completing transaction for [com.example.FooReactiveService.createMessage]
Clearing transaction synchronization
```

Coroutines returning no value works as expected. 
```
http POST http://localhost:8080/coroutines/create-two

Initializing transaction synchronization
Getting transaction for [com.example.FooCoroutinesService.createMessages]
Completing transaction for [com.example.FooCoroutinesService.createMessages]
Clearing transaction synchronization
```

Coroutines returning a value does not work as expected (always rollbacks).
```
http POST http://localhost:8080/coroutines/create-one

Initializing transaction synchronization
Getting transaction for [com.example.FooCoroutinesService.createMessage]
Rolling back transaction for [com.example.FooCoroutinesService.createMessage] after cancellation
Clearing transaction synchronization
```