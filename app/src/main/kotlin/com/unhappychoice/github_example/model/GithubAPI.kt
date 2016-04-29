package com.unhappychoice.github_example.model

import retrofit.http.GET
import rx.Observable

interface GithubAPI {
    @GET("/users")
    fun users(): Observable<List<Map<String, Any>>>
}
