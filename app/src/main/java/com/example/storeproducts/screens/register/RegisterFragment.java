package com.example.storeproducts.screens.register;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.storeproducts.R;
import com.example.storeproducts.databinding.FragmentRegisterBinding;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterFragment extends Fragment {
    FragmentRegisterBinding binding;
    FirebaseAuth mAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentRegisterBinding.inflate(inflater, container, false);

        binding.btnRegister.setOnClickListener(view -> {
            mAuth.createUserWithEmailAndPassword(binding.etEmail.getText().toString(), binding.etPassword.getText().toString())
                    .addOnSuccessListener(success -> {
                        Navigation.findNavController(view).navigate(R.id.action_registerFragment_to_homeFragment);
                    })
                    .addOnFailureListener(failed -> {
                        Toast.makeText(requireContext(),failed.getMessage() , Toast.LENGTH_SHORT).show();
                    });
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}