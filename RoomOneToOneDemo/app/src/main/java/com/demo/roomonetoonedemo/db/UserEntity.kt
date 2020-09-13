package com.demo.roomonetoonedemo.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int=0,
                        @ColumnInfo(name = "name") val name : String,
                       @ColumnInfo(name = "phone")val phone: String,
                       @ColumnInfo(name = "email")val email: String
                       )




@Entity(foreignKeys = arrayOf(
        ForeignKey(entity = UserEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("user_id"),
        onDelete = ForeignKey.CASCADE)
))
data class Address(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "address_id")val address_id: Int=0,
                    @ColumnInfo(name = "user_id")val user_id: Int,
                   @ColumnInfo(name ="address")val address: String,
                   @ColumnInfo(name = "city")val city: String,
                   @ColumnInfo(name ="state")val state: String,
                   @ColumnInfo(name ="zip")val zip : String
                   )
