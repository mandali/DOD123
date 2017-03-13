package com.omniwyse.dod.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.omniwyse.dod.R;
import com.omniwyse.dod.databinding.DiscountListItemBinding;
import com.omniwyse.dod.model.BeaconPromotions;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by surya on 3/8/2017.
 * @author surya.g21@gmail.com
 */

public class StoresAdapter extends RecyclerView.Adapter<StoresAdapter.ItemHolder> {

    private List<BeaconPromotions> promotions;
    private Context mContext;
    // Allows to remember the last item shown on screen
    private int lastPosition = -1;

    public StoresAdapter(Context context, List<BeaconPromotions> promotions) {
        this.promotions = promotions;
        this.mContext = context;
    }

    @Override
    public StoresAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.discount_list_item, null);
        DiscountListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.discount_list_item, parent, false);
        return new StoresAdapter.ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(BeaconLiveAdapter.ItemHolder itemHolder, int position) {
        final BeaconPromotions data= promotions.get(position);


//        itemHolder.itemDiscount.setText(data.getDiscount());
//        itemHolder.itemCategory.setText(data.getCategoryName());
//        itemHolder.itemStore.setText(data.getBrandDescription());
//        Picasso.with(mContext).load(data.getBrandImage()).resize(100, 100).into(itemHolder.brandImage);

//        setAnimation(itemHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return promotions!=null?promotions.size():0;
    }


    public class ItemHolder extends RecyclerView.ViewHolder {

        private final DiscountListItemBinding binding;
//        private TextView itemStore;
//        private TextView itemCategory;
//        private TextView itemDiscount;

        private ImageView brandImage;

        public ItemHolder(View view) {
            super(view);

//            this.itemCategory = (TextView) view.findViewById(R.id.beacon_category_tv);
//            this.itemStore = (TextView) view.findViewById(R.id.beacon_store_tv);
//            this.itemDiscount = (TextView) view.findViewById(R.id.beacon_discount);
            this.brandImage = (ImageView) view.findViewById(R.id.beacon_list_image);


            this.binding = DataBindingUtil.bind(view);
        }

    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}