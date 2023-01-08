package com.example.dreamwordkhataboook

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserDataAdapter(list: ArrayList<UserModel>) :
    RecyclerView.Adapter<UserDataAdapter.UserDataHolder>() {
    var modellist = list
    lateinit var database: Database
    lateinit var context: Context


    class UserDataHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtname = itemView.findViewById<TextView>(R.id.txtName)
        var txtcc = itemView.findViewById<TextView>(R.id.txtcc)
        var btnUpdate = itemView.findViewById<Button>(R.id.btnUpdate)
        var btnDelete = itemView.findViewById<Button>(R.id.btnDelete)
        var BtnDialogAdd = itemView.findViewById<Button>(R.id.BtnDialogAdd)
        var btnAdd = itemView.findViewById<Button>(R.id.btnAdd)
        var amount = itemView.findViewById<TextView>(R.id.amount)
        var txtremark = itemView.findViewById<TextView>(R.id.txtremark)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataHolder {


        context = parent.context
        return UserDataHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)

        )
    }

    override fun onBindViewHolder(holder: UserDataHolder, position: Int) {

        holder.txtname.text = modellist.get(position).name
        holder.amount.text = modellist.get(position).amount
        holder.txtcc.text = modellist.get(position).cc
        holder.txtremark.text = modellist.get(position).remark
        database = Database(context)

        holder.btnUpdate.setOnClickListener {
            var dialog = Dialog(context)


            dialog.setContentView(R.layout.update_dialog)
            var idd = dialog.findViewById<TextView>(R.id.txtId)
            var edtname = dialog.findViewById<TextView>(R.id.name)
            var edtamount = dialog.findViewById<TextView>(R.id.amount)
            var edtcc = dialog.findViewById<TextView>(R.id.cc)
            var btnUpdates = dialog.findViewById<Button>(R.id.btnUpdate)
            var edtremark = dialog.findViewById<TextView>(R.id.remark)


            idd.text = modellist.get(position).id.toString()
            edtname.text = modellist.get(position).name.toString()
            edtamount.text = modellist.get(position).amount.toString()
            edtcc.text = modellist.get(position).cc.toString()
            edtremark.text = modellist.get(position).remark.toString()


            btnUpdates.setOnClickListener {
                database.updatedata(
                    modellist.get(position).id,
                    edtname.text.toString(),
                    edtamount.text.toString(),
                    edtcc.text.toString(),
                    edtremark.text.toString()
                )
                MainActivity.updated()
                dialog.dismiss()
            }
            dialog.show()
        }
        holder.btnDelete.setOnClickListener {
            database.deleteData(modellist.get(position).id)
            MainActivity.updated()

        }
    }

    override fun getItemCount(): Int {
        return modellist.size
    }

    fun update(list: ArrayList<UserModel>) {
        modellist = list
        notifyDataSetChanged()
    }
}