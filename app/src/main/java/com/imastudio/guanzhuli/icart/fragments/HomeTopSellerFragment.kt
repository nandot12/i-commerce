package com.imastudio.guanzhuli.icart.fragments

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.imastudio.guanzhuli.icart.R

/**
 * Created by Guanzhu Li on 12/31/2016.
 */
class HomeTopSellerFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.tablayout_home, container, false)
    }
}
