package com.mj.mvvm.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.mj.mvvm.R
import com.mj.mvvm.data.model.ContactEntity
import com.mj.mvvm.presentation.viewModel.ContactViewModel

class AddActivity : AppCompatActivity() {

    private lateinit var contactViewModel: ContactViewModel
    private var id: Long? = null
    private lateinit var addEditTextName: EditText
    private lateinit var addEditTextNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        addEditTextName = findViewById(R.id.add_edittext_name)
        addEditTextNumber = findViewById(R.id.add_edittext_number)

        contactViewModel = ViewModelProviders.of(this).get(ContactViewModel::class.java)

        if(intent != null && intent.hasExtra(EXTRA_CONTACT_NUMBER)  && intent.hasExtra(EXTRA_CONTACT_NUMBER) && intent.hasExtra(EXTRA_CONTACT_ID)) {
            addEditTextName.setText(intent.getStringExtra(EXTRA_CONTACT_NAME))
            addEditTextNumber.setText(intent.getStringExtra(EXTRA_CONTACT_NUMBER))
            id = intent.getLongExtra(EXTRA_CONTACT_ID, -1)
        }

        findViewById<Button>(R.id.add_button).setOnClickListener {
            val name = addEditTextName.text.toString().trim()
            val number = addEditTextNumber.text.toString()

            if (name.isEmpty() || number.isEmpty()) {
                Toast.makeText(this, "Please enter name and number.", Toast.LENGTH_SHORT).show()
            } else {
                val initial = name[0].toUpperCase()
                val contact = ContactEntity(id, name, number, initial)
                contactViewModel.insert(contact)
                finish()
            }
        }
    }


    companion object {
        const val EXTRA_CONTACT_NAME = "EXTRA_CONTACT_NAME"
        const val EXTRA_CONTACT_NUMBER = "EXTRA_CONTACT_NUMBER"
        const val EXTRA_CONTACT_ID = "EXTRA_CONTACT_ID"
    }
}