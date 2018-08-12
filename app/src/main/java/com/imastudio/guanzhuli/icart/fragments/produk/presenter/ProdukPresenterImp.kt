package com.imastudio.guanzhuli.icart.fragments.produk.presenter

import com.imastudio.guanzhuli.icart.fragments.produk.model.ResponseProduk
import com.imastudio.guanzhuli.icart.fragments.produk.view.ProdukView
import com.imastudio.guanzhuli.icart.network.ConfigRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by nandoseptianhusni on 26/07/18.
 */
//todo 44
class ProdukPresenterImp(var produkView: ProdukView) : ProdukPresenter{


    override fun produk() {

        produkView.showLoading()
        //todo 45
        ConfigRetrofit.service.produk().enqueue(object :Callback<ResponseProduk>{
            override fun onFailure(call: Call<ResponseProduk>?, t: Throwable?) {

                //todo 47
                produkView.hideLoading()
                produkView.onError(t?.message!!)
            }

            override fun onResponse(call: Call<ResponseProduk>?, response: Response<ResponseProduk>?) {


                produkView.hideLoading()
                if (response?.isSuccessful!!){

                    val pesan = response.body()?.pesan
                    val status = response.body()?.status
                    val data = response.body()?.data
                    //todo 48
                    produkView.onSuccess(data,pesan!!,status!!)


                }

            }
        })

    }


    override fun produkRecent() {

        produkView.showLoading()
        //todo 45
        ConfigRetrofit.service.produkRecent().enqueue(object :Callback<ResponseProduk>{
            override fun onFailure(call: Call<ResponseProduk>?, t: Throwable?) {

                //todo 47
                produkView.hideLoading()
                produkView.onError(t?.message!!)
            }

            override fun onResponse(call: Call<ResponseProduk>?, response: Response<ResponseProduk>?) {


                produkView.hideLoading()
                if (response?.isSuccessful!!){

                    val pesan = response.body()?.pesan
                    val status = response.body()?.status
                    val data = response.body()?.data
                    //todo 48
                    produkView.onSuccess(data,pesan!!,status!!)


                }

            }
        })

    }
}