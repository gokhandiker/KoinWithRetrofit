package com.example.gkhn.koinwithretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gkhn.koinwithretrofit.R
import com.example.gkhn.koinwithretrofit.data.GitHubServiceAPI
import com.example.gkhn.koinwithretrofit.data.GithubService
import com.example.gkhn.koinwithretrofit.data.model.Repo
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    val serviceAPI : GitHubServiceAPI by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val githubService: GithubService = serviceAPI.getGithubService()

        CoroutineScope(Dispatchers.IO).launch {
            val request =  githubService.listRepos("gokhandiker")

            withContext(Dispatchers.IO) {
                try {
                    val response = request.await()
                    if (response.isSuccessful) {

                        var data : List<Repo>? = response.body();

                        Log.e("MainActicity",
                            "Success ${data?.size} Repos Found")

                    } else {

                        Log.e("MainActicity",
                            "Error : Status ${response.code()} ")

                    }
                } catch (e: Exception) {
                    Log.e("MainActicity",
                        "Exception ${e.message}")

                }
            }
        }
    }
}
