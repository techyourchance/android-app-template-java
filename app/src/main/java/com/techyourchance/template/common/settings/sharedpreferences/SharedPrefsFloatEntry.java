package com.techyourchance.template.common.settings.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;


/**
 * Implementation of {@link SharedPrefsDataEntry} for float
 */
@SuppressWarnings("unused")
/* pp */ class SharedPrefsFloatEntry extends SharedPrefsDataEntry<Float> {

    /* pp */ SharedPrefsFloatEntry(SharedPreferences preferences, String key, Float defaultValue) {
        super(preferences, key, defaultValue);
    }

    @Override
    public Float getValue() {
        return mPreferences.getFloat(mKey, mDefaultValue == null ? 0f : mDefaultValue);
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public void setValue(Float value) {
        mPreferences.edit().putFloat(mKey, value == null ? 0 : value).commit();
    }
}
