package com.limprove.actorschatsample.presentation.actor;

import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.limprove.actorschatsample.R;

public class ActorBindingAdapters {

    @BindingAdapter("setScreenPosition")
    public static void setScreenPosition(TextView textView, int createdBy) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) textView.getLayoutParams();
        if (createdBy == 1) {
            params.gravity = Gravity.END;
            textView.setLayoutParams(params);
            textView.setBackground(textView.getContext().getDrawable(R.drawable.rounded_rectangle_second));
            textView.setTextColor(Color.WHITE);
        } else {
            params.gravity = Gravity.START;
            textView.setLayoutParams(params);
            textView.setBackground(textView.getContext().getDrawable(R.drawable.rounded_rectangle_first));
            textView.setTextColor(Color.BLACK);
        }
    }
}
