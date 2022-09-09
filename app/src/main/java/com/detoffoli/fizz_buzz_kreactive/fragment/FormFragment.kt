package com.detoffoli.fizz_buzz_kreactive.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.detoffoli.fizz_buzz_kreactive.R
import com.detoffoli.fizz_buzz_kreactive.data.FizzBuzz
import com.detoffoli.fizz_buzz_kreactive.databinding.FragmentFormBinding
import com.detoffoli.fizz_buzz_kreactive.view_model.MainActivityViewModel

class FormFragment : Fragment() {

    private lateinit var mBinding: FragmentFormBinding
    private lateinit var mMainViewModel : MainActivityViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        this.mBinding = FragmentFormBinding.inflate(inflater, container, false)
        return this.mBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.mMainViewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]
        this.mMainViewModel.getFizzBuzz().observe(viewLifecycleOwner) { this.fillBinding(it) }
        this.mBinding.fragFormBtnDisplayResult.setOnClickListener {
            if (this.fieldValid()) {
                this.mMainViewModel.updateValue(this.generateFizzBuzz())
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            } else
                Toast.makeText(context, "All field must be filled !", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fillBinding(fizzBuzz: FizzBuzz) {
        this.mBinding.fragFormNum1.setText(fizzBuzz.number1.toString())
        this.mBinding.fragFormNum2.setText(fizzBuzz.number2.toString())
        this.mBinding.fragFormWord1.setText(fizzBuzz.word1)
        this.mBinding.fragFormWord2.setText(fizzBuzz.word2)
        this.mBinding.fragFormLimit.setText(fizzBuzz.limit.toString())
    }

    private fun fieldValid(): Boolean {
        return !(this.mBinding.fragFormNum1.text.toString().isEmpty() ||
                this.mBinding.fragFormNum2.text.toString().isEmpty() ||
                this.mBinding.fragFormWord1.text.toString().isEmpty() ||
                this.mBinding.fragFormWord2.text.toString().isEmpty() ||
                this.mBinding.fragFormLimit.text.toString().isEmpty())
    }

    private fun generateFizzBuzz(): FizzBuzz {
        return FizzBuzz(
            this.mBinding.fragFormNum1.text.toString().toIntOrNull() ?: 3,
            this.mBinding.fragFormNum2.text.toString().toIntOrNull() ?: 7,
            this.mBinding.fragFormWord1.text.toString(),
            this.mBinding.fragFormWord2.text.toString(),
            this.mBinding.fragFormLimit.text.toString().toIntOrNull() ?: 10
        )
    }
}