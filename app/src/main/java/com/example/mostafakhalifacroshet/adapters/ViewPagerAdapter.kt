package com.example.mostafakhalifacroshet.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mostafakhalifacroshet.ui.AllProductsFragment

class ViewPagerAdapter(private val context : Context, fm : FragmentManager, internal var totalTabs : Int) : FragmentPagerAdapter(fm){
    override fun getCount(): Int {
       return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        when(position){
             0 ->
                 return AllProductsFragment()
            1 ->
                return AllProductsFragment()
            2 ->
                return AllProductsFragment()
            3 ->
                return AllProductsFragment()
            4 ->
                return AllProductsFragment()
            else ->
                return null!!
        }
    }
}