package com.aws.day1

import android.content.Context
import android.widget.Toast

object DataObject {

    fun showToast(context: Context, msg : String){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}