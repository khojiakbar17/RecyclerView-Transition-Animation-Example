package com.example.khojiakbar.demotransition

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_transition.*

class TransitionActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition)

        Log.d("asd", "TA")

        val transitionName = intent.getStringExtra(TRANSITION_NAME)

        tvTransition.transitionName = transitionName
    }

    companion object {
        const val TRANSITION_NAME = "transitionName"
    }

}