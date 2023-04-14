package com.example.smartlight.di

import com.example.smartlight.data.network.PhillipsHueApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * Provides the necessary dependencies for the network such as [provideNYTApiService] &
 * [provideNYTApiKey]
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNYTApiService(): PhillipsHueApiService {
        val client = OkHttpClient.Builder().ignoreAllSSLErrors()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS).build();
        return Retrofit.Builder().baseUrl("https://192.168.86.119/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhillipsHueApiService::class.java)
    }



    @Singleton
    @Provides
    @Named("phillips_apikey")
    fun provideNYTApiKey(): String{
        return "KcILknKbQqAyXpaSXmtrisaUoqOti2JGq3PZDDmO"
    }
}

fun OkHttpClient.Builder.ignoreAllSSLErrors(): OkHttpClient.Builder {
    val naiveTrustManager = object : X509TrustManager {
        override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
        override fun checkClientTrusted(certs: Array<X509Certificate>, authType: String) = Unit
        override fun checkServerTrusted(certs: Array<X509Certificate>, authType: String) = Unit
    }

    val insecureSocketFactory = SSLContext.getInstance("TLSv1.2").apply {
        val trustAllCerts = arrayOf<TrustManager>(naiveTrustManager)
        init(null, trustAllCerts, SecureRandom())
    }.socketFactory

    sslSocketFactory(insecureSocketFactory, naiveTrustManager)
    hostnameVerifier(HostnameVerifier { _, _ -> true })
    return this
}
