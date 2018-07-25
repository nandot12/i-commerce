package com.imastudio.guanzhuli.icart.fragments

import android.content.Context
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.imastudio.guanzhuli.icart.R

import java.util.Timer
import java.util.TimerTask

import com.google.android.gms.internal.zzir.runOnUiThread

/**
 * Created by Guanzhu Li on 12/31/2016.
 */
class HomeFragment : Fragment() {
    private var mViewPager: ViewPager? = null
    private var mViewTop: ViewPager? = null
    private var mTabLayout: TabLayout? = null
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private var count = 0

    override fun onResume() {
        super.onResume()
        activity!!.title = "iCart"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        mSectionsPagerAdapter = SectionsPagerAdapter(childFragmentManager)
        // set top view pager
        mViewTop = view.findViewById<View>(R.id.imagePage) as ViewPager
        val tabLayout = view.findViewById<View>(R.id.tabDots) as TabLayout
        tabLayout.setupWithViewPager(mViewTop, true)
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if (count < 3) {
                        mViewTop!!.currentItem = count
                        count++
                    } else {
                        count = 0
                        mViewTop!!.currentItem = count
                    }
                }
            }
        }, 500, 3000)


        //set up tabs
        mTabLayout = view.findViewById<View>(R.id.tabLayout) as TabLayout
        mTabLayout!!.tabGravity = TabLayout.GRAVITY_FILL
        mViewPager = view.findViewById<View>(R.id.pager) as ViewPager
        mViewPager!!.adapter = mSectionsPagerAdapter
        mTabLayout!!.setupWithViewPager(mViewPager)
        mViewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                mTabLayout!!.setScrollPosition(position, 0f, true)
                mTabLayout!!.isSelected = true
                mViewPager!!.parent.requestDisallowInterceptTouchEvent(true)
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        mViewPager!!.setOnTouchListener { v, event ->
            v.parent.requestDisallowInterceptTouchEvent(true)
            false
        }

        activity!!.supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        return view
    }

    internal inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> {
                    return HomeTopSellerFragment()
                }
                1 -> {
                    return HomeNewArrivalFragment()
                }
                else -> {
                }
            }
            return null
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "Top Seller"
                1 -> return "New Arrival"
                else -> {
                }
            }
            return null
        }
    }

    internal inner class TopPagerAdapter(var mContext: Context) : PagerAdapter() {
        var mLayoutInflater: LayoutInflater

        init {
            mLayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        override fun getCount(): Int {
            return mResources.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object` as LinearLayout
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false)

            val imageView = itemView.findViewById<View>(R.id.imageView) as ImageView
            imageView.setImageResource(mResources[position])

            container.addView(itemView)

            return itemView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as LinearLayout)
        }
    }

    companion object {
        private val mResources = intArrayOf(R.drawable.page1, R.drawable.page2, R.drawable.page3)
    }
}

