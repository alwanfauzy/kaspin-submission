package com.alwan.barangku.presentation.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alwan.barangku.R
import com.alwan.barangku.databinding.ActivityDetailBinding
import com.alwan.core.domain.model.Barang
import com.alwan.core.util.loadImage
import com.alwan.core.util.toIDRString
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBar()

        val barangId = intent.getStringExtra(EXTRA_BARANG_ID).orEmpty()
        initViewModel(barangId)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
    }

    private fun initViewModel(id: String) {
        detailViewModel.getBarangById(id).observe(this) {
            populateDetail(it)
        }
    }

    private fun populateDetail(barang: Barang) = binding.apply {
        tvNama.text = barang.name
        tvKode.text = barang.code
        tvHarga.text = barang.price.toIDRString()
        tvStok.text = getString(R.string.stok_item, barang.stock)
        tvKeterangan.text = barang.description
        sivBarang.loadImage(barang.imageUrl)
    }

    companion object {
        const val EXTRA_BARANG_ID = "extra_barang_ID"
    }
}