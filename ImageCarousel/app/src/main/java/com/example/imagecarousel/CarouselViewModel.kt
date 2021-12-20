package com.example.imagecarousel

import androidx.lifecycle.ViewModel

class CarouselViewModel:ViewModel(){

    private var carouselPosition = 0

    private val possibleItems = listOf(
        Item("Airplanes", R.drawable.ic_airplane),
        Item("Cars", R.drawable.ic_car),
        Item("Food", R.drawable.ic_food),
        Item("Gas", R.drawable.ic_gas),
        Item("Home", R.drawable.ic_home)
    )

    private val carousel0Items = listOf(
        Item("Airplane_1", R.drawable.ic_airplane),
        Item("Airplanes_2", R.drawable.ic_airplane),
        Item("Airplanes_3", R.drawable.ic_airplane),
        Item("Airplanes_4", R.drawable.ic_airplane),
        Item("Airplanes_5", R.drawable.ic_airplane),
        Item("Airplanes_6", R.drawable.ic_airplane),
        Item("Airplanes_7", R.drawable.ic_airplane),
        Item("Airplanes_8", R.drawable.ic_airplane),
    )
    private val carousel1Items = listOf(
        Item("Car_1", R.drawable.ic_car),
        Item("Car_2", R.drawable.ic_car),
        Item("Car_3", R.drawable.ic_car),
        Item("Car_4", R.drawable.ic_car),
        Item("Car_5", R.drawable.ic_car),
        Item("Car_6", R.drawable.ic_car),
        Item("Car_7", R.drawable.ic_car),
        Item("Car_8", R.drawable.ic_car),
    )
    private val carousel2Items = listOf(
        Item("Food_1", R.drawable.ic_food),
        Item("Food_2", R.drawable.ic_food),
        Item("Food_3", R.drawable.ic_food),
        Item("Food_4", R.drawable.ic_food),
        Item("Food_5", R.drawable.ic_food),
        Item("Food_6", R.drawable.ic_food),
        Item("Food_7", R.drawable.ic_food),
        Item("Food_8", R.drawable.ic_food),
    )
    private val carousel3Items = listOf(
        Item("Gas_1", R.drawable.ic_gas),
        Item("Gas_2", R.drawable.ic_gas),
        Item("Gas_3", R.drawable.ic_gas),
        Item("Gas_4", R.drawable.ic_gas),
        Item("Gas_5", R.drawable.ic_gas),
        Item("Gas_6", R.drawable.ic_gas),
        Item("Gas_7", R.drawable.ic_gas),
        Item("Gas_8", R.drawable.ic_gas),
    )
    private val carousel4Items = listOf(
        Item("Home_1", R.drawable.ic_home),
        Item("Home_2", R.drawable.ic_home),
        Item("Home_3", R.drawable.ic_home),
        Item("Home_4", R.drawable.ic_home),
        Item("Home_5", R.drawable.ic_home),
        Item("Home_6", R.drawable.ic_home),
        Item("Home_7", R.drawable.ic_home),
        Item("Home_8", R.drawable.ic_home),
    )

    fun getInfoListForCarousel(position:Int):List<Item>{
        carouselPosition = position
        return when(position){
            0-> getLargeListOfItems(carousel0Items)
            1-> getLargeListOfItems(carousel1Items)
            2-> getLargeListOfItems(carousel2Items)
            3-> getLargeListOfItems(carousel3Items)
            4-> getLargeListOfItems(carousel4Items)
            else-> getLargeListOfItems(carousel0Items)
        }
    }

    fun getInfoListToSearch():List<Item> {
        return getInfoListForCarousel(carouselPosition)
    }

    fun getItemListForCarousel():List<Item>{
        return possibleItems
    }

    private fun getLargeListOfItems(list:List<Item>): List<Item> {
        val items = mutableListOf<Item>()
        (0..20).map { items.add(list.random()) }
        return items
    }

}