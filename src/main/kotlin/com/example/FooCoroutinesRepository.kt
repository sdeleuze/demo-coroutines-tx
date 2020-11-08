package com.example

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface FooCoroutinesRepository : CoroutineCrudRepository<Foo, String>