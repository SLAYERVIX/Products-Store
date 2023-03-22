package com.example.storeproducts.screens.details;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.storeproducts.databinding.FragmentDetailsBinding;

public class DetailsFragment extends Fragment {
    private FragmentDetailsBinding binding;
    private DetailsFragmentArgs args;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = DetailsFragmentArgs.fromBundle(getArguments());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater,container,false);


        binding.tvName.setText(args.getProduct().title);
        binding.tvBrand.setText(args.getProduct().brand);
        binding.tvPrice.setText(String.valueOf(args.getProduct().price));
        binding.tvDiscount.setText(args.getProduct().discountPercentage + " OFF");
        binding.tvRating.setText(String.valueOf(args.getProduct().rating));
        binding.tvDesc.setText(args.getProduct().description);

        Glide.with(binding.imageView).load(args.getProduct().images.get(0)).centerCrop().into(binding.imageView);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}