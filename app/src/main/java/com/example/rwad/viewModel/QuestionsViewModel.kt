package com.example.rwad.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.rwad.R
import com.example.rwad.models.Question
import javax.security.auth.callback.Callback

class QuestionsViewModel:ViewModel(){
    val questions: List<Question> = listOf(
        Question(
            "What is Android Jetpack?",
            listOf("All of these", "Tools", "Documentation", "Libraries"),
            "All of these"
        ),
        Question(
            "Base class for Adapter",
            listOf("RecyclerView.Adapter", "ListView.Adapter", "Both of the above", "None of the above"),
            "RecyclerView.Adapter"
        ),
        Question(
            "Layout for complex Screens",
            listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout"),
            "ConstraintLayout"
        ),
        Question(
            "Pushing structured data into a Layout",
            listOf("Data Binding", "Data Pushing", "Set Text", "OnClick"),
            "Data Binding"
        ),
        Question(
            "Inflate layout in fragments",
            listOf("onCreateView", "onViewCreated", "onCreateLayout", "onInflateLayout"),
            "onCreateView"
        )
    )
        private var _score = MutableLiveData<Int>(0)
    val score: LiveData<Int>
        get() = _score
         private var _index =MutableLiveData<Int>(0)
    val index: LiveData<Int>
        get() = _index


    fun  nextQuestion(correctAnswer:String,){
        if(questions[_index.value!!].correctAnswer == correctAnswer){
            _score.value = _score.value?.plus(1)
        }
      if(_index.value!! < questions.size-1){
          _index.value = _index.value?.plus(1)
      }


    }







}