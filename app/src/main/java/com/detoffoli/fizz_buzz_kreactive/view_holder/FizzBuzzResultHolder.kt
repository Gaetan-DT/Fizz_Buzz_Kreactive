package com.detoffoli.fizz_buzz_kreactive.view_holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.detoffoli.fizz_buzz_kreactive.databinding.LayStringBinding

class FizzBuzzResultHolder(private val binding: LayStringBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create(parent: ViewGroup): FizzBuzzResultHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = LayStringBinding.inflate(inflater, parent, false)
            return FizzBuzzResultHolder(binding)
        }
    }

    fun bind(str: String) {
        this.binding.layStringTv.text = str
    }

}