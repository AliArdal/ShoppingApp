package com.example.shoppingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingapp.databinding.CardTasarimBinding

class UrunlerAdapter(private val mContext: Context, private val urunlerListesi: List<Urunler>) : RecyclerView.Adapter<UrunlerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(val tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val urun = urunlerListesi.get(position)
        val t = holder.tasarim
        val view = holder.itemView

        t.imageViewItem1.setImageResource(mContext.resources.getIdentifier(urun.resim, "drawable", mContext.packageName))
        t.fiyatText.text = "${urun.fiyat} ₺"
        t.titleText.text = urun.title
        t.ratingText.text = urun.rating.toString()

        t.imageViewItem1.setOnClickListener {
            val gecis = MainFragmentDirections.actionMainFragmentToDetayFragment(urun = urun)
            Navigation.findNavController(it).navigate(gecis)
        }



    }

    override fun getItemCount(): Int {
        return urunlerListesi.size
    }
}
