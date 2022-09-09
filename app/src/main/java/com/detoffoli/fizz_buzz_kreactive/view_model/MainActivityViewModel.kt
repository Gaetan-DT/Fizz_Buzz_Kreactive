package com.detoffoli.fizz_buzz_kreactive.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.detoffoli.fizz_buzz_kreactive.data.FizzBuzz

class MainActivityViewModel : ViewModel() {

    private val mMutableFizzBuzz = MutableLiveData<FizzBuzz>()

    fun updateValue(fizzBuzz: FizzBuzz) {
        mMutableFizzBuzz.postValue(fizzBuzz)
    }

    fun getFizzBuzz(): LiveData<FizzBuzz> {
        return this.mMutableFizzBuzz
    }

}