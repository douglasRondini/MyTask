package com.douglasrondini.mytaskapplication.ui.addTask

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.douglasrondini.mytaskapplication.R
import com.douglasrondini.mytaskapplication.databinding.ActivityAddTaskBinding

class AddTaskActivity : AppCompatActivity() {
    private lateinit var txtLow: TextView
    private lateinit var txtMedium: TextView
    private lateinit var txtHigh: TextView

    private var selectedPriority: String = ""

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        txtLow = binding.txtLow
        txtMedium = binding.txtMedium
        txtHigh = binding.txtHigth

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupPrioritySelection()
    }

    private fun setupPrioritySelection() {
        val views = listOf(txtLow, txtMedium, txtHigh)

        views.forEach { view ->
            view.setOnClickListener {
                applyPrioritySelection(view, views)
            }
        }
    }

    private fun applyPrioritySelection(selectedView: TextView, allViews: List<TextView>) {
        allViews.forEach {
            it.foreground = null
            it.setTextColor(Color.BLACK)
        }

        selectedView.foreground = ContextCompat.getDrawable(this, R.drawable.bg_boda_selecionada)
        selectedView.setTextColor(Color.BLUE)

        selectedPriority = selectedView.text.toString()
    }

    fun getSelectedPriority(): String {
        return selectedPriority
    }
}


