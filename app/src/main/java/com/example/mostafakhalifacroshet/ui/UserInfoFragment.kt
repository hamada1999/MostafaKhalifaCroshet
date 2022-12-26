package com.example.mostafakhalifacroshet.ui

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.widget.AppCompatAutoCompleteTextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.mostafakhalifacroshet.R
import com.example.mostafakhalifacroshet.viewModels.RegisterViewModel
import com.example.mostafakhalifacroshet.databinding.FragmentUserInfoBinding
import com.example.mostafakhalifacroshet.models.Customer
import com.example.mostafakhalifacroshet.utils.UserType
import com.example.mostafakhalifacroshet.utils.userType

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserInfoFragment : Fragment() {

    lateinit var registerViewModel: RegisterViewModel
    lateinit var cus : Customer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding : FragmentUserInfoBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_info
            , container, false)

        registerViewModel = ViewModelProviders.of(this)
            .get(RegisterViewModel::class.java)
        binding.viewModel = registerViewModel

        val genderList = resources.getStringArray(R.array.gender_array)
        val genderAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, genderList)
        binding.genderAutocomplete.setAdapter(genderAdapter)

        registerViewModel.errorNameInput.observe(viewLifecycleOwner, Observer {
            if(it)
                binding.nameEditext.error = "enter valid name!"
        })

        registerViewModel.errorMailInput.observe(viewLifecycleOwner, Observer {
            if(it)
                binding.mailEditext.error = "enter valid email!"
        })

        registerViewModel.errorPassInput.observe(viewLifecycleOwner, Observer {
            if(it)
                binding.passEditext.error = "this password is too weak!"
        })

        registerViewModel.errorPhoneInput.observe(viewLifecycleOwner, Observer {
            if(it)
                binding.phoneEditext.error = "enter a valid phone number!"
        })

        registerViewModel.errorAgeInput.observe(viewLifecycleOwner, Observer {
            if(it)
                binding.ageEditext.error = "this age in not valid!"
        })

        registerViewModel.navigateToSignIn.observe(viewLifecycleOwner, Observer {
            if(it){
                var action = UserInfoFragmentDirections.actionUserInfoFragmentToLoginFragment()
                NavHostFragment.findNavController(this).navigate(action)
            }
        })

        registerViewModel.navigateToHome.observe(viewLifecycleOwner, Observer {
            if(it){
                var action = UserInfoFragmentDirections.actionUserInfoFragmentToMainActivity()
                NavHostFragment.findNavController(this).navigate(action)
            }
        })

        return binding.root
    }


}