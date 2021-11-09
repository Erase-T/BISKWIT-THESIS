package com.example.biskwit.Content.Lessons;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biskwit.Content.LessonFragment;
import com.example.biskwit.Content.Lessons.OrtonActivities.Blending;
import com.example.biskwit.Content.Lessons.OrtonActivities.Pagbabaybay;
import com.example.biskwit.Content.Lessons.OrtonActivities.Phonemic.Phonemic;
import com.example.biskwit.Content.Lessons.OrtonActivities.Phonemic.PhonemicAct;
import com.example.biskwit.Content.Lessons.OrtonActivities.Sight;
import com.example.biskwit.R;
import com.example.biskwit.databinding.FragmentOrtonBinding;


public class OrtonFragment extends Fragment {

    FragmentOrtonBinding binding;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOrtonBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // eto yung code para sa Aralin na button natin
        binding.Phoenimic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), PhonemicAct.class);
                startActivity(intent);
            }
        });

        binding.Sight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), Sight.class);
                startActivity(intent);
            }
        });

        binding.Blending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), Blending.class);
                startActivity(intent);
            }
        });

        binding.Pagbabaybay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getContext(), Pagbabaybay.class);
                startActivity(intent);
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentBack = new LessonFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main_nav_menu,fragmentBack);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

    }

    // need ito somehow para di magkabuhol buhol yung navigation thingy niya
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}