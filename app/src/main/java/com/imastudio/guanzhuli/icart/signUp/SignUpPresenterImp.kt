package com.imastudio.guanzhuli.icart.signUp

import android.util.Log
import com.imastudio.guanzhuli.icart.network.ConfigRetrofit
import com.imastudio.guanzhuli.icart.signUp.model.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//TODO 10 constructor interface
class SignUpPresenterImp(var sigUpview : SignUpView) {



    //TODO 1 bikin presenter function
    //kita butuh analisa,kira2 activity kirim apa dan berpa bnyk data
    fun signUp(name : String ,email : String ,
               alamat : String,password : String,confirm : String, hp : String){


        //TODO 2 check kondisi
        if (name != "" && email != "" && alamat != "" && password != "" && confirm != ""
        && hp != ""){

            //TODO 4 check password sama confir pass
            if(password == confirm){

            //TODO 3 insert to server
           val config =  ConfigRetrofit.service

                //TODO 5 ambil response dari insert apa enggak
            config.requestSign(name,email,password,alamat,hp)
                    .enqueue(object :Callback<SignUpResponse>{
                        override fun onFailure(call: Call<SignUpResponse>?, t: Throwable?) {
                            //TODO 6 cetak di log untuk pesan error
                            Log.d("error register",t?.message)
                            //TODO 11 SET VIEW ERROR
                            sigUpview.onError("server error")
                        }

                        override fun onResponse(call: Call<SignUpResponse>?, response: Response<SignUpResponse>?) {


                            if(response?.isSuccessful!!) {

                                //TODO 7 ambil response jsonnya
                                val allJson = response?.body()

                                //pesan dan status
                                val msg = allJson?.pesan
                                val sttus = allJson?.status

                                // TODO 8 check status


                                //TODO 12 set onSuccess
                                sigUpview.onSuccess(msg!!, sttus!!)

                            }
                            else{

                                sigUpview.onError("null")
                            }



                        }
                    })

                            }else{
                                     //TODO 13 set not valid pass
                                        sigUpview.onError("not match password")


            }
        }
        else {
            //TODO 14 set error kalau ada yang kosong
            sigUpview.onError("tidak boleh ada kosong,please")
        }
    }
}