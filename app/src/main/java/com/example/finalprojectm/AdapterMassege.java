package com.example.finalprojectm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterMassege extends RecyclerView.Adapter<AdapterMassege.ViewHolder>{
    public static final int MSG_LEFT=1;
    public static final int MSG_RIGHT=0;
    Context context;
    List<Massege> masseges;
    FirebaseUser firebaseUser;

    public AdapterMassege(Context context, List<Massege> masseges) {
        this.context=context;
        this.masseges=masseges;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterMassege.ViewHolder viewHolder;
        if (viewType == MSG_RIGHT){
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_right, parent, false);
             viewHolder = new ViewHolder(view);

            return viewHolder;
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.chat_item_left, parent, false);
             viewHolder = new ViewHolder(view);

            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Massege massege=masseges.get(position);

        holder.msg_text.setText(massege.getMessage());
    }

    @Override
    public int getItemCount() {
        return masseges.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView msg_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            msg_text = itemView.findViewById(R.id.textView_msg_display);
        }
    }
    @Override
    public int getItemViewType(int position) {
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        if (masseges.get(position).getSender().equals(firebaseUser.getUid())){
            return MSG_LEFT;
        }else{
            return MSG_RIGHT;
        }


    }
}
