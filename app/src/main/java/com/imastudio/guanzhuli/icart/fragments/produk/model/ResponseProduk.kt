package com.imastudio.guanzhuli.icart.fragments.produk.model

import com.google.gson.annotations.SerializedName

data class ResponseProduk(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)