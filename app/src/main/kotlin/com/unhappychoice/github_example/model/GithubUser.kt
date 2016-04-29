package com.unhappychoice.github_example.model

import rx.Observable
import rx.Subscriber

/**
 * Created by uekiyuuji on 15/03/26.
 */

class GithubUser {
    companion object {
        fun fetchUserLoginNames() : Observable<List<String>> {
            return Observable.create { observer: Subscriber<in List<String>?> ->
                val client = GithubClient();
                client.fetchUsers().subscribe( { users : List<Map<String, Any>> ->
                    observer.onNext(loginNamesFrom(users))
                    observer.onCompleted()
                }, { error : Throwable ->
                    observer.onError(error)
                });
            }
        }

        private fun loginNamesFrom(users : List<Map<String, Any>>) : List<String> {
            return users.map { user : Map<String, Any> ->
                user["login"] as String
            }
        }
    }
}

