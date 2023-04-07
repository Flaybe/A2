package com.example.a22;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a22.databinding.FragmentDetailBinding;


public class DetailFragment extends Fragment {

    private static final String ROLE = "role";
    private static final String CHAMPIONS = "champions";

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String role, String champions) {
        DetailFragment fragment = new DetailFragment();

        Bundle args = new Bundle();
        args.putString(ROLE, role);
        args.putString(CHAMPIONS, champions);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String mRole = getArguments().getString(ROLE);
            String mChampions = getArguments().getString(CHAMPIONS);
        }
    }

    FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());
        binding.Info.setText(args.getChampions());
        return binding.getRoot();
    }
}
