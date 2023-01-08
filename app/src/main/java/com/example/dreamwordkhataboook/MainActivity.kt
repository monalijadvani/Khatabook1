package com.example.dreamwordkhataboook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            onlogin()
            setContentView(binding.root)
        }
        setContentView(binding.root)
        database = Database(applicationContext)
        list = database.showData()
        adapter = UserDataAdapter(list)
        binding.rcvList.layoutManager = LinearLayoutManager(applicationContext)
        binding.rcvList.adapter = adapter
        var date = Calendar.getInstance()
        var format = SimpleDateFormat("d/M/y h:m:s a")
        var current = format.format(date.time)
    }

    private fun onlogin() {
        add().show(supportFragmentManager, "MyCustomFragment")
    }
}
