package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {

    Contact contact1,contact2,contact3,contact4,contact5,
    contact6,contact7,contact8,contact9;
    RecyclerView recyclerView;
    List<Contact> contacts;
    ContactAdapter contactAdapter;

    public static Fragment newInstance(Contact contact) {
        Bundle args = new Bundle();
        args.putSerializable("contactPut", contact);
        Home_Fragment fragment = new Home_Fragment();
        fragment.setArguments(args);

        return fragment;
    }
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.activity_home__fragment,container,false);

        recyclerView = view.findViewById(R.id.rvList);
        contacts = new ArrayList<>();

        contact1 = new Contact("Mr A");
        contact2 = new Contact("Mr B");
        contact3 = new Contact("Mr C");
        contact4 = new Contact("Mr D");
        contact5 = new Contact("Mr E");
        contact6 = new Contact("Mr F");
        contact7 = new Contact("Mr G");
        contact8 = new Contact("Mr H");
        contact9 = new Contact("Mr I");

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);
        contacts.add(contact6);
        contacts.add(contact7);
        contacts.add(contact8);
        contacts.add(contact9);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        contactAdapter = new ContactAdapter(contacts);

        contactAdapter.setIonClickContact(new IconClick() {

            @Override
            public void onClickName(String name) {
                PopupMenu popupMenu = new PopupMenu(getContext(), view);
                popupMenu.getMenuInflater().inflate(R.menu.menu_contact,
                        popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.mnEdit:
                                break;
                            case R.id.mnSent:
                                break;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });

        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

}
