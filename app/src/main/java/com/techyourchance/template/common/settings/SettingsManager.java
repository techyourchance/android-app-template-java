package com.techyourchance.template.common.settings;

/**
 * This class encapsulates various settings/configurations/data which affect functionality of
 * the app.
 */
public class SettingsManager {

    private static final String KEY_IS_KIOSK = "KEY_IS_KIOSK";

    private final SettingsEntryFactory mSettingsEntryFactory;

    public SettingsManager(SettingsEntryFactory settingsEntryFactory) {
        mSettingsEntryFactory = settingsEntryFactory;
    }

    public SettingDataEntry<Boolean> isKioskEnabled() {
        return mSettingsEntryFactory.getDataEntry(Boolean.class, KEY_IS_KIOSK, false);
    }

}
