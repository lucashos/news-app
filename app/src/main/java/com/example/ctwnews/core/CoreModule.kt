package com.example.ctwnews.core

import org.koin.dsl.module

val coreModule = module {
    factory { Network().retrofit }
}