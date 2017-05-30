package com.techyourchance.template.dialogs.info;

import com.techyourchance.template.dialogs.common.BaseDialogEvent;

/**
 * This event will be posted to EventBus when InfoDialog is dismissed
 */
public class InfoDialogDismissedEvent extends BaseDialogEvent {

    public InfoDialogDismissedEvent(String id) {
        super(id);
    }
}
