package com.detoffoli.fizz_buzz_kreactive.view_adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.detoffoli.fizz_buzz_kreactive.view_holder.FizzBuzzResultHolder

class FizzBuzzResultAdapter : ListAdapter<String, FizzBuzzResultHolder>(StringDiff()) {

    companion object {
        class StringDiff: DiffUtil.ItemCallback<String>() {

            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FizzBuzzResultHolder {
        return FizzBuzzResultHolder.create(parent)
    }

    override fun onBindViewHolder(holder: FizzBuzzResultHolder, position: Int) {
        holder.bind(getItem(position))
    }

}