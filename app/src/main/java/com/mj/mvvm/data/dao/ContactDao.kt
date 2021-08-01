package com.mj.mvvm.data.dao


import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mj.mvvm.data.model.ContactEntity

interface ContactDao {

    @Query("SELECT * FROM contact ORDER BY name ASC")
    fun getAll(): LiveData<List<ContactEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: ContactEntity)

    @Delete
    fun delete(contact: ContactEntity)
}