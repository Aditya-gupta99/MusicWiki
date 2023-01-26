package com.sparklead.musicwiki.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProvider
import com.sparklead.musicwiki.R
import com.sparklead.musicwiki.databinding.ActivityGenreDetailsBinding
import com.sparklead.musicwiki.ui.adapter.GenreViewPager
import com.sparklead.musicwiki.viewmodels.GenreDetailsViewModel
import kotlinx.android.synthetic.main.activity_genre_details.*


class GenreDetailsActivity : BaseActivity() {

    private lateinit var binding : ActivityGenreDetailsBinding
    private val viewModel: GenreDetailsViewModel by lazy { ViewModelProvider(this)[GenreDetailsViewModel::class.java] }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenreDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this

        showLoadingDialog()

        setupActionBar()

        val tag = intent.getStringExtra("GenreTagName").toString()

        binding.tvGenreTitle.text = tag
        viewModel.setTagName(intent.getStringExtra("GenreTagName").toString())
        viewModel.getDetails(tag)
        viewModel.result.observe(this) {
            binding.tvGenreDetails.text = it.tag.wiki.summary
            hideLoading()
        }

        setViewpager()
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.toolbarGenreDetails)

        val actionBar = supportActionBar
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_new_24)
        }

        binding.toolbarGenreDetails.setNavigationOnClickListener{ onBackPressed() }
    }

    private fun setViewpager() {

        binding.viewpager.adapter = GenreViewPager(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        binding.tabLayout.setupWithViewPager(binding.viewpager)
    }

}