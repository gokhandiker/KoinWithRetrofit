package com.example.gkhn.koinwithretrofit.di

import com.example.gkhn.koinwithretrofit.data.GitHubServiceAPI
import org.koin.dsl.module

val appModules = module {
    single { GitHubServiceAPI() }
}