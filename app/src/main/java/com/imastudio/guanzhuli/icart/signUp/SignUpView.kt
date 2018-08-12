package com.imastudio.guanzhuli.icart.signUp

/**
 * Created by nandoseptianhusni on 25/07/18.
 */
//TODO 9 bikin interface untuk angkut informasi di presenter ke activity
interface SignUpView {

    //if jika berhasil insert ke server
    fun onSuccess(msg : String, status : Boolean)

    fun onError(msg : String)
}