package com.example.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class noteDetailsFragment extends Fragment {

    private TextView bigTitle;
    private TextView detailedDescription;

    public static noteDetailsFragment newInstance(String title, String description){
        noteDetailsFragment noteDetailsFragment = new noteDetailsFragment();
        Bundle details = new Bundle();
        details.putString("Title", title);
        details.putString("Description",description);
        noteDetailsFragment.setArguments(details);
        return noteDetailsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details,container,false);

        bigTitle = (TextView)view.findViewById(R.id.bigTitle);
        detailedDescription= (TextView)view.findViewById(R.id.detailedDescription);
        Bundle details= getArguments();
        if(details!=null){
            String noteTitle= details.getString("Title");
            String noteDescription = details.getString("Description");
            bigTitle.setText(noteTitle);
            detailedDescription.setText(noteDescription);
        }
        return view;
    }

}
