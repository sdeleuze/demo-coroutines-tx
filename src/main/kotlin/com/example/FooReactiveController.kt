package com.example

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/reactive")
class FooReactiveController(private val fooService: FooReactiveService) {

	@PostMapping("/create-one")
	fun createOne(): Mono<Foo> {
		return fooService.createMessage()
	}

	@PostMapping("/create-two")
	fun createTwo(): Mono<Void> {
		return fooService.createMessages()
	}

	@GetMapping("/find")
	fun find(): Flux<Foo> {
		return fooService.findMessages()
	}
}