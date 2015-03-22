package jp.yudo.github_example

import android.app.Activity
import android.os.Bundle
import jp.yudo.github_example.model.GithubClient
import java.util.HashMap

public class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchUsers()
    }

    private fun fetchUsers() {
        val client = GithubClient();
        client.usersObservable().subscribe( { users : List<Map<String, Any>> ->
            users.forEach { user : Map<String, Any> ->
                println(user["login"].toString())
            }
        }, { error : Any ->
            println(error.toString())
        });
    }
}
