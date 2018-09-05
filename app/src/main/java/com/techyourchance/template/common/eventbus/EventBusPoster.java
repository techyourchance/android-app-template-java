package com.techyourchance.template.common.eventbus;

import org.greenrobot.eventbus.EventBus;

public class EventBusPoster {

    private final EventBus mEventBus;

    public EventBusPoster(EventBus eventBus) {
        mEventBus = eventBus;
    }

    public void post(Object event) {
        mEventBus.post(event);
    }

    public void postSticky(Object event) {
        mEventBus.postSticky(event);
    }
}
