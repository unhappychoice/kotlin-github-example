package jp.yudo.github_example.controller

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import jp.yudo.github_example.R
import jp.yudo.github_example.model.GithubUser

public class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GithubUser.fetchUserLoginNames().subscribe({ userNames : List<String> ->
            setUsersToListView(userNames)
        } , { error : Throwable ->
            Log.e("MainActivity", error.toString())
        })
    }

    private fun setUsersToListView(names: List<String>) {
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        adapter.addAll(names)

        runOnUiThread {
            val usersList  = findViewById(R.id.users) as ListView
            usersList.setAdapter(adapter)
        }
    }
}