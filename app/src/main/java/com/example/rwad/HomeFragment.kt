package com.example.rwad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.rwad.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding:FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
binding.startQuizBtn.setOnClickListener(){
    Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_questionFragment)
}
        return  binding.root
    }


}