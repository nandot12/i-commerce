package com.imastudio.guanzhuli.icart.signIn.model

import com.google.gson.annotations.SerializedName

data class ResponseLogin(

	@field:SerializedName("pesan")
	val pesan: String? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)