package com.sha.mycart;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sha.mycart.Model.datamodel;

import java.util.List;

/**
 * Created by SHA on 28/7/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    List<datamodel> dataModelArrayList;

    public RecycleAdapter(List<datamodel> dataModelArrayList) {
        this.dataModelArrayList = dataModelArrayList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        datamodel dm=dataModelArrayList.get(position);
        holder.first.setText(dm.getFName());
        holder.last.setText(dm.getLName());

    }

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView first,last;

        public ViewHolder(View itemView) {
            super(itemView);

            first = (TextView) itemView.findViewById(R.id.fn);
            last = (TextView) itemView.findViewById(R.id.ln);



        }
    }
}

