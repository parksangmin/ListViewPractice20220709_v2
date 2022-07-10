package com.sangmin.listviewpractice20220709.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.sangmin.listviewpractice20220709.R
import com.sangmin.listviewpractice20220709.RoomData

class RoomListAdapter(
    val mContext : Context,
    val resId : Int,
    val mList : ArrayList<RoomData>

) : ArrayAdapter<RoomData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(resId, null)

        }


        val row = tempRow!!

        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val levelTxt = row.findViewById<TextView>(R.id.levelTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTxt)

//        priceTxt.text = mList[position].price.toString()
//        RoomData의 getFormattedPrice 함수를 활용해서 가격을 표시
        priceTxt.text = mList[position].getFormattedPrice()
        addressTxt.text = mList[position].address
        levelTxt.text = mList[position].getFormattedLevel()
        descriptionTxt.text = mList[position].description

        return row
    }
}