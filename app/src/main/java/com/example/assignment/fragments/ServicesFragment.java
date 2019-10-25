package com.example.assignment.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.assignment.CardviewOption.FilesActivity;
import com.example.assignment.CardviewOption.TrackerActivity;
import com.example.assignment.R;
import com.example.assignment.logAndReg.LoginActivity;

import java.util.Objects;

import static com.example.assignment.BaseApplication.MainActivity.username;

public class ServicesFragment extends Fragment {

    private TextView uname;
    SharedPreferences sharedPreferences;
    private RelativeLayout cv4, cv1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services, container, false);

        sharedPreferences = Objects.requireNonNull(getActivity()).getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);

        uname = (TextView) view.findViewById(R.id.textUnameSe);
        uname.setText(username);

        cv4 = (RelativeLayout) view.findViewById(R.id.cv4);
        cv1 = (RelativeLayout) view.findViewById(R.id.cv1);

        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), FilesActivity.class);
                startActivity(intent);
            }
        });

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext().getApplicationContext(), TrackerActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
