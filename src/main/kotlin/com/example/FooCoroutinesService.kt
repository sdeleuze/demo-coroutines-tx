package com.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@Service
class FooCoroutinesService(private val fooRepository: FooCoroutinesRepository) {

	@Transactional
	suspend fun createMessages() {
		fooRepository.save(Foo("this is a test!"))
		fooRepository.save(Foo("this is a test!"))
	}

	@Transactional
	suspend fun createMessage(): Foo {
		return fooRepository.save(Foo("this is a test!"))
	}

	@Transactional
	suspend fun findMessages(): List<Foo> {
		delay(10)
		return fooRepository.findAll().toList()
	}

	@Transactional
	suspend fun findMessagesFlow(): Flow<Foo> {
		delay(10)
		return fooRepository.findAll()
	}
}