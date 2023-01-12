package com.example.dreamwordkhataboook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dreamwordkhataboook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    companion object {
        lateinit var context: Context
        lateinit var database: Database
        lateinit var list: ArrayList<UserModel>
        lateinit var adapter: UserDataAdapter
        lateinit var binding: ActivityMainBinding
        fun updated() {
            list.clear()
            list = database.showData()
            adapter.update(list)
            UpdateTotal()
        }

        fun UpdateTotal() {
            var total = 0;
            var income_total = 0;
            var expence_total = 0;

            for (l in list) {
                total += l.amount
                if (l.type == 1) {
                    income_total += l.amount
                } else if (l.type == 0) {
                    expence_total += l.amount
                }

            }

            binding.balance.text = "${income_total-expence_total}"
            binding.income.text = "$income_total"
            binding.exp.text = "$expence_total"

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        binding.btnAdd.setOnClickListener {
            onincome()
            setContentView(binding.root)
        }

        binding.btnexp.setOnClickListener {
            onexp()

            setContentView(binding.root)
        }
        setContentView(binding.root)
        database = Database(applicationContext)
        list = database.showData()
        adapter = UserDataAdapter(list)
        binding.rcvList.layoutManager = LinearLayoutManager(applicationContext)
        binding.rcvList.adapter = adapter


        UpdateTotal()

    }


    private fun onexp() {
        exp().show(supportFragmentManager, "MyCustomFragment")
    }

    private fun onincome() {
        add().show(supportFragmentManager, "MyCustomFragment")
    }


}
