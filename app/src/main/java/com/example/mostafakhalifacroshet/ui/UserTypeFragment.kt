package com.example.mostafakhalifacroshet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.mostafakhalifacroshet.R
import com.example.mostafakhalifacroshet.utils.UserType
import com.example.mostafakhalifacroshet.utils.userType

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserTypeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserTypeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        var view =  inflater.inflate(R.layout.fragment_user_type, container, false)

        var radioGroup : RadioGroup = view.findViewById(R.id.radio_group)
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.customer ->
                        userType = UserType.CUSTOMER
                R.id.artist ->
                        userType = UserType.ARTIST
                R.id.moderator ->
                        userType = UserType.MODERATOR
                R.id.admin ->
                        userType = UserType.ADMIN
            }
        }

        val button : Button = view.findViewById(R.id.submit_button)
        button.setOnClickListener(View.OnClickListener {
            val action = UserTypeFragmentDirections.actionUserTypeFragmentToUserInfoFragment()
            NavHostFragment.findNavController(this).navigate(action)
        })

        return view
    }

}