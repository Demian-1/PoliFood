package mx.ipn.escom.acuaytes.polifood.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import mx.ipn.escom.acuaytes.polifood.R

class Product (
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val price: Double,
    val desc: String
){

}

val products = listOf(
    Product(R.drawable.cafe, "Cafe", 20.0, "Cafe de grano molido"),
    Product(R.drawable.cappuccino, "Cappuccino", 30.0, "Cappuccino con grano molido"),
    Product(R.drawable.choco,  "Chocolate", 30.0, "Chocolate caliente con leche"),
    Product(R.drawable.galletas, "Galletas", 12.0, "Galletas del costco"),
    Product(R.drawable.pastel, "Pastel", 40.0, "Pastel del costco"),
    Product(R.drawable.sandwich, "Sandwich", 50.0, "Sandwich de jamon")
)