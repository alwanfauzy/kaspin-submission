package com.alwan.barangku.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.alwan.barangku.databinding.ActivityMainBinding
import com.alwan.barangku.presentation.detail.DetailActivity
import com.alwan.core.R
import com.alwan.core.domain.model.Barang
import com.alwan.core.ui.BarangAdapter
import com.alwan.core.util.MarginItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var barangAdapter: BarangAdapter
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initRecyclerView() {
        barangAdapter = BarangAdapter { onBarangClicked(it) }

        binding.rvBarang.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                MarginItemDecoration(
                    resources.getDimension(R.dimen.spacing_16dp).roundToInt()
                )
            )
            hasFixedSize()
            adapter = barangAdapter
        }
    }

    private fun initViewModel() {
        mainViewModel.getAllBarang().observe(this) {
            barangAdapter.submitList(it)
        }
    }

    private fun onBarangClicked(barang: com.alwan.core.domain.model.Barang) {
        val detailIntent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_BARANG_ID, barang.code)
        }

        startActivity(detailIntent)
    }
}