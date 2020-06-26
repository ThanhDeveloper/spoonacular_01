package com.sun_asterisk.foodies.screen.tab_layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.screen.favorite.FavoriteFragment
import com.sun_asterisk.foodies.screen.home.HomeFragment
import com.sun_asterisk.foodies.screen.tab_layout.layout_adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_tab.*

class TabFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabLayout()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        viewPager.adapter = activity?.supportFragmentManager?.let {
            ViewPagerAdapter(it).apply {
                addFragmentContainer(HomeFragment(), resources.getString(R.string.home))
                addFragmentContainer(FavoriteFragment(), resources.getString(R.string.favorites))
            }
        }
    }

    private fun setupTabIcons() {
        val icons = resources.obtainTypedArray(R.array.layout_icons)
        tabLayout.getTabAt(HOME_PAGE)?.icon = icons.getDrawable(HOME_PAGE)
        tabLayout.getTabAt(FAVORITE_PAGE)?.icon = icons.getDrawable(FAVORITE_PAGE)
        icons.recycle()
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
