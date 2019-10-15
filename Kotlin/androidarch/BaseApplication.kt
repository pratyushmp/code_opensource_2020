package com.example.androidarch

import android.app.Application
import com.example.androidarch.data.db.AppDatabase
import com.example.androidarch.data.network.MyApi
import com.example.androidarch.data.network.NetworkConnectionInterceptor
import com.example.androidarch.data.repository.UserRepository
import com.example.androidarch.ui.auth.authViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class BaseApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy{

        import(androidXModule(this@BaseApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { authViewModelFactory(instance()) }

    }
}