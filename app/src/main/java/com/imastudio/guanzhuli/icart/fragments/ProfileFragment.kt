package com.imastudio.guanzhuli.icart.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.android.volley.RequestQueue
import com.imastudio.guanzhuli.icart.R


class ProfileFragment : Fragment() {
    private val mRequestQueue: RequestQueue? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


}
