package com.example

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class FooReactiveService(private val fooRepository: FooReactiveRepository) {

	@Transactional
	fun createMessages(): Mono<Void> {
		return fooRepository.save(Foo("this is a test!")).then(fooRepository.save(Foo("this is a test2!"))).then()
	}

	@Transactional
	fun createMessage(): Mono<Foo> {
		return fooRepository.save(Foo("this is a test!"))
	}

	fun findMessages(): Flux<Foo> {
		return fooRepository.findAll()
	}
}