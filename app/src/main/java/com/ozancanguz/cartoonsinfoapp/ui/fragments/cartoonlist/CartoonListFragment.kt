package com.ozancanguz.cartoonsinfoapp.ui.fragments.cartoonlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ozancanguz.cartoonsinfoapp.R
import com.ozancanguz.cartoonsinfoapp.databinding.FragmentCartoonListBinding
import com.ozancanguz.cartoonsinfoapp.viewmodels.CartoonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartoonListFragment : Fragment() {
    private var _binding: FragmentCartoonListBinding? = null
    private val binding get() = _binding!!

    private val cartoonViewModel:CartoonViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartoonListBinding.inflate(inflater, container, false)
        val view = binding.root


        observeLiveData()



        return view
    }

    private fun observeLiveData() {
        cartoonViewModel.requestApiData()
        cartoonViewModel.cartoonList.observe(viewLifecycleOwner, Observer {
            Log.d("cartoonFragment"," " +it)
        })
    }


}