package com.sha.mycart;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sha.mycart.Model.Contact;

import java.util.List;

/**
 * Created by SHA on 28/7/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myholder> {
    List<Contact> dataModelArrayList;

    public RecycleAdapter(List<Contact> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }
    class Myholder extends RecyclerView.ViewHolder {
        TextView fname, lname;

        public Myholder(View itemView) {
            super(itemView);

            fname = (TextView) itemView.findViewById(R.id.fn);
            lname = (TextView) itemView.findViewById(R.id.ln);
        }
    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forthlistitem, null);
        return new Myholder(view);
    }
    @Override
    public void onBindViewHolder(Myholder holder, int position) {
        Contact dm=dataModelArrayList.get(position);
        holder.fname.setText(dm.get_fname());
        holder.lname.setText(dm.get_lname());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

}

