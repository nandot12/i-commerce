package com.imastudio.guanzhuli.icart.signIn

import com.imastudio.guanzhuli.icart.signIn.model.Data

/**
 * Created by nandoseptianhusni on 26/07/18.
 */
interface SignInView {

    fun showLoading()

    fun hideLoading()

    fun onSuccess(pesan : String,status : Boolean,data : Data)

    fun onError(msg : String)
    fun onSucessGoogle(pesan: String?, status: Boolean?)
}