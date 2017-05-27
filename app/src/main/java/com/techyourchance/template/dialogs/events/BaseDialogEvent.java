package com.techyourchance.template.dialogs.events;

/**
 * Base class for all dialogs related events
 */
/* package */ abstract class BaseDialogEvent {
    private String mId;

    public BaseDialogEvent(String id) {
        mId = id;
    }

    public String getDialogId() {
        return mId;
    }
}
