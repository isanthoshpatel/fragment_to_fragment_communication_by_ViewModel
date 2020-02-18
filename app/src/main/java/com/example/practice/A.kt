package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.layout_a.*
import kotlinx.android.synthetic.main.layout_a.view.*
import kotlinx.android.synthetic.main.layout_b.*
import kotlinx.android.synthetic.main.layout_b.et1

class A : Fragment(){
lateinit var viewModel:ViewModelEx
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var v = inflater.inflate(R.layout.layout_a,container,false)
        v.bt1.setOnClickListener {
            viewModel.text.value = et1.text.toString()
        }
        return  v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!).get(ViewModelEx::class.java)
        viewModel.text.observe(viewLifecycleOwner, Observer { et1.setText(it) })

    }
}