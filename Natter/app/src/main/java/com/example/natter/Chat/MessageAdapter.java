package com.example.natter.Chat;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.natter.R;
import com.example.natter.UserObject;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    public ArrayList<MessageObject> messageList;

    public MessageAdapter(ArrayList<MessageObject> messageList){
        this.messageList = messageList;
    }


    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        MessageViewHolder rcv = new MessageViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull final MessageViewHolder holder, final int position) {
        holder.mMessage.setText(messageList.get(position).getMessage());
        holder.mSender.setText(messageList.get(position).getSenderId());
    }

    @Override
    public int getItemCount(){
        return  messageList == null ? 0 : messageList.size();
    }






    public class MessageViewHolder extends RecyclerView.ViewHolder{

        TextView mMessage,
                 mSender;
        public LinearLayout mLayout;
        public MessageViewHolder(View view){
            super(view);
            mLayout = view.findViewById(R.id.layout);
            mMessage = view.findViewById(R.id.message);
            mSender = view.findViewById(R.id.sender);
        }
    }
}