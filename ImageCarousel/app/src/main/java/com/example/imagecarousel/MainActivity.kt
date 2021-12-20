package com.example.imagecarousel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.imagecarousel.databinding.ActivityMainBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var listAdapter: ListItemAdapter
    private lateinit var viewModel: CarouselViewModel
    private lateinit var itemAdapter:CarouselAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this).get(CarouselViewModel::class.java)

        binding.carouselView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        itemAdapter = CarouselAdapter()
        itemAdapter.setItems(viewModel.getItemListForCarousel())
        binding.carouselView.adapter = itemAdapter


        //for search view
        initSearchView()

        // for list items below
        initInfoRecyclerView()

        binding.carouselView
            .addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if(newState == RecyclerView.SCROLL_STATE_IDLE) {
                        val pos: Int =
                            (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                        changeInfoList(pos)
                    }
                }
            })
    }

    private fun changeInfoList(pos: Int) {
        listAdapter.setList(viewModel.getInfoListForCarousel(pos))

    }

    private fun initSearchView() {
        binding.searchBar.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(newText: String?): Boolean {

                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    filter(newText)
                    return false
                }

            })

    }

    private fun filter(text: String?) {

        val filteredList: ArrayList<Item> = ArrayList()

        for (item in viewModel.getInfoListToSearch()) {
            // checking if the entered string matched with any item of our recycler view.
            if (item.title.lowercase().contains(text!!.lowercase())) {
                filteredList.add(item)
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            listAdapter.setList(filteredList)
        }
    }

    private fun initInfoRecyclerView(){
        binding.infoList.layoutManager = LinearLayoutManager(this)
        listAdapter = ListItemAdapter()
        listAdapter.setList(viewModel.getInfoListForCarousel(0))
        binding.infoList.adapter = listAdapter
    }

}

