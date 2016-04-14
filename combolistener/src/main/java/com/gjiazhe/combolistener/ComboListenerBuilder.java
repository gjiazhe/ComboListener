package com.gjiazhe.combolistener;

import android.view.View;

/**
 * Created by gjz on 4/12/16.
 */
public class ComboListenerBuilder {
    private static final int DEFAULT_MAX_INTERVAL = 300;

    private int mMaxInterval;
    private View mView;
    private OnComboListener mOnComboListener;
    private int mComboCount = 0;
    private long lastClickTime = 0;

    public ComboListenerBuilder() {
        mMaxInterval = DEFAULT_MAX_INTERVAL;
    }

    //set the Max Interval between two clicks, default is 300ms
    public ComboListenerBuilder setMaxInterval(int maxInterval) {
        mMaxInterval = maxInterval;
        return this;
    }

    //set the view to be observed
    public ComboListenerBuilder observeOn(View view) {
        mView = view;
        return this;
    }

    public void startListen() {
        if (mOnComboListener != null) {
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    long thisClickTime = System.currentTimeMillis();
                    if (thisClickTime - lastClickTime <= mMaxInterval) {
                        mComboCount++;
                    } else {
                        mComboCount = 0;
                    }
                    lastClickTime = thisClickTime;
                    mOnComboListener.onCombo(v, mComboCount);
                }
            });
        }
    }

    public ComboListenerBuilder setOnComboListener(OnComboListener onComboListener) {
        mOnComboListener = onComboListener;
        return this;
    }

    public interface OnComboListener {
        void onCombo(View view, int comboCount);
    }
}
