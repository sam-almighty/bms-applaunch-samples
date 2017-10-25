package com.acme.bank.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.acme.bank.R;
import com.acme.bank.service.AcmeBankManager;


/**
 * Created by norton on 10/24/17.
 */

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout linearLayout = view.findViewById(R.id.customertypeheader);
        TextView customerType = view.findViewById(R.id.customertypetext);
        if("norton".equals(AcmeBankManager.getInstance().getApplicationUser())){
            linearLayout.setBackgroundColor(getResources().getColor(R.color.goldenColor));
            customerType.setText("Privileged Customer");
        }else{
            linearLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
            customerType.setText("Welcome to Acme Bank");
        }

        return view;
    }

}

