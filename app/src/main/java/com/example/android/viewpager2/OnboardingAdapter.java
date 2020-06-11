package com.example.android.viewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {

   private List<OnboardingItems> mOnboardingItemsList;


    public OnboardingAdapter(List<OnboardingItems> onboardingItemsList) {
        mOnboardingItemsList = onboardingItemsList;

    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_container,parent,false);


        return new OnboardingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        OnboardingItems onboardingItems = mOnboardingItemsList.get(position);
        holder.imageOnboarding.setImageResource(onboardingItems.getImage());
        holder.textTitle.setText(onboardingItems.getTitle());
        holder.textDescription.setText(onboardingItems.getDescription());
    }

    @Override
    public int getItemCount() {
        return mOnboardingItemsList.size();
    }

    public class OnboardingViewHolder extends RecyclerView.ViewHolder {

        TextView textTitle, textDescription;
        ImageView imageOnboarding;

        public OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageOnboarding = itemView.findViewById(R.id.image_onboarding);
        }
    }
}
