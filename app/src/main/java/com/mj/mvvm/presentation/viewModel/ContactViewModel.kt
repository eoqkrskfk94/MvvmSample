package com.mj.mvvm.presentation.viewModel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mj.mvvm.data.model.ContactEntity
import com.mj.mvvm.data.repository.ContactRepository

class ContactViewModel(application: Application) : ViewModel() {

    init {
        Log.i("ContactViewModel", "ContactViewModel created!")
    }


    private val repository = ContactRepository(application = application)
    private val contacts = repository.getAll()

    fun getAll(): LiveData<List<ContactEntity>> {
        return this.contacts
    }

    fun insert(contact: ContactEntity) {
        repository.insert(contact)
    }

    fun delete(contact: ContactEntity) {
        repository.delete(contact)
    }
}