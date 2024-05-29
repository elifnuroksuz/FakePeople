package com.elifnuroksuz.busonolsun.view.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.elifnuroksuz.busonolsun.R
import com.elifnuroksuz.busonolsun.adapter.ProductAdapter
import com.elifnuroksuz.busonolsun.databinding.FragmentHomeBinding
import com.elifnuroksuz.busonolsun.util.ApplicationViewModelFactory
import com.elifnuroksuz.busonolsun.viewmodel.MainViewModel


class HomeFragment : Fragment() {



   private val viewModel : MainViewModel by viewModels {
       ApplicationViewModelFactory(requireActivity().application)
   }


    private lateinit var binding : FragmentHomeBinding

    //////////////////////////////////////////////////////////////////
    /*private var countryAdapter = ProductAdapter(arrayListOf()){position ->
        //findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment())
    }*/





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home,container, false)



        binding.countryRV.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getDataFromAPI()
        setObservers()
        return binding.root
    }



    @SuppressLint("SuspiciousIndentation")
    private fun setObservers(){
        viewModel.countryData.observe(viewLifecycleOwner) { list ->
            val  countryAdapter = ProductAdapter(arrayListOf()){position ->
            //findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(list[position]))
            }
            binding.countryRV.adapter = countryAdapter

                countryAdapter.updateList(list)
            ////////////////////////////////
            viewModel.insertAll(list)
        }





        viewModel.countryLoad.observe(viewLifecycleOwner) { loading ->
            if (loading) {
                binding.loadingPB.visibility = View.VISIBLE
            } else {
                binding.loadingPB.visibility = View.GONE
            }
        }
        viewModel.countryError.observe(viewLifecycleOwner) { error ->
            if (error) {
                binding.errorTV.visibility = View.VISIBLE
            } else {
                binding.errorTV.visibility = View.GONE
            }
        }

    }

}