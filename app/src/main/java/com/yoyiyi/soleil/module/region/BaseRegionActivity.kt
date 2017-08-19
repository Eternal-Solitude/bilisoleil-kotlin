package com.yoyiyi.soleil.module.region

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.flyco.tablayout.SlidingTabLayout
import com.yoyiyi.soleil.R
import com.yoyiyi.soleil.base.BaseActivity
import com.yoyiyi.soleil.base.BaseContract

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * *
 * @date 创建时间：2017/5/30 12:30
 * * 描述:基础分区
 */
abstract class BaseRegionActivity<T : BaseContract.BasePresenter<*>, K> : BaseActivity<T>() {
    protected var mTvTitle: TextView? = null
    protected var mIvBack: ImageView? = null
    protected var mList: List<K> = mutableListOf()
    protected var mTitles: List<String> = mutableListOf()
    protected var mFragments: List<Fragment> = mutableListOf()

    protected var mSlidingTabLayout: SlidingTabLayout? = null

    var mViewPager: ViewPager? = null

    @SuppressLint("CheckResult")
    override fun initToolbar() {
        mTvTitle = findViewById(R.id.tv_title) as TextView?
        mIvBack = findViewById(R.id.iv_back) as ImageView?
        mIvBack?.setOnClickListener { finish() }
    }

    protected fun setTitle(title: String) {
        mTvTitle?.text = title
    }

    override fun initWidget() {
        super.initWidget()
        initSlidingTabLayout()
    }

    protected fun initSlidingTabLayout() {
        mSlidingTabLayout = findViewById(R.id.sliding_tabs) as SlidingTabLayout?
        mViewPager = findViewById(R.id.view_pager) as ViewPager?

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_region, menu)
        return true
    }

    protected  open fun initFragment() {}

    protected open fun initTitle() {}

    override fun finishTask() {
        initTitle()
        initFragment()
        initViewPager()
        initEvent()
    }

    protected open fun initViewPager() {
        mViewPager?.offscreenPageLimit = mTitles.size
        mViewPager?.adapter = BaseRegionTypeAdapte(supportFragmentManager)
        mSlidingTabLayout?.setViewPager(mViewPager)
    }

    /**
     * 初始化事件
     */
    protected fun initEvent() {

    }

    protected fun setCurrentItem(pos: Int) {
        mViewPager?.currentItem = pos
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {

        }

        return super.onOptionsItemSelected(item)
    }

    inner  class BaseRegionTypeAdapte(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return mFragments[position]
        }

        override fun getCount(): Int = mTitles.size


        override fun getPageTitle(position: Int): CharSequence = mTitles[position]

    }

}
