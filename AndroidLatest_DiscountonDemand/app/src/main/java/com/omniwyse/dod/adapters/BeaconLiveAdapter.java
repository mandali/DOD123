package com.omniwyse.dod.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.omniwyse.dod.R;
import com.omniwyse.dod.model.BeaconPromotions;
import com.omniwyse.dod.model.Datum;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by surya on 3/7/2017.
 * @author surya
 */

public class BeaconLiveAdapter extends RecyclerView.Adapter<BeaconLiveAdapter.ItemRowHolder> {


    private List<BeaconPromotions> promotions;
    private Context mContext;

    public BeaconLiveAdapter(Context context, List<BeaconPromotions> promotions) {
        this.promotions = promotions;
        this.mContext = context;
    }


    @Override
    public BeaconLiveAdapter.ItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.discount_list_item, null);
        BeaconLiveAdapter.ItemRowHolder mh = new BeaconLiveAdapter.ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(BeaconLiveAdapter.ItemRowHolder itemRowHolder, int i) {

        Picasso.with(mContext).load(promotions.get(i).getBrandImage()).resize(100, 100).into(itemRowHolder.brandImage);
    }

    @Override
    public int getItemCount() {
        return (null != promotions ? promotions.size() : 0);
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        private TextView itemStore;
        private TextView itemCategory;
        private TextView itemDiscount;

        private ImageView brandImage;

        public ItemRowHolder(View view) {
            super(view);

            this.itemCategory = (TextView) view.findViewById(R.id.beacon_category_tv);
            this.itemStore = (TextView) view.findViewById(R.id.beacon_store_tv);
            this.itemDiscount = (TextView) view.findViewById(R.id.beacon_discount);
            this.brandImage = (ImageView) view.findViewById(R.id.beacon_list_image);


        }

    }

}