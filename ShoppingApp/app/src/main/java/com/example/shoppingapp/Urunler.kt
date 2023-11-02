package com.example.shoppingapp

import java.io.Serializable

data class Urunler (var id : Int,
                    var resim : String ,
                    var fiyat : Int,
                    var title : String,
                    var rating : Double,
                    var degerlendirme : Int,
                    var numberInCart: Int ,
                    var detay : String ) : Serializable {
}