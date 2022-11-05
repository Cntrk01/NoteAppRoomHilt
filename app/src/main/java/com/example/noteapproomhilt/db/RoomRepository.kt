package com.example.noteapproomhilt.db

import javax.inject.Inject

class RoomRepository @Inject constructor(
    private val appDao: AppDao
) {
    fun getRecords(): List<UserEntity> {
        return appDao.getRecords()
    }

    fun insertRecords(userEntity: UserEntity) {
        appDao.insertRoom(userEntity)
    }
}