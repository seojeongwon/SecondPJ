package jw.seo.kotlin.ex01.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var isTrue = ObservableField(false)
    var text = "MainViewModel"
}