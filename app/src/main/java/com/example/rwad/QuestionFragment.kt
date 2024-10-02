package com.example.rwad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.rwad.databinding.FragmentQuestionBinding
import com.example.rwad.viewModel.QuestionsViewModel

class QuestionFragment : Fragment() {
    lateinit var binding: FragmentQuestionBinding
    val viewModel: QuestionsViewModel by viewModels()
    lateinit var myAnswer: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        binding.questionViewModel = viewModel
        binding.lifecycleOwner = this

        binding.nextButton.setOnClickListener {
            myAnswer = when (binding.radioGroup.checkedRadioButtonId) {
                R.id.radioButton1 -> binding.radioButton1.text.toString()
                R.id.radioButton2 -> binding.radioButton2.text.toString()
                R.id.radioButton3 -> binding.radioButton3.text.toString()
                R.id.radioButton4 -> binding.radioButton4.text.toString()
                else -> ""
            }
            if (myAnswer.isNotEmpty()) viewModel.nextQuestion(myAnswer, navigateToSuccess = {
                Navigation.findNavController(it).navigate(R.id.action_questionFragment_to_successFragment)
            },
            navigateToFailure = {
                Navigation.findNavController(it).navigate(R.id.action_questionFragment_to_failureFragment)
            }
            )

        }


        return binding.root

    }


}