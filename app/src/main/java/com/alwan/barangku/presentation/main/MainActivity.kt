package com.alwan.barangku.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.alwan.barangku.databinding.ActivityMainBinding
import com.alwan.barangku.domain.model.Barang

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var barangAdapter: BarangAdapter
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
        barangAdapter = BarangAdapter { onBarangClicked(it) }
        barangAdapter.submitList(dummyBarangs)

        binding.rvBarang.apply {
            layoutManager = LinearLayoutManager(context)
            hasFixedSize()
            adapter = barangAdapter
        }
    }

    private fun onBarangClicked(barang: Barang) {

    }
}