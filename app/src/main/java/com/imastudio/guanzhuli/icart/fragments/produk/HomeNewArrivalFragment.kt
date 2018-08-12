package com.imastudio.guanzhuli.icart.fragments.produk

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.imastudio.guanzhuli.icart.R
import com.imastudio.guanzhuli.icart.fragments.produk.adapter.ProdukAdapter
import com.imastudio.guanzhuli.icart.fragments.produk.model.DataItem
import com.imastudio.guanzhuli.icart.fragments.produk.presenter.ProdukPresenterImp
import com.imastudio.guanzhuli.icart.fragments.produk.view.ProdukView
import kotlinx.android.synthetic.main.tablayout_arrival.*

/**
 * Created by Guanzhu Li on 12/31/2016.
 */
//todo 49 implement view
class HomeNewArrivalFragment : Fragment(),ProdukView {

    //todo 50
    var progress : ProgressDialog? = null
    var presenter : ProdukPresenterImp? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.tablayout_arrival, container, false)


        //todo 51
        progress = ProgressDialog(activity)
        presenter = ProdukPresenterImp(this)

        //hei
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter?.produkRecent()
    }

    override fun showLoading() {
        //todo 52
        progress?.show()
    }

    override fun hideLoading() {
        progress?.dismiss()
    }

    override fun onSuccess(data: List<DataItem?>?, msg: String, status: Boolean) {
        //todo 53
        if(status){
            recycler_arrival_container.adapter = ProdukAdapter(data)

            recycler_arrival_container.layoutManager = GridLayoutManager(activity,2)


        }
    }

    override fun onError(msg: String) {
    }
}

