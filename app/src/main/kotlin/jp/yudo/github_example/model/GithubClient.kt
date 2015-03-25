package jp.yudo.github_example.model

import retrofit.RestAdapter
import retrofit.http.GET
import rx.Observable

/**
 * Created by uekiyuuji on 15/03/23.
 */

class GithubClient {

    public fun fetchUsers() : Observable<List<Map<String, Any>>>{
        val adapter = RestAdapter.Builder().setEndpoint(_endPoint).build()
        val client = adapter.create(javaClass<GithubAPI>())
        return client.users()
    }

    private val _endPoint = "https://api.github.com"
}