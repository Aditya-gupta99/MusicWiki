package com.sparklead.musicwiki.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sparklead.musicwiki.ui.fragments.AlbumFragment
import com.sparklead.musicwiki.ui.fragments.ArtistFragment
import com.sparklead.musicwiki.ui.fragments.TrackFragment

class GenreViewPager(fragmentManager: FragmentManager, behaviour:Int) :
    FragmentPagerAdapter(fragmentManager,behaviour) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AlbumFragment()
            1 -> ArtistFragment()
            2 -> TrackFragment()
            else -> AlbumFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Album"
            1 -> return "Artist"
            2 -> return "Track"
        }
        return super.getPageTitle(position)
    }
}