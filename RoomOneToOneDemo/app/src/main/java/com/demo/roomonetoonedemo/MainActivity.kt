package com.demo.roomonetoonedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.roomonetoonedemo.db.Address
import com.demo.roomonetoonedemo.db.RoomAppDB
import com.demo.roomonetoonedemo.db.UserEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveDatainRoomDb()
    }

    fun saveDatainRoomDb() {
        saveButton.setOnClickListener {
            val name = editViewName.text.toString()
            val phone = editViewPhone.text.toString()
            val email = editViewEmail.text.toString()
            val address = editViewAddress.text.toString()
            val city = editViewCity.text.toString()
            val state = editViewState.text.toString()
            val zip = editViewZip.text.toString()
            val userDao = RoomAppDB.getAppDatabase(applicationContext)?.userDao()
            val userEntity = UserEntity(0, name, phone, email)
            val id = userDao?.insertUser(userEntity)
            val addressEntity = Address(0, id!!.toInt(), address, city, state, zip)
            userDao?.insertAddress(addressEntity)

            startActivity(Intent(this@MainActivity, ProfileActivity::class.java))
            finish()
        }
    }
}