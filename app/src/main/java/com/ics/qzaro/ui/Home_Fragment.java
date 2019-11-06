package com.ics.qzaro.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.ics.qzaro.MainActivity;
import com.ics.qzaro.R;

public class Home_Fragment extends Fragment
{
    ImageView imgtoolbar;
    CardView card1, card2, card3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_home,container,false);

    imgtoolbar = (ImageView) view.findViewById(R.id.imgToolbar);

    card1 = view.findViewById(R.id.crd_normal);
    card2 = view.findViewById(R.id.crd_zara);
    card3 = view.findViewById(R.id.crdlast);

    imgtoolbar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).openDrawer();
        }
    });

    Click_Listeners();

    return view;
    }

    private void Click_Listeners(){
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).Call_QUIZ(" N o r m a l  Q u i z ");
            }
        });


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).Call_QUIZ(" Z a r a  H a t k e  Q u i z ");
            }
        });


        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).Call_QUIZ(" D a i l y  Q u i z ");
            }
        });
    }

}
