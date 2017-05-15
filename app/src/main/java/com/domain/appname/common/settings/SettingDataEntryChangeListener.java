package com.domain.appname.common.settings;


public interface SettingDataEntryChangeListener<T> {

    void onValueChanged(SettingDataEntry settingDataEntry, T value);

}
