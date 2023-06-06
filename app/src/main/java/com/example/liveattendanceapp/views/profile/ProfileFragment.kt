package com.example.liveattendanceapp.views.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.liveattendanceapp.R
import com.example.liveattendanceapp.databinding.FragmentProfileBinding
import com.example.liveattendanceapp.views.changepass.ChangePasswordActivity
import com.example.liveattendanceapp.views.login.LoginActivity
import com.example.liveattendanceapp.views.main.MainActivity

class ProfileFragment : Fragment() {

    private var binding: FragmentProfileBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
    }

    private fun onClick() {
        binding?.btnChangePassword?.setOnClickListener {
            val intent = Intent(binding?.root?.context, ChangePasswordActivity::class.java)
            binding?.root?.context?.startActivity(intent)
        }

        binding?.btnChangeLanguage?.setOnClickListener {
            toast("Change Language")
        }

        binding?.btnLogout?.setOnClickListener {
            val intent = Intent(binding?.root?.context, LoginActivity::class.java)
            binding?.root?.context?.startActivity(intent)
            (activity as MainActivity).finishAffinity()
        }
    }

    private fun toast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}