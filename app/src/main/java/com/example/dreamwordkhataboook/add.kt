package com.example.dreamwordkhataboook

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.dreamwordkhataboook.databinding.FragmentAddBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class add : DialogFragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = FragmentAddBinding.inflate(layoutInflater)
        binding.BtnDialogAdd.setOnClickListener{
            var id = binding.txtId.text.toString()
            var name = binding.Addname.text.toString()
            var amount = binding.Addamount.text.toString()
            var cc = binding.Addcc.text.toString()
            var remark = binding.Addremark.text.toString()

            MainActivity.database.insertdata(name,amount,cc,remark,5)
            MainActivity.updated()
            dialog?.dismiss()

        }
//        fun onStart() {
//            super.onStart()
//            val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
//            val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
//            dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
//        }

        return binding.root
    }
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            add().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}