package com.mramirez.labo5_00078913

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), FragmentBasic.ToolBoxListener {

    override fun clickListenerHandler(view: TextView) {
        view.text="HOLAA"
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentBasic=FragmentBasic.newInstance("Hardcore", "text")
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_main,fragmentBasic)
            .commit()
    }

}

//clase abstracta son metodos definidos de la interfaz en este caso-> ()clicklistenerHandler