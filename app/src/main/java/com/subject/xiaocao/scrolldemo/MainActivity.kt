package com.subject.xiaocao.scrolldemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragments = ArrayList<Fragment>()
        fragments.add(WebDataFragment())
        fragments.add(ListDataFragment())
        viewpager.adapter = FragmentAdapter(supportFragmentManager, fragments)
    }

    private inner class FragmentAdapter internal constructor(manager: FragmentManager, private val fragments: List<Fragment>) : FragmentPagerAdapter(manager) {

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
    }
}
