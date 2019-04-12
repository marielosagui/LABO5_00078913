package com.mramirez.labo5_00078913

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_basic.view.*
import java.lang.Exception

const val ARG_TEXT1 ="texto1"
const val ARG_TEXT2 ="texto2"

class FragmentBasic :Fragment() {

    var texto1: String? = null
    var texto2: String? = null
    var toolBox:ToolBoxListener?=null

    //INTANCIANDO TOOLBOXLISTENER

    override fun onAttach(context: Context?) {
        super.onAttach(context) //onAttach TRAE CONTEXTO...
        if(context is ToolBoxListener){
            toolBox=context
        }else{
            throw Exception("SE NECESITA....TOOL BOX LISTENER")
        }
    }

    override fun onDetach() //para destruir
     {
        super.onDetach()
         toolBox=null
    }
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            texto1 = getString(ARG_TEXT1, "")
            texto2 = getString(ARG_TEXT2, "")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_basic, container, false).apply {
            tv_texto1.text = texto1
            tv_texto2.text = texto2
            action.setOnClickListener {
                toolBox?.clickListenerHandler(tv_texto1)
            }
        }
    }

    companion object {
        fun newInstance(texto1: String, text2: String) = FragmentBasic().apply {
            arguments = Bundle().apply {
                putString(ARG_TEXT1, texto1)
                putString(ARG_TEXT2, texto2)
            }
        }
    }


    interface ToolBoxListener {
        fun clickListenerHandler(view:TextView)
    }
}