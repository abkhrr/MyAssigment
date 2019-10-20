package com.example.assignment.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.assignment.LoginAndRegisterActivity;
import com.example.assignment.R;
import com.example.assignment.logAndReg.LoginActivity;

import java.util.Objects;

import static com.example.assignment.logAndReg.LoginActivity.TAG_ID;
import static com.example.assignment.logAndReg.LoginActivity.TAG_USERNAME;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment {

    private Button buttonLogout;


    public MoreFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        buttonLogout = (Button) view.findViewById(R.id.logoutBtn);
        final SharedPreferences sharedpreferences = Objects.requireNonNull(getContext()).getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);

        buttonLogout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(LoginActivity.session_status, false);
                editor.putString(TAG_ID, null);
                editor.putString(TAG_USERNAME, null);
                editor.commit();

                Intent intent = new Intent(Objects.requireNonNull(getContext()).getApplicationContext(), LoginAndRegisterActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });
        return view;
    }
}
