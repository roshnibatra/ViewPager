package com.example.android.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutIndicator;

    private OnboardingAdapter onboardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        layoutIndicator = findViewById(R.id.layout_indicator);

        setOnboardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
        onboardingViewPager.setAdapter(onboardingAdapter);

        setOnboardIndicator();
        setCurrentIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });
    }


    private void setOnboardingItems() {

        List<OnboardingItems> onboardingItemsList = new ArrayList<>();
        onboardingItemsList.add(new OnboardingItems(R.drawable.panda,"Panda hun main","In some cases, to the user, " +
                "each of these view pager components would likely feel the same. A view is showed, " +
                "another one is swiped in view and so on. "));
        onboardingItemsList.add(new OnboardingItems(R.drawable.girls2,"Pari hun hun main","This means that just like how " +
                "we are already showing streams of content using a Recycler View, having our views recycled as we go now allows us to able to "
                ));
        onboardingItemsList.add(new OnboardingItems(R.drawable.animal,"Haathi Aya Hathi","This in my opinion is huge news " +
                "and will not only give our users a smoother experience"));

        onboardingAdapter = new OnboardingAdapter(onboardingItemsList);
    }

    private void setOnboardIndicator() {
        ImageView[] indicator= new ImageView[onboardingAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        layoutParams.setMargins(8,8,8,8);
        for (int i=0;i<indicator.length;i++) {
            indicator[i] = new ImageView(getApplicationContext());
            indicator[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot
            ));

            indicator[i].setLayoutParams(layoutParams);
            layoutIndicator.addView(indicator[i]);
        }
    }

    private void setCurrentIndicator(int index) {
        int childCount = layoutIndicator.getChildCount();
        for(int i=0;i<childCount;i++) {
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i== index) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
            }
            else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.non_active_dot));
            }
        }
    }
}
