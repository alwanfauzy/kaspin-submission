package com.alwan.barangku.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alwan.barangku.databinding.ActivityMainBinding
import com.alwan.barangku.detail.DetailActivity
import com.alwan.core.R
import com.alwan.core.domain.model.Barang
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var barangAdapter: com.alwan.core.ui.BarangAdapter
    private val dummyBarangs = listOf(
        Barang(
            "p1423ud",
            "Penggaris",
            "Penggaris dengan panjang 20cm dengan bahan plastik akrilik",
            50,
            5000,
            "https://id-live-01.slatic.net/p/101c9cf07e59fdf29b954fcb0abc2c92.jpg"
        ),
        Barang(
            "cedp244",
            "Pensil",
            "Dibuat oleh faber castell, berkualitas tinggi",
            120,
            2500,
            "https://cf.shopee.co.id/file/94ff9cb95f075235c134f20a879bcf2a"
        ),
        Barang(
            "p1423ud",
            "Penggaris",
            "Penggaris dengan panjang 20cm dengan bahan plastik akrilik",
            50,
            5000,
            "https://id-live-01.slatic.net/p/101c9cf07e59fdf29b954fcb0abc2c92.jpg"
        ),
        Barang(
            "cedp244",
            "Pensil",
            "Dibuat oleh faber castell, berkualitas tinggi",
            120,
            2500,
            "https://cf.shopee.co.id/file/94ff9cb95f075235c134f20a879bcf2a"
        ),
        Barang(
            "p1423ud",
            "Penggaris",
            "Penggaris dengan panjang 20cm dengan bahan plastik akrilik",
            50,
            5000,
            "https://id-live-01.slatic.net/p/101c9cf07e59fdf29b954fcb0abc2c92.jpg"
        ),
        Barang(
            "cedp244",
            "Pensil",
            "Dibuat oleh faber castell, berkualitas tinggi",
            120,
            2500,
            "https://cf.shopee.co.id/file/94ff9cb95f075235c134f20a879bcf2a"
        ),
        Barang(
            "p1423ud",
            "Penggaris",
            "Penggaris dengan panjang 20cm dengan bahan plastik akrilik",
            50,
            5000,
            "https://id-live-01.slatic.net/p/101c9cf07e59fdf29b954fcb0abc2c92.jpg"
        ),
        Barang(
            "cedp244",
            "Pensil",
            "Dibuat oleh faber castell, berkualitas tinggi",
            120,
            2500,
            "https://cf.shopee.co.id/file/94ff9cb95f075235c134f20a879bcf2a"
        ),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initRecyclerView() {
        barangAdapter = com.alwan.core.ui.BarangAdapter { onBarangClicked(it) }
        barangAdapter.submitList(dummyBarangs)

        binding.rvBarang.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                com.alwan.core.util.MarginItemDecoration(
                    resources.getDimension(R.dimen.spacing_16dp).roundToInt()
                )
            )
            hasFixedSize()
            adapter = barangAdapter
        }
    }

    private fun onBarangClicked(barang: Barang) {
        val detailIntent = Intent(this, DetailActivity::class.java)

        startActivity(detailIntent)
    }
}