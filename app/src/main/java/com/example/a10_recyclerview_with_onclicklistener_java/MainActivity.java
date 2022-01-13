package com.example.a10_recyclerview_with_onclicklistener_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.a10_recyclerview_with_onclicklistener_java.adapter.CustomAdapter;
import com.example.a10_recyclerview_with_onclicklistener_java.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }
    private void initViews() {
            context = this;
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));

    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(MainActivity.this,members);
        recyclerView.setAdapter(adapter);
    }


    private List<Member> prepareMemberList() {

        List<Member> members= new ArrayList<>();
        for(int i = 0; i<10; i++){
            members.add(new Member("Sarvarbek"+i,"Khalmatov"+i));
        }
        return members;
    }


    public void openItemDetails(Member member){
        Toast.makeText(MainActivity.this,member.getFirstName()+" is clicked",Toast.LENGTH_SHORT).show();
        Log.d("@@@",member.getFirstName()+"is clicked");
    }
}