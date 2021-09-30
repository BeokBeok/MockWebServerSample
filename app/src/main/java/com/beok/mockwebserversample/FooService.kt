package com.beok.mockwebserversample

import retrofit2.Call
import retrofit2.http.GET

interface FooService {
    @GET("foo/")
    fun getFoo(): Call<Foo>
}
