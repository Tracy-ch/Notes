package com.example.notes;

import android.view.View;

public interface NoteItemClickListener {


    public void noteItemClicked(View view, int adapterPosition, long itemId);
    public void deleteNoteItemClicked(int position);
}
