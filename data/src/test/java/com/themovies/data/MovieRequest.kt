package com.themovies.data

import androidx.annotation.MainThread
import com.squareup.okhttp.mockwebserver.Dispatcher
import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.MockWebServer
import com.squareup.okhttp.mockwebserver.RecordedRequest
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File
import java.net.HttpURLConnection


class MovieRequest {
    lateinit var mockServer: MockWebServer
    lateinit var repository: MovieRepository

    @Before
    fun setUp() {
        mockServer = MockWebServer()
        mockServer.setDispatcher(dispatcher)
        repository = MovieRepositoryImpl(
            ApiClientProivider.getMoviesApiClient(),
            "https://api.themoviedb.org/3/"
        )
    }

    @After
    fun clear() {
        mockServer.shutdown()
    }

    @Test
    @MainThread
    fun `get movies api request`() {
        val response = MockResponse()
        response
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(getJson("movies.json"))
        mockServer.enqueue(response)
        repository.getMovies(550).test()
//        mockHttpResponse(mockServer, "movies.json", HttpURLConnection.HTTP_OK)
//        mockServer.enqueue(
//            MockResponse()
//                .setResponseCode(HttpURLConnection.HTTP_OK)
//                .setBody(getJson("filename"))
//        )
//        mockServer.start()
//        val baseUrl = mockServer.url("/v1/chat/")
//        DataEntityMovies()

    }

    private fun getJson(path: String): String {
        val uri = this.javaClass.classLoader?.getResource(path)
        val file = File(uri?.path.orEmpty())
        return String(file.readBytes())
    }

    private fun mockHttpResponse(mockServer: MockWebServer, fileName: String, responseCode: Int) =
        mockServer.enqueue(
            MockResponse()
                .setResponseCode(responseCode)
                .setBody(getJson(fileName))
        )

    private val dispatcher = object : Dispatcher() {
        override fun dispatch(request: RecordedRequest?): MockResponse {
            return when (request?.path) {
                "3/movie/500/recommendations" -> MockResponse().setBody(getJson("movies.json"))
                else -> MockResponse().setResponseCode(404)
            }
        }
    }
}
