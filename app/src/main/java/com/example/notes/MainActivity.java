package com.example.notes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton addNote;
    List<NoteItem> NoteItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        NoteItemList.add(new NoteItem("Project Meeting","It went good. The project is about Youtube Privacy Policy. I took the part of what are The policies that Youtube is using and in case of any problem, what are the steps that Youtube take"));
        NoteItemList.add(new NoteItem("To Do Today","Need To go to the Supermarket and get a medicine for the dog"));
        NoteItemList.add(new NoteItem("Pasta Recipe","Boil the pasta in water, do the sauce: red sauce, mushrooms, onion, salt, pepper, cheese, than add the pasta"));

        Adapter adapter= new Adapter(NoteItemList);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        addNote = findViewById(R.id.addNote);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNoteDialogBox();
            }
        });
        }

        private void addNoteDialogBox(){
            final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.dialog_box, null);
            final EditText title_inputText = (EditText) mView.findViewById(R.id.titleInput);
            final EditText description_inputText = (EditText) mView.findViewById(R.id.descriptionInput);
            Button btn_cancel= (Button) mView.findViewById(R.id.cancel_button);
            Button btn_ok= (Button) mView.findViewById(R.id.ok_button);
             alert.setView(mView);
            final AlertDialog alertDialog = alert.create();
            alertDialog.setCanceledOnTouchOutside(false);
             btn_cancel.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     alertDialog.dismiss();
                 }
             });

             btn_ok.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     NoteItemList.add(new NoteItem(title_inputText.getText().toString(),description_inputText.getText().toString()));
                     alertDialog.dismiss();
                 }
             });
            alertDialog.show();
        }
    }

