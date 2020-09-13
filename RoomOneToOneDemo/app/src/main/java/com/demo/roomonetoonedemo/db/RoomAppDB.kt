package com.demo.roomonetoonedemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [UserEntity::class, Address::class], version = 1)
abstract class RoomAppDB : RoomDatabase(){


    abstract fun userDao(): UserProfileDao?

        companion object {
            private var INSTANCE : RoomAppDB? = null

            fun getAppDatabase(context: Context): RoomAppDB? {
                if(INSTANCE ==  null ) {
                    INSTANCE =  Room.databaseBuilder<RoomAppDB>(
                        context.applicationContext, RoomAppDB::class.java,"demo_dp"
                    )
                        .allowMainThreadQueries()
                        .build()

                }

                return INSTANCE
            }
        }
}