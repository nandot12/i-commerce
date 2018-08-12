package com.imastudio.guanzhuli.icart.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.imastudio.guanzhuli.icart.R
import com.imastudio.guanzhuli.icart.utils.Constans
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_produk.*

class DetailProdukActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_produk)

        //todo 68
        val img = intent.getStringExtra(Constans.photo)
        val name = intent.getStringExtra(Constans.name)
        val harga = intent.getStringExtra(Constans.harga)
        val stock =intent.getStringExtra(Constans.stock)


        item_grid_name.text = name
        item_grid_price.text = harga
        item_grid_id.text = stock

        Picasso.with(this).load("http://192.168.95.50/gambar/"+img)
                .into(item_grid_image)
    }
}
