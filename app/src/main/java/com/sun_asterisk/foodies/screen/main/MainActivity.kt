package com.sun_asterisk.foodies.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.screen.favorite.FavoriteFragment
import com.sun_asterisk.foodies.screen.home.HomeFragment
import com.sun_asterisk.foodies.screen.main.layout_adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupTabLayout()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager).apply {
            addFragmentContainer(HomeFragment(), resources.getString(R.string.home))
            addFragmentContainer(FavoriteFragment(), resources.getString(R.string.favorites))
        }
    }

    private fun setupTabIcons() {
        val icons = resources.obtainTypedArray(R.array.layout_icons)
        tabLayout.getTabAt(HOME_PAGE)?.setIcon(icons.getDrawable(HOME_PAGE))
        tabLayout.getTabAt(FAVORITE_PAGE)?.setIcon(icons.getDrawable(FAVORITE_PAGE))
    }

    private fun setupTabLayout() {
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
        setupTabIcons()
    }

    companion object {
        private const val HOME_PAGE = 0
        private const val FAVORITE_PAGE = 1
    }
}

