package com.imastudio.guanzhuli.icart.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.imastudio.guanzhuli.icart.R

/**
 * Created by Guanzhu Li on 1/4/2017.
 */
class OrderSuccessFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_order_success, container, false)
    }
}
