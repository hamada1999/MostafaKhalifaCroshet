package com.example.mostafakhalifacroshet.viewModels

import android.app.Application
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.Observable
import androidx.lifecycle.AndroidViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.mostafakhalifacroshet.adapters.ProductsRecyclerAdapter
import com.example.mostafakhalifacroshet.adapters.ViewPagerAdapter
import com.example.mostafakhalifacroshet.data.ProductRepository
import com.google.android.material.tabs.TabLayout


class HomeViewModel(app:Application) : AndroidViewModel(app) , Observable {

    private val context = getApplication<Application>().applicationContext
    private val productRepo = ProductRepository(app)
    val productData = productRepo.productDataList

    @Bindable
    lateinit var personalName : String


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}