package com.imastudio.guanzhuli.icart.signIn.model

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("user_alamat")
	val userAlamat: String? = null,

	@field:SerializedName("user_status")
	val userStatus: String? = null,

	@field:SerializedName("user_nama")
	val userNama: String? = null,

	@field:SerializedName("user_email")
	val userEmail: String? = null,

	@field:SerializedName("user_password")
	val userPassword: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("user_nohp")
	val userNohp: String? = null,

	@field:SerializedName("user_register_time")
	val userRegisterTime: String? = null
)