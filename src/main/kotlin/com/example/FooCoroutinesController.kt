package com.example

import kotlinx.coroutines.flow.Flow
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/coroutines")
class FooCoroutinesController(private val fooService: FooCoroutinesService) {

	@PostMapping("/create-one")
	suspend fun createOne() {
		fooService.createMessage()
	}

	@PostMapping("/create-two")
	suspend fun createTwo() {
		fooService.createMessages()
	}

	@GetMapping("/find")
	suspend fun find(): List<Foo> {
		return fooService.findMessages()
	}

	@GetMapping("/find-flow")
	suspend fun findFlow(): Flow<Foo> {
		return fooService.findMessagesFlow()
	}

}