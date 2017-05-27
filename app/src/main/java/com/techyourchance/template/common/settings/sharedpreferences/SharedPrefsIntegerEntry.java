package com.techyourchance.template.common.settings.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;


/**
 * Implementation of {@link SharedPrefsDataEntry} for integer
 */
@SuppressWarnings("unused")
/* pp */ class SharedPrefsIntegerEntry extends SharedPrefsDataEntry<Integer> {

    /* pp */ SharedPrefsIntegerEntry(SharedPreferences preferences, String key, Integer defaultValue) {
        super(preferences, key, defaultValue);
    }

    @Override
    public Integer getValue() {
        return mPreferences.getInt(mKey, mDefaultValue == null ? 0 : mDefaultValue);
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public void setValue(Integer value) {
        mPreferences.edit().putInt(mKey, value == null ? 0 : value).commit();
    }
}
