package com.example.noteapproomhilt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapproomhilt.db.RoomRepository
import com.example.noteapproomhilt.db.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivtyViewModel
@Inject constructor(
    private val repository: RoomRepository
) : ViewModel() {
    lateinit var userData: MutableLiveData<List<UserEntity>>

    init {
        userData = MutableLiveData()
        loadRepo()
    }

    fun getRecordsObserver() : MutableLiveData<List<UserEntity>> {
        return userData
    }

    fun loadRepo(){
        val list=repository.getRecords()
        userData.postValue(list)
    }

    fun insertData(userEntity: UserEntity){
        repository.insertRecords(userEntity)
        loadRepo()
    }
}