package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.layout_a.*
import kotlinx.android.synthetic.main.layout_a.et1
import kotlinx.android.synthetic.main.layout_b.*
import kotlinx.android.synthetic.main.layout_b.view.*

class B : Fragment() {
    lateinit var viewmodel:ViewModelEx
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.layout_b,container,false)
        v.bt1.setOnClickListener {
           viewmodel.text.value = et1.text.toString()
        }
        return v
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewmodel = ViewModelProviders.of(activity!!).get(ViewModelEx::class.java)
        viewmodel.text.observe(viewLifecycleOwner, Observer { et1.setText(it) })

    }
}