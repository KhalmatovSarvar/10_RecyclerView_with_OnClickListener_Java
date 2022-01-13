package com.example.a10_recyclerview_with_onclicklistener_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10_recyclerview_with_onclicklistener_java.MainActivity;
import com.example.a10_recyclerview_with_onclicklistener_java.R;
import com.example.a10_recyclerview_with_onclicklistener_java.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    MainActivity activity;
    List<Member> members;

    public CustomAdapter(MainActivity activity, List<Member> members) {
        this.activity = activity;
        this.members = members;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layout,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);

        if(holder instanceof CustomViewHolder){
            LinearLayout lay_click = ((CustomViewHolder)holder).lay_click;
            TextView first_name = ((CustomViewHolder)holder).first_name;
            TextView last_name = ((CustomViewHolder)holder).last_name;

            first_name.setText(member.getFirstName());
            last_name.setText(member.getLastName());

            lay_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    activity.openItemDetails(member);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView first_name, last_name;
        View view;
        private LinearLayout lay_click;
        public CustomViewHolder(View v) {
            super(v);
            view = v;

            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
            lay_click = view.findViewById(R.id.lay_click);
        }
    }
}
