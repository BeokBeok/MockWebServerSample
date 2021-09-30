package com.beok.mockwebserversample

import retrofit2.http.GET

interface FooService {
    @GET("foo/")
    suspend fun getFoo(): Foo
}
