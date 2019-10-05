package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter2 extends RecyclerView.Adapter<ContactAdapter2.Viewhoder> {

    List<Contact2> contacts;

    public ContactAdapter2(List<Contact2> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.mess_contact, parent, false);
        Viewhoder viewhoder = new Viewhoder(view);

        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhoder holder, int position) {
        final Contact2 contact = contacts.get(position);
        holder.tvName1.setText(contact.getName());
        holder.tvMess.setText(contact.getMess());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder {
        TextView tvName1,tvMess;
        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvName1 = itemView.findViewById(R.id.tvName1);
            tvMess = itemView.findViewById(R.id.tvMess);
        }
    }
}
