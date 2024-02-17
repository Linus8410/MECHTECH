package com.example.mechtech.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mechtech.R;
import com.example.mechtech.model.Offermodel;

import java.util.ArrayList;
import java.util.List;

public class Offeradapter extends RecyclerView.Adapter<Offeradapter.viewHolder> {
    private Context ctx;
    private List<Offermodel>OffermodelList=new ArrayList<>();
    public Offeradapter(Context ctx,List<Offermodel> offermodelList){
        this.ctx=ctx;
        this.OffermodelList=offermodelList;
    }

    @NonNull
    @Override
    public Offeradapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(ctx).inflate(R.layout.itemoffers,parent,false);
        return new Offeradapter.viewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Offeradapter.viewHolder holder, int position) {
        final Offermodel offermodel=offermodelList.get(position);
        holder.offerprice.setText(offermodel.getOfferconstraint());
        holder.offerconstraint.setText(offermodel.getOfferconstraint());
        Glide.with(ctx).load(offermodel.getOfferImage().into(holder.offerImage));

    }
0
    @Override
    public int getItemCount() {
        return OffermodelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView offerImage;
        private TextView offerprice,offerconstraint;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            offerImage=itemView.findViewById(R.id.headlight);
            offerprice=itemView.findViewById(R.id.txtprice);
            offerconstraint=itemView.findViewById(R.id.offerconstraint);

        }
    }
}
