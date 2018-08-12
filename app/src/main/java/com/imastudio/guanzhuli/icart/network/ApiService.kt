package com.imastudio.guanzhuli.icart.network

import com.imastudio.guanzhuli.icart.fragments.produk.model.ResponseProduk
import com.imastudio.guanzhuli.icart.signIn.model.ResponseLogin
import com.imastudio.guanzhuli.icart.signUp.model.SignUpResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by nandoseptianhusni on 25/07/18.
 */
interface ApiService {



    @FormUrlEncoded
    @POST("register")
    fun requestSign(@Field("name")name : String,
                    @Field("email") email : String,
                    @Field("password") password : String,
                    @Field("alamat") alamat :String,
                    @Field("nohp") nohp : String):Call<SignUpResponse>


    @FormUrlEncoded
    @POST("login")
    fun login(@Field("password") password : String,
              @Field("nohp") nohp : String):Call<ResponseLogin>


    //todo 35 login google request
    @FormUrlEncoded
    @POST("loginGoogle")
    fun loginGoogle(@Field("name")name : String,
              @Field("email") email : String):Call<SignUpResponse>


    //todo 42
    @GET("getProduk")
        fun produk():Call<ResponseProduk>


    @GET("getProdukRecent")
    fun produkRecent():Call<ResponseProduk>


}