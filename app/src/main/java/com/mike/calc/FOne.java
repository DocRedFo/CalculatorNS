package com.mike.calc;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class FOne extends Fragment {

    Button one, two, three, four, five, six, seven, eight, nine, zero, point, scobone, scobtwo;

    @Override
    public void onStart() {
        super.onStart();

        one = getActivity().findViewById(R.id.button9);
        two = getActivity().findViewById(R.id.button8);
        three = getActivity().findViewById(R.id.button7);
        four = getActivity().findViewById(R.id.button12);
        five = getActivity().findViewById(R.id.button11);
        six = getActivity().findViewById(R.id.button10);
        seven = getActivity().findViewById(R.id.button15);
        eight = getActivity().findViewById(R.id.button14);
        nine = getActivity().findViewById(R.id.button13);
        zero = getActivity().findViewById(R.id.button16);
        point = getActivity().findViewById(R.id.button17);
        scobone = getActivity().findViewById(R.id.button18);
        scobtwo = getActivity().findViewById(R.id.button19);


        one.setOnClickListener(new FTwo().listener);
        two.setOnClickListener(new FTwo().listener);
        three.setOnClickListener(new FTwo().listener);
        four.setOnClickListener(new FTwo().listener);
        five.setOnClickListener(new FTwo().listener);
        six.setOnClickListener(new FTwo().listener);
        eight.setOnClickListener(new FTwo().listener);
        seven.setOnClickListener(new FTwo().listener);
        nine.setOnClickListener(new FTwo().listener);
        zero.setOnClickListener(new FTwo().listener);
        point.setOnClickListener(new FTwo().listener);
        scobone.setOnClickListener(new FTwo().listener);
        scobtwo.setOnClickListener(new FTwo().listener);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fone, container, false);
    }
}
