package com.domain.appname.common.settings;

/**
 * This class encapsulates various settings/configurations/data which affect functionality of
 * the app.
 */
public class SettingsManager {

    private static final String KEY_EXAMPLE_SETTING = "KEY_EXAMPLE_SETTING";

    private final SettingsEntryFactory mSettingsEntryFactory;

    public SettingsManager(SettingsEntryFactory settingsEntryFactory) {
        mSettingsEntryFactory = settingsEntryFactory;
    }

    public SettingDataEntry<String> getExampleSetting() {
        return mSettingsEntryFactory.getDataEntry(String.class, KEY_EXAMPLE_SETTING, "default");
    }

}
