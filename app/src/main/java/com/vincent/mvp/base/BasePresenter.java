package com.vincent.mvp.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * description ：
 * project name：MVP
 * author : Vincent
 * creation date: 2017/4/8 17:12
 *
 * @version 1.0
 */

public class BasePresenter {
    protected CompositeSubscription mCompositeSubscription;

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    //RXjava注册
    public void addSubscription(Subscription subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscriber);
    }
}
