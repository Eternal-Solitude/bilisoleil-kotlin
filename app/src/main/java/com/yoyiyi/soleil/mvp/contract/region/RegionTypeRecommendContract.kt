package com.yoyiyi.soleil.mvp.contract.region

import com.yoyiyi.soleil.base.BaseContract
import com.yoyiyi.soleil.bean.region.RegionRecommend

/**
 * @author zzq  作者 E-mail:   soleilyoyiyi@gmail.com
 * *
 * @date 创建时间：2017/5/12 10:09
 * * 描述:发现Contract
 */

interface RegionTypeRecommendContract {

    interface View : BaseContract.BaseView {

        fun showRegionRecommend(regionRecommend: RegionRecommend)

    }

    interface Presenter<in T> : BaseContract.BasePresenter<T> {

        fun getRegionRecommendData(tid: Int)


    }
}
