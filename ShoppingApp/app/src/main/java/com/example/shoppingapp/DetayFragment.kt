package com.example.shoppingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.shoppingapp.databinding.FragmentDetayBinding
import com.example.shoppingapp.databinding.FragmentMainBinding

class DetayFragment : Fragment() {
    private lateinit var binding : FragmentDetayBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetayBinding.inflate(inflater, container, false)

        val bundle : DetayFragmentArgs by navArgs()
        val urun = bundle.urun

        binding.esyaResim.setImageResource(resources.getIdentifier(urun.resim, "drawable",requireContext().packageName))
        binding.fiyatText.text = "${urun.fiyat} $"
        binding.titleText.text = "${urun.title}"
        binding.ratingText.text = "${urun.rating}"
        binding.detayText.text = "${urun.detay}"
        binding.degerlendirmeText.text = "${urun.degerlendirme}"




        return binding.root
    }

}