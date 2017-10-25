package com.acme.bank.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.acme.bank.R;
import com.applaunch.api.AppLaunch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class CCFragment extends Fragment {

    public CCFragment() {
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
        //duedate
        View view =inflater.inflate(R.layout.fragment_two, container, false);
        TextView dueDate = view.findViewById(R.id.duedate);
        Date curDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("MMM-yyyy");
        String dateToStr = format.format(curDate);
        dueDate.setText("23-"+dateToStr);


        Date closingdt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(closingdt);
        c.add(Calendar.MONTH, -1);
        closingdt = c.getTime();
        String closingToStr = format.format(closingdt);
        TextView closingDate = view.findViewById(R.id.closingDate);
        closingDate.setText("Closing date 26-"+closingToStr);
        final TextView lastPaymentAmount = view.findViewById(R.id.lastpaymentamount);
        final TextView totalAmount = view.findViewById(R.id.totalamount);

        final Button makePayment = view.findViewById(R.id.makepayment);
        final CardView cardView = view.findViewById(R.id.makepayment_view);
        final Animation animation = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_coupon);
        makePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList metricsList = new ArrayList();
                metricsList.add("_ytl532lzi");
                AppLaunch.getInstance().sendMetrics(metricsList);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        getActivity());

                // set title
                alertDialogBuilder.setTitle("Payment");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Payment successfully made!")
                        .setCancelable(false)
                        .setPositiveButton("Ok",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                                cardView.startAnimation(animation);
                                lastPaymentAmount.setText("5000.00");
                                totalAmount.setText("5000.00");
                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show it
                alertDialog.show();


                cardView.setAnimation(animation);
                cardView.setVisibility(View.GONE);
            }
        });

        return view;
    }

}
