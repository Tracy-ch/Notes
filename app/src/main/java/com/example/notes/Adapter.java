package com.example.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {

    private List<NoteItem> NoteItemList;
    private NoteItemClickListener noteItemClickListener;

    public Adapter(List<NoteItem> NoteItemList, NoteItemClickListener noteItemClickListener) {
        this.NoteItemList = NoteItemList;
        this.noteItemClickListener = noteItemClickListener;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int position) {

        String title = NoteItemList.get(position).getTitle();
        String description=NoteItemList.get(position).getDescription();
        viewholder.setData(title, description);
    }

    @Override
    public int getItemCount() {
        return NoteItemList.size();
    }

    class Viewholder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        private TextView title;
        private TextView description;
        private ImageView deleteImage;


        public Viewholder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.textTitle);
            description= itemView.findViewById(R.id.textDescription);
            itemView.setOnClickListener(this);
            deleteImage= itemView.findViewById(R.id.deletelv);
            deleteImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(noteItemClickListener !=null){
                        int position = getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            noteItemClickListener.deleteNoteItemClicked(position);
                        }
                    }
                }
            });
        }

        private void setData(String titleText, String descriptionText){
                title.setText((CharSequence) titleText);
                description.setText((CharSequence) descriptionText);
        }

        @Override
        public void onClick(View view) {
            if(noteItemClickListener != null){

               noteItemClickListener.noteItemClicked(view, getAdapterPosition(), getItemId());

            }

        }
    }
}