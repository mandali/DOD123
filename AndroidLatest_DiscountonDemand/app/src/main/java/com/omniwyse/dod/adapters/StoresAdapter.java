package com.omniwyse.dod.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.omniwyse.dod.R;
import com.omniwyse.dod.model.BeaconPromotions;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by surya on 3/8/2017.
 * @author surya.g21@gmail.com
 */

public class StoresAdapter extends BaseAdapter {

    private List<BeaconPromotions> promotionsList;
    private Context context;
    private LayoutInflater  inflater;
    public StoresAdapter(Context context,  List<BeaconPromotions> promotionsList){
        this.context = context;
        this.promotionsList = promotionsList;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return promotionsList.size();
    }

    @Override
    public Object getItem(int position) {
        return promotionsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 50;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.discount_list_item, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }
        mViewHolder.discount.setText(position+"%");
        final BeaconPromotions promotions= promotionsList.get(position);
        mViewHolder.category.setText(promotions.getCategoryName());
        mViewHolder.discount.setText(promotions.getDiscount());
        mViewHolder.mallInfo.setText(promotions.getDescription());
        Picasso.with(context).load(promotions.getBrandImage()).resize(100, 100).into(mViewHolder.ivIcon);

        return convertView;

    }

    private class MyViewHolder {
        TextView category,mallInfo, discount;
        ImageView ivIcon;

        public MyViewHolder(View item) {
            category = (TextView) item.findViewById(R.id.beacon_category_tv);
            discount = (TextView) item.findViewById(R.id.beacon_discount);
            mallInfo = (TextView) item.findViewById(R.id.beacon_store_tv);

            ivIcon = (ImageView)item.findViewById(R.id.beacon_list_image);
        }
    }
}