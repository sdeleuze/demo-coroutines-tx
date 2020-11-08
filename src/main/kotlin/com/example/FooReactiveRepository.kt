package com.example

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface FooReactiveRepository : ReactiveCrudRepository<Foo, String>