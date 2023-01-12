package com.example.dreamwordkhataboook

import java.text.SimpleDateFormat
import java.time.chrono.ChronoLocalDateTime
import java.util.*

class UserModel {

    var id = 0
    lateinit var name: String
    var amount: Int = 0
    lateinit var cc: String
    lateinit var remark: String
    lateinit var time: String
    var type = 0

    constructor(id: Int, name: String, amount: Int, cc: String, remark: String, time: String, type:Int) {
        this.id = id
        this.name = name
        this.amount = amount
        this.cc = cc
        this.remark = remark
        this.time = time
        this.type = type


    }

    constructor()

}