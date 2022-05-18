package com.sennohananto.retrofitkoin.di

import com.sennohananto.retrofitkoin.ui.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MainActivityViewModel)
}