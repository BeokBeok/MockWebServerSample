package com.beok.mockwebserversample

import retrofit2.Call

interface FooService {
    // Error occur
    fun getFoo(): Call<Foo>
}
