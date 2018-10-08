package com.example.khojiakbar.demotransition

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView


class MainActivity : AppCompatActivity(), MyRecyclerViewAdapter.ItemClickListener {

    lateinit var adapter: MyRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // data to populate the RecyclerView with
        val animalNames = arrayListOf("Horse", "Cow", "Camel", "Sheep", "Goat")

        // set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvAnimals)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyRecyclerViewAdapter(this, animalNames)
        adapter.setClickListener(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(view: View, position: Int, myTextView: TextView) {
        val transitionName = ViewCompat.getTransitionName(myTextView)

        val intent = Intent(this@MainActivity, TransitionActivity::class.java)
        intent.putExtra(TransitionActivity.TRANSITION_NAME, transitionName)
        val options = ActivityOptions.makeSceneTransitionAnimation(this, myTextView, transitionName)
        startActivity(intent, options.toBundle())
    }
}
