package com.mj.mvvm.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.mj.mvvm.data.model.ContactEntity
import java.lang.Exception

class ContactRepository(application: Application) {

    private val contactDatabase = ContactDatabase.getInstance(application)!!
    private val contactDao = contactDatabase.contactDao()
    private val contacts = contactDao.getAll()

    fun getAll(): LiveData<List<ContactEntity>> {
        return contacts
    }

    fun insert(contact: ContactEntity) {
        try {
            val thread = Thread(Runnable {
                contactDao.insert(contact)
            })
            thread.start()
        } catch (e: Exception) {
        }
    }

    fun delete(contact: ContactEntity) {
        try {
            val thread = Thread(Runnable {
                contactDao.delete(contact)
            })
            thread.start()
        } catch (e: Exception) {

        }
    }
}