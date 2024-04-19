package com.example.mylearningapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addConceptButton: Button
    private lateinit var conceptText: EditText
    private lateinit var adapter: AdapterClass
    private lateinit var dataList: ArrayList<DataClass>
    private val imageList: ArrayList<Int> = ArrayList()
    private val titleList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_activity)

        titleList.add("Basics of Kotlin")
      /*  titleList.add("Basics of Android Studio")
        titleList.add("Activity")
        titleList.add("Fragment")
        titleList.add("Fragment Lifecycle")
        titleList.add("Git")
        titleList.add("Recyclerview")*/


        recyclerView = findViewById(R.id.recyclerview)
        addConceptButton = findViewById(R.id.bn_add_concept)
        conceptText = findViewById(R.id.et_concept_text)

        addConceptButton.setOnClickListener {
            val concept = conceptText.text.toString()
            if(concept.isEmpty()){
                Toast.makeText(this,"Enter Valid Concept Name",Toast.LENGTH_LONG).show()
            }else{
                dataList.add(DataClass(1,concept))
                adapter.notifyDataSetChanged()
                conceptText.setText("")
            }

        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf()
        getData()
    }

    private fun getData() {
        for (title in titleList) {
            val dataClass = DataClass(1, title)
            dataList.add(dataClass)
        }
        adapter = AdapterClass(dataList)
        recyclerView.adapter = adapter
    }
}