package com.ozancanguz.cartoonsinfoapp.ui.fragments.cartoonlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ozancanguz.cartoonsinfoapp.R
import com.ozancanguz.cartoonsinfoapp.databinding.FragmentCartoonListBinding


class CartoonListFragment : Fragment() {
    private var _binding: FragmentCartoonListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartoonListBinding.inflate(inflater, container, false)
        val view = binding.root


        binding.textView.setOnClickListener {
            findNavController().navigate(R.id.action_cartoonListFragment_to_detailsFragment)
        }



        return view
    }


}