package com.example.rwad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.rwad.databinding.FragmentQuestionBinding
import com.example.rwad.viewModel.QuestionsViewModel

class QuestionFragment : Fragment() {
lateinit var binding: FragmentQuestionBinding
 val viewModel : QuestionsViewModel by viewModels()
    lateinit var myAnswer:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        binding.questionTitle.text =viewModel.questions[viewModel.index.value!!].title
        binding.radioButton1.text =viewModel.questions[viewModel.index.value!!].answers[0]
        binding.radioButton2.text =viewModel.questions[viewModel.index.value!!].answers[1]
        binding.radioButton3.text =viewModel.questions[viewModel.index.value!!].answers[2]
        binding.radioButton4.text =viewModel.questions[viewModel.index.value!!].answers[3]
        binding.scoreTextView.text = "Score: ${viewModel.score}"

        viewModel.index.observe(viewLifecycleOwner, Observer{ newIndex ->
            binding.questionTitle.text =viewModel.questions[ newIndex].title
            binding.radioButton1.text =viewModel.questions[ newIndex].answers[0]
            binding.radioButton2.text =viewModel.questions[ newIndex].answers[1]
            binding.radioButton3.text =viewModel.questions[ newIndex].answers[2]
            binding.radioButton4.text =viewModel.questions[ newIndex].answers[3]

        })

        viewModel.score.observe(viewLifecycleOwner, Observer{ newScore ->
            binding.scoreTextView.text = "Score: $newScore"
        })


        binding.nextButton.setOnClickListener{
            myAnswer = when(binding.radioGroup.checkedRadioButtonId){
                R.id.radioButton1 -> binding.radioButton1.text.toString()
                R.id.radioButton2 -> binding.radioButton2.text.toString()
                R.id.radioButton3 -> binding.radioButton3.text.toString()
                R.id.radioButton4 -> binding.radioButton4.text.toString()
                else -> ""
            }
            if(myAnswer.isNotEmpty())
           viewModel.nextQuestion(myAnswer)

        }


        return binding.root

    }


}