package com.example.dreamwordkhataboook

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class Database(context: Context?) : SQLiteOpenHelper(context, "school.db", null, 1) {
    var context = context
    override fun onCreate(p0: SQLiteDatabase?) {
        var sql =
            "CREATE TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, amount INTEGER, cc TEXT, remark Text)"
        p0?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {}
    fun insertdata(name: String, amount: Int, cc: String, remark: String) {
        var db = writableDatabase
        var value = ContentValues()
        value.put("name", name)
        value.put("amount", amount)
        value.put("cc", cc)
        value.put("remark", remark)




        var iss = db.insert("student", null, value)
        if (iss.toInt() == -1) {
            Toast.makeText(context, "data is not inserted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "data inserted", Toast.LENGTH_SHORT).show()
        }
    }


    fun showData(): ArrayList<UserModel> {

        var modellist = ArrayList<UserModel>()
        var db = readableDatabase
        var sql = "SELECT * FROM student"
        var cursor = db.rawQuery(sql, null)
        cursor.moveToFirst()
        for (x in 0..cursor.count - 1) {
            var id = cursor.getInt(0)
            var name = cursor.getString(1)
            var amount = cursor.getInt(2)
            var cc = cursor.getString(3)
            var remark = cursor.getString(4)
            var model = UserModel(id, name, amount, cc, remark)
            modellist.add(model)
            cursor.moveToNext()
        }
        return modellist
    }


    fun updatedata(id: Int, name: String, amount: String, cc: String, remark: String) {
        var db = writableDatabase
        var values = ContentValues()
        values.put("name", name)
        values.put("amount", amount)
        values.put("cc", cc)
        values.put("remark", remark)
        db.update("student", values, "id = $id", null)
    }

    fun deleteData(id: Int) {
        var db = writableDatabase
        db.delete("student", "id=$id", null)
    }

}
