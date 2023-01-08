package com.example.dreamwordkhataboook

class UserModel {

        var id = 0
        lateinit var name:String
        lateinit var amount:String
        lateinit var cc:String
        lateinit var remark:String


        constructor(id: Int, name: String, amount: String, cc: String,remark :String) {
            this.id = id
            this.name = name
            this.amount = amount
            this.cc = cc
            this.remark= remark
        }

        constructor()

}