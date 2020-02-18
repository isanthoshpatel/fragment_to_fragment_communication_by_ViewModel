package com.example.practice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelEx : ViewModel() {

    var text = MutableLiveData<String>()
}