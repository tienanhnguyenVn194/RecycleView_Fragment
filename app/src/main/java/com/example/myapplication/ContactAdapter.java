package com.example.myapplication;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Viewhoder> implements View.OnCreateContextMenuListener {

    List<Contact> contacts;
    IconClick iconClick;

    public ContactAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public void setIonClickContact(IconClick iconClick) {
        this.iconClick = iconClick;
    }

    @NonNull
    @Override
    public Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_contact, parent, false);
        Viewhoder viewhoder = new Viewhoder(view);

        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhoder holder, int position) {

        final Contact contact = contacts.get(position);
        holder.tvName.setText(contact.getName());

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconClick.onClickName(contact.getName());
            }
        });

    }

    @Override
    public int getItemCount() {
        return  contacts.size();
    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        contextMenu.add(Menu.NONE, R.id.mnEdit, Menu.NONE, "Edit");
        contextMenu.add(Menu.NONE, R.id.mnSent, Menu.NONE, "Send");
    }

    public class Viewhoder extends RecyclerView.ViewHolder {

        TextView tvName;

        public Viewhoder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
