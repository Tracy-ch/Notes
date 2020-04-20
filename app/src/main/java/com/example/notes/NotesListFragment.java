package com.example.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class NotesListFragment extends Fragment implements NoteItemClickListener{


    private RecyclerView recyclerView;
    List<NoteItem> noteItemsList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes_list,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
 if(noteItemsList.isEmpty()) {
     noteItemsList.add(new NoteItem("Project Meeting", "It went good. The project is about Youtube Privacy Policy. I took the part of what are The policies that Youtube is using and in case of any problem, what are the steps that Youtube take"));
     noteItemsList.add(new NoteItem("To Do Today", "Need To go to the Supermarket and get a medicine for the dog"));
     noteItemsList.add(new NoteItem("Pasta Recipe", "Boil the pasta in water, do the sauce: red sauce, mushrooms, onion, salt, pepper, cheese, than add the pasta"));
 }
        final Adapter adapter= new Adapter(noteItemsList, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
    public void removeItem(int position){
        noteItemsList.remove(position);
        final Adapter adapter= new Adapter(noteItemsList, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyItemRemoved(position);
    }


    @Override
    public void noteItemClicked(View view, int adapterPosition, long itemId){
        NoteItem noteItem = noteItemsList.get(adapterPosition);
        ((MainActivity)getActivity()).swapFragments(noteDetailsFragment.newInstance(noteItem.getTitle(),noteItem.getDescription()));
        noteItemsList.clear();

    }

    @Override
    public void deleteNoteItemClicked(int position) {
        removeItem(position);
    }
}