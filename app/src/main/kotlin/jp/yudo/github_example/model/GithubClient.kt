package jp.yudo.github_example.model

import retrofit.RestAdapter
import retrofit.http.GET
import rx.Observable

/**
 * Created by uekiyuuji on 15/03/23.
 */

public class GithubClient {

    /**
     * returns Users Observable
     * @return users : List<Any>
     */
    public fun usersObservable() : Observable<List<Map<String, Any>>>{
        val adapter = RestAdapter.Builder().setEndpoint(END_POINT).build()
        val client = adapter.create(javaClass<GithubAPI>())
        return client.users()
    }

    private val END_POINT = "https://api.github.com"
}

private trait GithubAPI {
    [GET("/users")]
    fun users(): Observable<List<Map<String, Any>>>
}
