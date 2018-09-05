package com.techyourchance.template.common.eventbus;

import org.greenrobot.eventbus.EventBus;

public class EventBusSubscriber {

    private final EventBus mEventBus;

    public EventBusSubscriber(EventBus eventBus) {
        mEventBus = eventBus;
    }

    public void register(Object listener) {
        mEventBus.register(listener);
    }

    public void unregister(Object listener) {
        mEventBus.unregister(listener);
    }

}
