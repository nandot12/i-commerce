package com.imastudio.guanzhuli.icart.fragments.produk.model

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("produk_kategori")
	val produkKategori: String? = null,

	@field:SerializedName("produk_total")
	val produkTotal: String? = null,

	@field:SerializedName("produk_harga")
	val produkHarga: String? = null,

	@field:SerializedName("produk_nama")
	val produkNama: String? = null,

	@field:SerializedName("produk_id")
	val produkId: String? = null,

	@field:SerializedName("produk_tanggal_masuk")
	val produkTanggalMasuk: String? = null,

	@field:SerializedName("produk_photo")
	val produkPhoto: String? = null
)