package com.example.mostafakhalifacroshet.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.mostafakhalifacroshet.R
import com.example.mostafakhalifacroshet.data.Product
import com.example.mostafakhalifacroshet.databinding.ActivityProductDetailsBinding
import com.example.mostafakhalifacroshet.utils.EXTRA_PRODUCT
import com.example.mostafakhalifacroshet.viewModels.ProductDetailsViewModel
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils

class ProductDetailsActivity : AppCompatActivity() {
    @SuppressLint("UnsafeOptInUsageError")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val binding : ActivityProductDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_details)
        val product = intent.getSerializableExtra(EXTRA_PRODUCT) as? Product

        var viewModel = ViewModelProviders.of(this)[ProductDetailsViewModel::class.java]
        binding.productDetailsViewModel = viewModel

        viewModel.setProduct(product!!)
        viewModel.setProductData()

        Glide.with(this).load(product.imageId)
            .into(binding.productImgSlider)



    }
}