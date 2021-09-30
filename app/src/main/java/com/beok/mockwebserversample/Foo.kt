package com.beok.mockwebserversample

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Foo(
    @Json(name = "foo")
    val foo: Int,

    @Json(name = "bar")
    val bar: String,

    @Json(name = "isFoo") // Error occur
    val isFoo: Boolean
)
