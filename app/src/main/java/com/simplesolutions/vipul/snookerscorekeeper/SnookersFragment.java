package com.simplesolutions.vipul.snookerscorekeeper;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Rohit on 6/25/2017.
 */

public class SnookersFragment extends DialogFragment implements View.OnClickListener
{
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View sfView= inflater.inflate(R.layout.snooker_fragment_layout,null);
        TextView tv = (TextView)sfView.findViewById(R.id.snookersDisplay);
        Button db = (Button)sfView.findViewById(R.id.dismissButton);
        String temp = getArguments().getString("snookerString");
        tv.setText(temp);
        builder.setView(sfView);
        db.setOnClickListener(this);
        return builder.create();
    }
    public void onClick(View v)
    {
        dismiss();
    }
}
