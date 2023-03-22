package com.example.storeproducts.screens.splash;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.storeproducts.R;
import com.example.storeproducts.databinding.FragmentSplashBinding;
import com.google.firebase.auth.FirebaseAuth;


public class SplashFragment extends Fragment {

    FragmentSplashBinding binding;

    FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(inflater,container,false);

        mAuth = FirebaseAuth.getInstance();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mAuth.getCurrentUser() != null) {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_splashFragment_to_homeFragment);
        }
        else {
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_splashFragment_to_welcomeFragment);
        }
    }
}