package com.sha.mycart;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sha.mycart.Model.dataclass;

import java.util.List;
import java.util.StringTokenizer;

import static android.R.id.list;

/**
 * Created by SHA on 24/7/2017.
 */

public class listadapter extends RecyclerView.Adapter<listadapter.ViewHolder> {
    private List<dataclass> items;
    private Context context;
    private int Mysavedpostion;


    public listadapter(List<dataclass> items, Context context) {
        this.items = items;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitem, parent, false);

        return new  ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final dataclass list=items.get(position);
        holder.setIsRecyclable(true);

        holder.catename.setText(list.getCategory());
        holder.itemname.setText(list.getDesc());
        final CartSession cartSession=new CartSession(context);
        holder.addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String value=Integer.toString(Integer.parseInt(holder.incre.getText().toString())+1);
                holder.incre.setText(value);
                list.setCounter(Integer.parseInt(value));
                items.set(position,list);
                cartSession.clearAllCartSession();
                cartSession.createCartSession(items);
                notifyDataSetChanged();
            }
        });
        holder.ed1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                cartSession.clearAllCartSession();
                list.setTotal(s.toString());
                items.set(position,list);
                cartSession.createCartSession(items);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView catename;
        private TextView itemname;
        private TextView incre;
        private ImageView addbtn,minusbtn;
        private EditText ed1;
        public  Button submit;

        public ViewHolder(View itemView) {
            super(itemView);
            catename=(TextView)itemView.findViewById(R.id.catename_textView);
            itemname=(TextView)itemView.findViewById(R.id.itemname_txt);
            addbtn=(ImageView)itemView.findViewById(R.id.plus_button);
            minusbtn=(ImageView) itemView.findViewById(R.id.minus_button);
            incre=(TextView) itemView.findViewById(R.id.counter_txt);
            ed1=(EditText)itemView.findViewById(R.id.edittext);
            submit=(Button)itemView.findViewById(R.id.button2);
        }
    }

}
