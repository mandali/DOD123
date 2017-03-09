package com.omniwyse.dod.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.omniwyse.dod.R;
import com.omniwyse.dod.model.BeaconPromotions;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by surya on 3/7/2017.
 * @author surya.g21@gmail.com
 */

public class BeaconLiveAdapter extends RecyclerView.Adapter<BeaconLiveAdapter.ItemHolder> {


    private List<BeaconPromotions> promotions;
    private Context mContext;

    public BeaconLiveAdapter(Context context, List<BeaconPromotions> promotions) {
        this.promotions = promotions;
        this.mContext = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discount_list_item, null);
        return new BeaconLiveAdapter.ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder itemHolder, int position) {
        final BeaconPromotions data= promotions.get(position);
        itemHolder.itemDiscount.setText(data.getDiscount());
        itemHolder.itemCategory.setText(data.getCategoryName());
        itemHolder.itemStore.setText(data.getBrandDescription());
        Picasso.with(mContext).load(data.getBrandImage()).resize(100, 100).into(itemHolder.brandImage);
    }

    @Override
    public int getItemCount() {
        return promotions!=null?promotions.size():0;
    }


    public class ItemHolder extends RecyclerView.ViewHolder {

        private TextView itemStore;
        private TextView itemCategory;
        private TextView itemDiscount;

        private ImageView brandImage;

        public ItemHolder(View view) {
            super(view);

            this.itemCategory = (TextView) view.findViewById(R.id.beacon_category_tv);
            this.itemStore = (TextView) view.findViewById(R.id.beacon_store_tv);
            this.itemDiscount = (TextView) view.findViewById(R.id.beacon_discount);
            this.brandImage = (ImageView) view.findViewById(R.id.beacon_list_image);


        }

    }

}