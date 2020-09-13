package com.demo.roomonetoonedemo.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserProfileDao {

    @Query("SELECT * FROM user ORDER BY id desc")
    fun getUserData(): List<UserEntity>?

    @Insert
    fun insertUser(user: UserEntity): Long

    @Insert
    fun insertAddress(address: Address)

     @Query("SELECT * FROM user inner join Address  on user.id = Address.user_id ")
     fun getAllUserWithAddress(): List<UserWithAddress>?
}