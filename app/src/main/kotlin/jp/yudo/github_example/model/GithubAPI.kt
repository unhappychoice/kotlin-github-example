package jp.yudo.github_example.model

import retrofit.http.GET
import rx.Observable

/**
 * Created by uekiyuuji on 15/03/26.
 */
trait GithubAPI {
    [GET("/users")]
    fun users(): Observable<List<Map<String, Any>>>
}
