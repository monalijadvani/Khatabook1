package com.example.dreamwordkhataboook

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dreamwordkhataboook.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {


    companion object {
        lateinit var context: Context
        lateinit var database: Database
        lateinit var list: ArrayList<UserModel>
        lateinit var adapter: UserDataAdapter

        fun updated() {
            list.clear()
            list = database.showData()
            adapter.update(list)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)


        binding.btnAdd.setOnClickListener {
            onincome()
            setContentView(binding.root)
        }

        binding.btnexp.setOnClickListener{
            onexp()

            setContentView(binding.root)
        }
        setContentView(binding.root)
        database = Database(applicationContext)
        list = database.showData()
        adapter = UserDataAdapter(list)
        binding.rcvList.layoutManager = LinearLayoutManager(applicationContext)
        binding.rcvList.adapter = adapter




    }

    private fun onexp() {
        exp().show(supportFragmentManager, "MyCustomFragment")
    }

    private fun onincome() {
        add().show(supportFragmentManager, "MyCustomFragment")
    }

}
