package com.subject.xiaocao.scrolldemo

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

class ViewPagerForScroll : ViewPager {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    /**
     * 计算ViewPager的高度
     */
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var height = 0
        for (index in 0 until childCount) {
            val child = getChildAt(index)
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
            val h = child.measuredHeight
            if (h > height) height = h
        }
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY))
    }

    private var x: Int = 0
    private var y: Int = 0

    /**
     * 在ViewPager内获取触摸点在的坐标 rawX 、rawY
     */
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {//按下y
                x = ev.rawX.toInt()
                y = ev.rawY.toInt()
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {//移动
                val newX = ev.rawX.toInt()
                val newY = ev.rawY.toInt()
                val moveX = Math.abs(newX - x)
                val moveY = Math.abs(newY - y)
                // 这里是否拦截的判断依据是左右滑动，读者可根据自己的逻辑进行是否拦截
                if (moveX > moveY) { // 左右滑动请求父 View 不要拦截
                    parent.requestDisallowInterceptTouchEvent(true)
                } else {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}