package com.domain.appname.common.settings;

/**
 * Sub classes of this abstract class can be used in order to instantiate different implementations
 * of {@link SettingDataEntry} objects.
 */
public abstract class SettingsEntryFactory {

     public abstract <T>SettingDataEntry<T> getDataEntry(final Class<T> clazz, final String key, final T defaultValue);

     public  <T>SettingDataEntry<T> getDataEntry(final Class<T> clazz, final String key) {
          return getDataEntry(clazz, key, null);
     }
}
