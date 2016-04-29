package com.unhappychoice.github_example.model

import retrofit.RestAdapter
import rx.Observable

class GithubClient {
    fun fetchUsers() : Observable<List<Map<String, Any>>>{
        val adapter = RestAdapter.Builder().setEndpoint(_endPoint).build()
        val client = adapter.create(GithubAPI::class.java)
        return client.users()
    }

    private val _endPoint = "https://api.github.com"
}