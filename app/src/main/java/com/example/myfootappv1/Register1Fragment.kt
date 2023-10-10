package com.example.myfootappv1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myfootappv1.databinding.FragmentRegister1Binding

class Register1Fragment : Fragment() {

    private var _binding : FragmentRegister1Binding? = null
    private val binding : FragmentRegister1Binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegister1Binding.inflate(inflater,container,false)
        Log.d("Wesh", "C'est bien la le problème")
      // binding.FragmentRegister1Binding.setOnClickListener{
            //findNavController().navigate(R.id.)
           // findNavController().navigate(R.id.)
        //}

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Register1Fragment()
    }
}