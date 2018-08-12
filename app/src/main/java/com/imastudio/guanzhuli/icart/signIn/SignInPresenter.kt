package com.imastudio.guanzhuli.icart.signIn

import com.imastudio.guanzhuli.icart.network.ConfigRetrofit
import com.imastudio.guanzhuli.icart.signIn.model.ResponseLogin
import com.imastudio.guanzhuli.icart.signUp.model.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by nandoseptianhusni on 26/07/18.
 */
//todo 37 implement login presenter
class SignInPresenter(var signInView: SignInView) :SingInPresenterImp{



    override fun login(hp : String, password : String){

        signInView.showLoading()


        ConfigRetrofit.service.login(password,hp)
                .enqueue(object :Callback<ResponseLogin>{
                    override fun onFailure(call: Call<ResponseLogin>?, t: Throwable?) {

                        signInView.hideLoading()
                        signInView.onError(t?.message!!)
                    }

                    override fun onResponse(call: Call<ResponseLogin>?, response: Response<ResponseLogin>?) {
                    //response
                        val responseJson = response?.body()
                        //pesan dan status
                        val pesan = responseJson?.pesan
                        val status = responseJson?.status
                        //check apakah true atau false
                        if(status!!){//kalau true berrti login berhasil dan tampil data user yg login
                            //data user yang login
                            val dataUser = responseJson.data

                            signInView.hideLoading()
                            signInView.onSuccess(pesan!!,status,dataUser!!)
                        }
                        else{
                            signInView.onError(pesan!!)
                        }




                    }
                })

    }

    override fun loginGoogle(email: String, name: String) {
        //TODO 38
        ConfigRetrofit.service.loginGoogle(name,email)
                .enqueue(object :Callback<SignUpResponse>{
                    override fun onFailure(call: Call<SignUpResponse>?, t: Throwable?) {

                        //TODO 39
                        signInView.onError(t?.message!!)
                    }

                    override fun onResponse(call: Call<SignUpResponse>?, response: Response<SignUpResponse>?) {


                        //TODO 40 get response user
                        val pesan = response?.body()?.pesan
                        val status = response?.body()?.status

                        //todo 41 tambah funtion interface baru
                        signInView.onSucessGoogle(pesan,status)
                    }
                })
    }
}