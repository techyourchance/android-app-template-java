package com.techyourchance.template.common.settings.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import com.techyourchance.template.common.settings.SettingDataEntry;

/**
 * Implementation of {@link SettingDataEntry} backed by {@link SharedPreferences}
 */
/* pp */ abstract class SharedPrefsDataEntry<T> extends SettingDataEntry<T> implements
        SharedPreferences.OnSharedPreferenceChangeListener {

    /* pp */ final SharedPreferences mPreferences;

    /* pp */ SharedPrefsDataEntry(SharedPreferences preferences, String key, T defaultValue) {
        super(key, defaultValue);
        this.mPreferences = preferences;
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public void remove() {
        mPreferences.edit().remove(mKey).commit();
    }


    @Override
    protected void onFirstListenerRegistered() {
        mPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onLastListenerUnregistered() {
        mPreferences.unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        notifyListeners(key, getValue());
    }

}
