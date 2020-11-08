package com.example

import org.springframework.data.annotation.Id

data class Foo(val message: String, @Id val id: Int? = null)