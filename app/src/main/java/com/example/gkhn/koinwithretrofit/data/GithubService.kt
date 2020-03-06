package com.example.gkhn.koinwithretrofit.data

import com.example.gkhn.koinwithretrofit.data.model.Repo
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user:String):Deferred<Response<List<Repo>>>
}