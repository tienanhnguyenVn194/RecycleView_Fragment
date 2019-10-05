package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MessFragment extends Fragment {

    Contact2 contact1,contact2,contact3;
    RecyclerView recyclerView;
    List<Contact2> contacts;
    ContactAdapter2 contactAdapter2;

    public static Fragment newInstance2(Contact2 contact) {
        Bundle args = new Bundle();
        args.putSerializable("contactPut", contact);
        MessFragment fragment = new MessFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_mess_fragment,container,false);

        recyclerView = view.findViewById(R.id.rvList2);
        contacts = new ArrayList<>();

        contact1 = new Contact2("Mr A:","Hello, how are you?");
        contact2 = new Contact2("Mr B:","Can youm give me some money");
        contact3 = new Contact2("Mr C:","Yes I am");

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.VERTICAL, false);
        contactAdapter2 = new ContactAdapter2(contacts);
        recyclerView.setAdapter(contactAdapter2);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
