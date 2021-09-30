package com.beok.mockwebserversample

import com.squareup.moshi.Moshi
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.io.File

class FooServiceTest {
    private lateinit var server: MockWebServer
    private lateinit var service: FooService

    @BeforeEach
    fun setup() {
        server = MockWebServer()
        service = Retrofit
            .Builder()
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi
                        .Builder()
                        .build()
                )
            )
            .baseUrl(server.url(""))
            .build()
            .create()
    }

    @Test
    fun `foo 요청`() {
        val response = MockResponse()
            .setBody(File("src/test/resources/foo.json").readText())
        server.enqueue(response = response)

        val actual = service
            .getFoo()
            .execute()
            .body()

        val expected = Foo(foo = 1, bar = "baz", isFoo = true)
        assertThat(actual).isEqualTo(expected)
    }
}
