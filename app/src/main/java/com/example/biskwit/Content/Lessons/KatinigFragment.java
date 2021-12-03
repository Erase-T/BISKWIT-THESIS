package com.example.biskwit.Content.Lessons;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.biskwit.Content.EasyFragment;
import com.example.biskwit.Content.Lessons.KatinigActivities.KatinigChoices1;
import com.example.biskwit.Content.Lessons.KatinigActivities.KatinigLesson1;
import com.example.biskwit.Content.Lessons.KatinigActivities.KatinigChoices2;
import com.example.biskwit.R;
import com.example.biskwit.databinding.FragmentKatinigBinding;


public class KatinigFragment extends Fragment {

        FragmentKatinigBinding binding;
        Intent intent;

        public static final String filename = "idfetch";
        public static final String UserID = "userid";

        int id;
        SharedPreferences logger, mpath;
        SharedPreferences.Editor editor;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            binding = FragmentKatinigBinding.inflate(getLayoutInflater());
            return binding.getRoot(); // for the drawer
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @SuppressLint("ResourceType")
        public void onViewCreated(View view, Bundle savedInstanceState)
        {
            super.onViewCreated(view, savedInstanceState);

            logger = getContext().getSharedPreferences(filename, Context.MODE_PRIVATE);
            id = logger.getInt(UserID,0);

            mpath = getContext().getSharedPreferences("Mastery" + id, Context.MODE_PRIVATE);
            editor = mpath.edit();

            binding.KatinigAralin1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent = new Intent(getContext(), KatinigLesson1.class);
                    startActivity(intent);
                }
            });

            if (mpath.contains("K_Aralin1Locked")){
                binding.KatinigAralin2.setBackgroundTintList(getResources().getColorStateList(R.drawable.buttontint));
            } else {
                binding.KatinigAralin2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent = new Intent(getContext(), KatinigChoices1.class);
                        startActivity(intent);
                    }
                });
            }

            /*if (mpath.contains("K_Aralin1Locked") || mpath.contains("K_Aralin2Locked")){
                binding.KatinigAralin3.setBackgroundTintList(getResources().getColorStateList(R.drawable.buttontint));
            } else {
                binding.KatinigAralin3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent = new Intent(getContext(), KatinigChoices2.class);
                        startActivity(intent);
                    }
                });
            }*/

            binding.back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Fragment fragmentBack = new EasyFragment();
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