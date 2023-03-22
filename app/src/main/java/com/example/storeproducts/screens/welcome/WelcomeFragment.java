package com.example.storeproducts.screens.welcome;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.storeproducts.R;
import com.example.storeproducts.databinding.FragmentLoginBinding;
import com.example.storeproducts.databinding.FragmentWelcomeBinding;

public class WelcomeFragment extends Fragment {

    FragmentWelcomeBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentWelcomeBinding.inflate(inflater,container,false);

        binding.btnLogin.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_loginFragment);
        });

        binding.btnRegister.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_welcomeFragment_to_registerFragment);
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}