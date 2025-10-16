package com.douglasrondini.mytaskapplication.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.douglasrondini.mytaskapplication.R
import com.douglasrondini.mytaskapplication.databinding.ActivityHomeTaskBinding
import com.douglasrondini.mytaskapplication.ui.addTask.AddTaskActivity
import com.douglasrondini.mytaskapplication.ui.home.adapter.ViewPageAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeTaskBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeTaskBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewPage()
        tabLayout()
    }

    override fun onResume() {
        super.onResume()
        initClicks()
    }

    private fun tabLayout() {
        val tabTitles = listOf("All", "Pending", "Completed")




        TabLayoutMediator(binding.tabLayout, binding.viewPage) {tab, position ->
            val customView = LayoutInflater.from(this).inflate(R.layout.tab_item, null)
            val titles = customView.findViewById<TextView>(R.id.tabTitle)
            titles.text =  tabTitles[position]
            tab.customView = customView
        }.attach()

    }
    private fun viewPage() {
        val viewPage = binding.viewPage
        viewPage.adapter = ViewPageAdapter(this)
    }
    private fun initClicks() {
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }

}