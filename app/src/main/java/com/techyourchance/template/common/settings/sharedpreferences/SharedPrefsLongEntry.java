package com.techyourchance.template.common.settings.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

/**
 * Implementation of {@link SharedPrefsDataEntry} for long
 */
@SuppressWarnings("unused")
/* pp */ class SharedPrefsLongEntry extends SharedPrefsDataEntry<Long> {

    /* pp */ SharedPrefsLongEntry(SharedPreferences preferences, String key, Long defaultValue) {
        super(preferences, key, defaultValue);
    }

    @Override
    public Long getValue() {
        return mPreferences.getLong(mKey, mDefaultValue == null ? 0 : mDefaultValue);
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public void setValue(Long value) {
        mPreferences.edit().putLong(mKey, value == null ? 0 : value).commit();
    }
}
