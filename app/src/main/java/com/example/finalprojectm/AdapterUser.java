package com.example.finalprojectm;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.ViewHolder> {
    private Context context;
    private List<User> userList;
    private List<User> origenlusers;
    public AdapterUser(Context context,List<User> users){
        this.context=context;
        this.userList=users;
        this.origenlusers=new ArrayList<>();
        origenlusers.addAll(userList);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.user_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final User user=userList.get(position);
        holder.textView_username.setText(user.getFullName());
        holder.itemView.setOnClickListener(v -> {
            Intent intent=new Intent(context, MassegeActivity.class);
            intent.putExtra("userid",user.getId());
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
    public void Filter(final String strSearch){
     //   throw new RuntimeException("Test Crash"); // Force a crash
        if (strSearch.length() == 0){
            userList.clear();
            userList.addAll(origenlusers);
            throw new RuntimeException("Test Crash"); // Force a crash
        }else {
             userList.clear();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
             List<User> collect=   origenlusers.stream()
                        .filter(i->i.getFullName().toLowerCase().contains(strSearch))
                        .collect(Collectors.toList());
             userList.addAll(collect);
            }else {

                for (User i:origenlusers){
                    if (i.getFullName().toLowerCase().contains(strSearch)){
                        userList.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_username;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView_username=itemView.findViewById(R.id.text_Name_item);

        }
    }
}
