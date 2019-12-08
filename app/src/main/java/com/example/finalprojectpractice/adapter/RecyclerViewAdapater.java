package com.example.finalprojectpractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectpractice.Model.Users;
import com.example.finalprojectpractice.R;

import java.util.List;

public class RecyclerViewAdapater extends RecyclerView.Adapter<RecyclerViewAdapater.ViewHolder> {
    private Context context;
    private List<Users> userList;

    public RecyclerViewAdapater(Context context,List<Users>userList) {
        this.context = context;
        this.userList=userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users user =userList.get(position);
        holder.id.setText("ID : " + user.getFname() );
        holder.userId.setText("UserId : " + user.getAge() );
        holder.title.setText("Title : " + user.getEmail());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView userId;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            userId=itemView.findViewById(R.id.userid);
            title=itemView.findViewById(R.id.title);
        }
    }
}
