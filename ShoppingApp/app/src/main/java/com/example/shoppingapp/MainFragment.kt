package com.example.shoppingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.shoppingapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var urunlerAdapter: UrunlerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Örnek ürünler listesi oluşturun
        val urunlerListesi = ArrayList<Urunler>()
        val u1 = Urunler(
            1, "iphone14", 830, "Iphone 14", 5.0, 171, 50,
            "The iPhone 14 is equipped with a powerful A15 Bionic chipset, providing users with excellent performance and speed. It features an amazing camera system, allowing you to capture photos and videos in outstanding quality. Additionally, the new iPhone model offers improved battery life and fast charging features, enabling you to use your phone for longer periods in your daily activities. The iPhone 14 also stands out with its stylish and elegant design, providing users with a high-quality experience."        )
        val u2 = Urunler(
            2, "nike", 100, "Nike Retro", 4.7, 97, 51,
            "Nike's retro sneaker collection combines iconic designs from the past with a nostalgic touch and today's fashion. This collection stands out with classic models such as Air Max, Dunk, and Air Jordan. Nike sneakers in retro style blend timeless elegance with modern details, offering sports enthusiasts a unique style. They are a perfect choice for those looking to rediscover their style."        )
        val u3 = Urunler(
            3, "kursunkalem", 2, "Pencil", 4.5, 41, 52,
            "Pencil is a widely used tool in writing and drawing, creating clean and sharp lines. Its ability to capture various tones with different hardness grades makes it popular among artists and students."        )

        urunlerListesi.add(u1)
        urunlerListesi.add(u2)
        urunlerListesi.add(u3)

        // UrunlerAdapter'ı oluşturun ve RecyclerView ile ilişkilendirin
        urunlerAdapter = UrunlerAdapter(requireContext(), urunlerListesi)

        // RecyclerView'ı Staggered Grid Layout Manager ile yapılandırın
        binding.RvHome.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        // RecyclerView'a adapter'ı bağlayın
        binding.RvHome.adapter = urunlerAdapter


    }
}
