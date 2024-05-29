package com.elifnuroksuz.busonolsun.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.elifnuroksuz.busonolsun.R
import com.elifnuroksuz.busonolsun.databinding.FragmentDetailBinding
import com.elifnuroksuz.busonolsun.util.ApplicationViewModelFactory
import com.elifnuroksuz.busonolsun.viewmodel.MainViewModel


class DetailFragment : Fragment() {

    val args: DetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailBinding


    private val viewModel : MainViewModel by viewModels {
        ApplicationViewModelFactory(requireActivity().application)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail,container, false)
        viewModel.findByName(args.country.name)
        initUI()
        return binding.root
    }
    private fun initUI() {
        //val country = args.country
        viewModel.country.observe(viewLifecycleOwner){
            country ->
            with(binding){
                tvCountryName.text =country.name
                tvCapital.text =country.username
                tvLanguage.text=country.email
                tvRegion.text=country.website
        }

    }
    }



}