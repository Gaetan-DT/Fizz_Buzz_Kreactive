package com.detoffoli.fizz_buzz_kreactive.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.detoffoli.fizz_buzz_kreactive.R
import com.detoffoli.fizz_buzz_kreactive.databinding.FragmentFizzBuzzResultBinding
import com.detoffoli.fizz_buzz_kreactive.view_adapter.FizzBuzzResultAdapter
import com.detoffoli.fizz_buzz_kreactive.view_model.MainActivityViewModel

class FizzBuzzResultFragment : Fragment() {

    private lateinit var mBinding: FragmentFizzBuzzResultBinding
    private lateinit var mMainViewModel : MainActivityViewModel
    private lateinit var mFizzBuzzResultAdapter: FizzBuzzResultAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        this.mBinding = FragmentFizzBuzzResultBinding.inflate(inflater, container, false)
        return this.mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.mMainViewModel = ViewModelProvider(requireActivity())[MainActivityViewModel::class.java]
        this.mMainViewModel.getFizzBuzz().observe(viewLifecycleOwner) { this.mFizzBuzzResultAdapter.submitList(it.getStrListResult()) }
        this.mFizzBuzzResultAdapter = FizzBuzzResultAdapter()
        this.mBinding.fragFizzBuzzResultRecyclerView.adapter = this.mFizzBuzzResultAdapter
        this.mBinding.fragFizzBuzzResultRecyclerView.addItemDecoration(DividerItemDecoration(context,
            this.mBinding.fragFizzBuzzResultRecyclerView.layoutDirection))
        this.mBinding.fragFizzBuzzResultBtnPrevious.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }
}