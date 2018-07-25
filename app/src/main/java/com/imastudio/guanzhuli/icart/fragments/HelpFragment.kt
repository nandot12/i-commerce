package com.imastudio.guanzhuli.icart.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Button
import android.widget.EditText

import com.imastudio.guanzhuli.icart.R

/**
 * A simple [Fragment] subclass.
 */
class HelpFragment : Fragment() {
    internal var mButtonConfirm: Button? = null
    internal var mEditSubject: EditText? = null
    internal var mEditContent: EditText? = null

    override fun onResume() {
        super.onResume()
        activity!!.title = "Help"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_help, container, false)
    }


}// Required empty public constructor
