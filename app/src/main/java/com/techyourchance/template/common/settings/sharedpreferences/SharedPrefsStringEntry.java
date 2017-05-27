package com.techyourchance.template.common.settings.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;


/**
 * Implementation of {@link SharedPrefsDataEntry} for string
 */
@SuppressWarnings("unused")
/* pp */ class SharedPrefsStringEntry extends SharedPrefsDataEntry<String> {

    /* pp */ SharedPrefsStringEntry(SharedPreferences preferences, String key, String defaultValue) {
        super(preferences, key, defaultValue);
    }

    @Override
    public String getValue() {
        return mPreferences.getString(mKey, mDefaultValue);
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public void setValue(String value) {
        mPreferences.edit().putString(mKey, value).commit();
    }
}
