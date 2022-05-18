package com.sennohananto.retrofitkoin.di

import com.sennohananto.retrofitkoin.data.Repository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::Repository)
}