package com.alwan.barangku.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alwan.barangku.R
import com.alwan.barangku.databinding.ActivityDetailBinding
import com.alwan.core.util.loadImage
import com.alwan.core.util.toIDRString

class DetailActivity : AppCompatActivity() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBar()

        val barangId = intent.getIntExtra(EXTRA_BARANG_ID, 0)
        populateDetail(barangId)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
    }

    private fun populateDetail(id: Int) = binding.apply {
        tvNama.text = "Barang 123"
        tvKode.text = "abcdefghijklmnopqrstuvwxyz"
        tvHarga.text = 20000L.toIDRString()
        tvStok.text = "20 Item"
        tvKeterangan.text = getString(R.string.lorem_ipsum)
        sivBarang.loadImage("https://id-live-01.slatic.net/p/101c9cf07e59fdf29b954fcb0abc2c92.jpg")
    }

    companion object {
        const val EXTRA_BARANG_ID = "extra_barang_ID"
    }
}