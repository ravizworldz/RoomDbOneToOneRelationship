package com.demo.roomonetoonedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.roomonetoonedemo.db.RoomAppDB
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //Read data

        val userDao = RoomAppDB.getAppDatabase(applicationContext)?.userDao()
        val list =  userDao?.getAllUserWithAddress()

       // val sb = StringBuffer()
        list?.forEach {

            //sb.append(it.toString())
            textViewName.append("Name : ${it.name}\n")
            textViewPhone.append( "Phone : ${it.phone}\n")
            textViewEmail.append( "Email : ${it.email}\n")
            textViewAddress.append("Address : ${it.address}\n")
            textViewCity.append( "City : ${it.city}\n")
            textViewState.append( "State : ${it.state}\n")
            textViewZip.append("Zip : ${it.zip}\n")

        }

    }
}