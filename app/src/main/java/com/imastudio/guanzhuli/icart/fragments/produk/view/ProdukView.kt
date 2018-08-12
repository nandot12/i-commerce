package com.imastudio.guanzhuli.icart.fragments.produk.view

import com.imastudio.guanzhuli.icart.fragments.produk.model.DataItem

/**
 * Created by nandoseptianhusni on 26/07/18.
 */
//todo 46
interface ProdukView {


    fun showLoading()
    fun hideLoading()
    fun onSuccess(data : List<DataItem?>?, msg : String,status :Boolean)
    fun onError(msg : String)


}