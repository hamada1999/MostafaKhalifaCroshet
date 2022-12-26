package com.example.mostafakhalifacroshet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.mostafakhalifacroshet.R
import com.example.mostafakhalifacroshet.databinding.FragmentLoginBinding
import com.example.mostafakhalifacroshet.viewModels.LoginViewModel
import com.example.mostafakhalifacroshet.viewModels.RegisterViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding : FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login
            , container, false)

        loginViewModel = ViewModelProviders.of(this)
            .get(LoginViewModel::class.java)
        binding.loginViewModel = loginViewModel

        loginViewModel.errorMailInput.observe(viewLifecycleOwner, Observer {
            if(it)
                binding.mailEditext.error = "this field is required"
        })

        loginViewModel.errorPassInput.observe(viewLifecycleOwner, Observer {
            if(it)
                binding.mailEditext.error = "this field is required"
        })

        loginViewModel.navigateToSignUp.observe(viewLifecycleOwner, Observer {

            if(it){
                var action = LoginFragmentDirections.actionLoginFragmentToUserTypeFragment()
                NavHostFragment.findNavController(this).navigate(action)
            }

        })

        loginViewModel.navigateToHome.observe(viewLifecycleOwner, Observer {
            if(it){
                var action = LoginFragmentDirections.actionLoginFragmentToMainActivity()
                NavHostFragment.findNavController(this).navigate(action)
            }else
                Toast.makeText(activity, "failure authentecation" , Toast.LENGTH_SHORT).show()
        })

        return binding.root

    }


}