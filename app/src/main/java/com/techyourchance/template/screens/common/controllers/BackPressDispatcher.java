package com.techyourchance.template.screens.common.controllers;

public interface BackPressDispatcher {
    void registerListener(BackPressListener listener);
    void unregisterListener(BackPressListener listener);
}
