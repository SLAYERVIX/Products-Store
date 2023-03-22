package com.example.storeproducts.screens.login;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.storeproducts.databinding.FragmentLoginBinding;
import com.example.storeproducts.databinding.FragmentSplashBinding;
import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;

    FirebaseAuth mAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);

        binding.button.setOnClickListener(view -> {
            mAuth.signInWithEmailAndPassword(binding.etEmail.getText().toString(), binding.etPassword.getText().toString())
                    .addOnSuccessListener(success -> {
                        Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(failed -> {
                        Toast.makeText(requireContext(), "failed", Toast.LENGTH_SHORT).show();
                    });
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}