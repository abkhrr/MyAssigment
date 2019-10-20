package com.example.assignment.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment.BaseApplication.MyFragmentAdapter;
import com.example.assignment.R;
import com.example.assignment.inSideApprovalFragments.ApprovedFragment;
import com.example.assignment.inSideApprovalFragments.PendingFragment;
import com.example.assignment.inSideApprovalFragments.RejectedFragment;
import com.example.assignment.logAndReg.LoginActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import static com.example.assignment.BaseApplication.MainActivity.username;


public class ApprovalsFragment extends Fragment {

    private MyFragmentAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private TextView uname;

    SharedPreferences sharedpreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_approvals, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        adapter = new MyFragmentAdapter(Objects.requireNonNull(getActivity()).getSupportFragmentManager());
        adapter.addFragment(new PendingFragment(), "Pending");
        adapter.addFragment(new ApprovedFragment(), "Approved");
        adapter.addFragment(new RejectedFragment(), "Rejected");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        uname = (TextView) view.findViewById(R.id.textUnameAp);
        sharedpreferences = getActivity().getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);

        uname.setText(username);

        return view;
    }
}