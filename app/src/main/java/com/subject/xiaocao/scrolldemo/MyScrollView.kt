package com.subject.xiaocao.scrolldemo

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.ScrollView

class MyScrollView : ScrollView {

    constructor(context: Context): super(context)

    constructor(context: Context, attributeSet: AttributeSet): super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int): super(context, attributeSet, defStyleAttr)

    private var x: Int = 0
    private var y:Int = 0

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN//按下y
            -> {
                x = ev.x.toInt()
                y = ev.y.toInt()
            }
            MotionEvent.ACTION_MOVE//移动
            -> {
                val newX = ev.x.toInt()
                val newY = ev.y.toInt()
                //判断有上下滑动的意向
                val moveX = Math.abs(newX - x)//x轴滑动的距离
                val moveY = Math.abs(newY - y)//y轴滑动的距离
                if (moveY > moveX)
                    Log.e("ViewPagerForScroll", " onInterceptTouchEvent== " + (moveY > moveX))
                //10的偏移量{
                    return true//传递给字View
            }
        }
        return super.onInterceptTouchEvent(ev)
    }
}