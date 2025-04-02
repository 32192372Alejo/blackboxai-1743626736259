package com.example.entrevistasimulator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.entrevistasimulator.databinding.ActivityInterviewSelectionBinding

class InterviewSelectionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInterviewSelectionBinding
    private var selectedInterviewType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInterviewSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        // Back button
        binding.btnBack.setOnClickListener {
            finish()
        }

        // Interview type cards
        binding.cardTechnical.setOnClickListener {
            selectedInterviewType = getString(R.string.technical_practice)
            updateCardSelection(it)
        }

        // Start simulation button
        binding.btnStartSimulation.setOnClickListener {
            if (selectedInterviewType == null) {
                Toast.makeText(this, "Por favor seleccione un tipo de entrevista", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val difficulty = when (binding.difficultyGroup.checkedRadioButtonId) {
                R.id.rbEasy -> "Fácil"
                R.id.rbNormal -> "Normal"
                R.id.rbHard -> "Difícil"
                else -> {
                    Toast.makeText(this, "Por favor seleccione un nivel de dificultad", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            startInterview(selectedInterviewType!!, difficulty)
        }

        // FAQ link
        binding.tvFaq.setOnClickListener {
            // TODO: Navigate to FAQ screen
        }
    }

    private fun updateCardSelection(selectedCard: View) {
        // Reset all cards background
        binding.cardTechnical.setCardBackgroundColor(getColor(R.color.card_background))
        
        // Update selected card background
        selectedCard.setBackgroundColor(getColor(R.color.selected_card_background))
    }

    private fun startInterview(type: String, difficulty: String) {
        // TODO: Start interview activity with selected type and difficulty
        Toast.makeText(this, "Iniciando $type - $difficulty", Toast.LENGTH_SHORT).show()
    }
}