package com.ozancanguz.cartoonsinfoapp.ui.fragments.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.cartoonsinfoapp.R
import com.ozancanguz.cartoonsinfoapp.databinding.FragmentDetailsBinding
import com.ozancanguz.cartoonsinfoapp.utils.Utils.Companion.loadImage


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null

    private val binding get() = _binding!!

        private val args:DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        updateui()




        return view
    }

    private fun updateui() {
        binding.detailsImg.loadImage(args.currentCartoon.avatar)
        binding.detailsnameTextView.text=args.currentCartoon.name
        binding.detailsmessageTextview.text=args.currentCartoon.location
        binding.designationTextview.text=args.currentCartoon.designation
    }


}