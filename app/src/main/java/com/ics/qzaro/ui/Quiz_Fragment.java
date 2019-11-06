package com.ics.qzaro.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ics.qzaro.R;

public class Quiz_Fragment extends Fragment
{

    TextView head,ques, op1, op2, op3, op4;

    String question , sop1, sop2, sop3, sop4;
    String shead;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz,container,false);

        head = (TextView) view.findViewById(R.id.tx_head);
        ques = (TextView) view.findViewById(R.id.tx_question);
        op1 = (TextView) view.findViewById(R.id.tx_op1);
        op2 = (TextView) view.findViewById(R.id.tx_op2);
        op3 = (TextView) view.findViewById(R.id.tx_op3);
        op4 = (TextView) view.findViewById(R.id.tx_op4);

        shead = getArguments().getString("head");

        head.setText(""+shead);

        ques.setText(" In which Continent does INDIA and China is located ?  ");

        op1.setText("EUROPE");
        op2.setText("AFRICA");
        op3.setText("ASIA");
        op4.setText("ANTARTICA");

        return view;
    }
}
