package com.example.noteapproomhilt.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppDao {

    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getRecords(): List<UserEntity>

    @Insert
    fun insertRoom(userEntity: UserEntity)
}