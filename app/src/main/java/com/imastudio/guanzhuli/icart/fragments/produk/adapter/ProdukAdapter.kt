package com.imastudio.guanzhuli.icart.fragments.produk.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.imastudio.guanzhuli.icart.R
import com.imastudio.guanzhuli.icart.detail.DetailProdukActivity
import com.imastudio.guanzhuli.icart.fragments.produk.model.DataItem
import com.imastudio.guanzhuli.icart.utils.Constans
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardview_product_grid.view.*
import kotlinx.android.synthetic.main.fragment_item_detail.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.wrapContent

/**
 * Created by nandoseptianhusni on 26/07/18.
 */
//todo 54 membuat adapter
class ProdukAdapter(var data : List<DataItem?>?) : RecyclerView.Adapter<ProdukAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {

        //todo 55 get layout item
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.cardview_product_grid,parent,false)

        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        //todo 56 hitung jumlah data item,data yg muncul tergantung dari item count array
        return data?.size!!
    }

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
    //todo 57 bawa nilai di holder dan set nilai ke view di view holder
        holder?.bind(data?.get(position))


        //todo 64
        holder?.itemView?.setOnClickListener {

            var datas = data?.get(position)
            //todo 65 passing data
            holder.itemView.context.startActivity<DetailProdukActivity>(Constans.name to datas?.produkNama,
                    Constans.stock to datas?.produkTotal,Constans.harga to datas?.produkHarga,Constans.photo to datas?.produkPhoto)
        }

    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: DataItem?) {
            //todo 58
            itemView.item_grid_price.text = get?.produkHarga
            itemView.item_grid_id.text = "Stock : " + get?.produkTotal + " Buah"


            //todo 59
            Picasso.with(itemView.context).load("http://192.168.95.58/gambar/"+ get?.produkPhoto).into(itemView.item_details_image)



        }

    }
}