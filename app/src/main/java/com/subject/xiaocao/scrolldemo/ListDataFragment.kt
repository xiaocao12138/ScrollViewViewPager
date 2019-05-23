package com.subject.xiaocao.scrolldemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.list_fragment.*

class ListDataFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_fragment, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState)
        val lists = ArrayList<String>()
        for (index in 1 until 100){
            var str = "test$index"
            lists.add(str)
        }
        list.adapter = TextAdapter(activity, lists)
    }

    inner class TextAdapter(var activity: Activity?, private var lists: ArrayList<String>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val holder: ViewHolder
            val view: View
            if (convertView == null) {
                view = View.inflate(activity, R.layout.text_item, null)
                holder = ViewHolder(view)
                view.tag = holder
            } else {
                view = convertView
                holder = view.tag as ViewHolder
            }
            val str  = lists[position]
            holder.textA.text = str
            return view
        }

        override fun getItem(position: Int): Any {
            return lists[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return lists.size
        }

        private inner class ViewHolder(v : View) {
            var textA: TextView = v.findViewById(R.id.textA)
        }
    }
}



