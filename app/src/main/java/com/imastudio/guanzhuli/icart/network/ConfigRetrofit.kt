package com.imastudio.guanzhuli.icart.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit



/**
 * Created by nandoseptianhusni on 25/07/18.
 */
object ConfigRetrofit {

//    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//    logging.setLevel(Level.BASIC);
//    OkHttpClient client = new OkHttpClient.Builder()
//    .addInterceptor(logging)
//    .build();


    //TODO 61 configurasi interceptor okhttp
    var logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    var client = OkHttpClient.Builder().addInterceptor(logging).build()



    var retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.95.50/market_server/index.php/Server/")
            .addConverterFactory(GsonConverterFactory.create())
            //TODO 62 Hubungkan dengan retrofit
            .client(client)
            .build()

    var service = retrofit.create<ApiService>(ApiService::class.java!!)


}