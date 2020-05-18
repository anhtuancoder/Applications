package com.example.covid_19api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.UserItemViewHolder> {
    private List<Country> countries;
    private Context context;

    public CountryAdapter(List<Country> countries, Context c) {
        this.countries = countries;
        this.context = c;
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    @Override
    public UserItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.country_items, parent, false);

        return new UserItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserItemViewHolder holder, int position) {
        Country country = countries.get(position);

        /*Picasso.with(context)
                .load(u.avatar_url)
                .into(holder.ivAvatar);*/ //load hình ảnh các quốc gia

        holder.country.setText("Quốc gia: " + country.country);
        holder.cases.setText("Tổng ca nhiễm: " + country.cases);
        holder.todayCases.setText("Ca nhiễm hôm nay: " + country.todayCases);
        holder.active.setText("Số ca nhiễm hiện còn: " + country.active);
        holder.deaths.setText("Tử vong: " + country.deaths);
        holder.todayDeaths.setText("Tử vong hôm nay: " + country.todayDeaths);
        holder.recovered.setText("Bình phục: " + country.recovered);
        holder.critical.setText("Nguy kịch: " + country.critical);
    }

    public static class UserItemViewHolder extends RecyclerView.ViewHolder {
        public TextView country;
        public TextView cases;
        public TextView todayCases;
        public TextView deaths;
        public TextView todayDeaths;
        public TextView recovered;
        public TextView active;
        public TextView critical;
        public UserItemViewHolder(View itemView) {
            super(itemView);
            country = (TextView) itemView.findViewById(R.id.txtCountryName);
            cases = (TextView) itemView.findViewById(R.id.txtCase);
            todayCases = (TextView) itemView.findViewById(R.id.txtTodayCase);
            active = (TextView) itemView.findViewById(R.id.txtActive);
            deaths = (TextView) itemView.findViewById(R.id.txtDeaths);
            todayDeaths = (TextView) itemView.findViewById(R.id.txtTodayDeaths);
            recovered = (TextView) itemView.findViewById(R.id.txtRecovered);
            critical = (TextView) itemView.findViewById(R.id.txtCritical);
        }
    }
}
