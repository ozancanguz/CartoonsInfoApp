package com.ozancanguz.cartoonsinfoapp.ui.fragments.cartoonlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.cartoonsinfoapp.R
import com.ozancanguz.cartoonsinfoapp.adapter.CartoonAdapter
import com.ozancanguz.cartoonsinfoapp.databinding.FragmentCartoonListBinding
import com.ozancanguz.cartoonsinfoapp.viewmodels.CartoonViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CartoonListFragment : Fragment() {
    private var _binding: FragmentCartoonListBinding? = null
    private val binding get() = _binding!!
    private val cartoonAdapter=CartoonAdapter()


    private val cartoonViewModel:CartoonViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartoonListBinding.inflate(inflater, container, false)
        val view = binding.root


        // observe data and update ui
        //observeLiveData()

        // list from database called
        listFromDatabase()

        // set up rv
        binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=cartoonAdapter



        return view
    }


        private fun listFromDatabase(){
          lifecycleScope.launch {
            cartoonViewModel.listcartoons.observe(viewLifecycleOwner, Observer { database ->
                 if(database.isNotEmpty()){
                     Log.d("cartoonlistfragment", "database called")
                     cartoonAdapter.setData(database[0].cartoon)
                 }else{
                     // request from api

                     Log.d("cartoonlistfragment","request from api called")
                     observeLiveData()
                 }
            })
          }
        }



    // retrofit
    private fun observeLiveData() {
        cartoonViewModel.requestApiData()
        cartoonViewModel.cartoonList.observe(viewLifecycleOwner, Observer {cartoonList ->
           cartoonAdapter.setData(cartoonList)
        })
    }


    // if there is no internet load from database first
    private fun loadDataFromCache() {
        lifecycleScope.launch {
            cartoonViewModel.listcartoons.observe(viewLifecycleOwner) { database ->
                if (database.isNotEmpty()) {
                    cartoonAdapter.setData(database[0].cartoon)
                }
            }
        }
    }


}