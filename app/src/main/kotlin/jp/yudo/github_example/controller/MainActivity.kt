package jp.yudo.github_example.controller

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import jp.yudo.github_example.R
import jp.yudo.github_example.model.GithubClient

public class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchUsers()
    }

    private fun fetchUsers() {
        val client = GithubClient();
        client.usersObservable().subscribe( { users : List<Map<String, Any>> ->
            setUsersToListView(users)
        }, { error : Any ->
            println(error.toString())
        });
    }

    private fun setUsersToListView(users: List<Map<String, Any>>) {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        adapter.addAll(loginNamesFrom(users))
        setAdapterToLView(adapter)
    }

    private fun setAdapterToLView(adapter : ArrayAdapter<String>) {
        runOnUiThread {
            val usersList  = findViewById(R.id.users) as ListView
            usersList.setAdapter(adapter)
        }
    }

    private fun loginNamesFrom(users : List<Map<String, Any>>) : List<String> {
        return users.map { user : Map<String, Any> ->
            user["login"] as String
        }
    }
}