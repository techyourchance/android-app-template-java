package com.domain.appname.common.settings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents a single application setting entry. The specifics about how exactly this
 * setting entry is implemented and persisted should be implemented by sub-classes.
 * @param <T> data type of this setting entry
 */
public abstract class SettingDataEntry<T> {

    private final Set<SettingDataEntryChangeListener<T>> mListeners = new HashSet<>();

    protected final String mKey;
    protected final T mDefaultValue;

    public SettingDataEntry(String key, T defaultValue) {
        mKey = key;
        mDefaultValue = defaultValue;
    }

    public abstract T getValue();
    public abstract void setValue(T value);
    public abstract void remove();

    public final void registerListener(SettingDataEntryChangeListener<T> listener){
        synchronized (mListeners) {
            boolean modified = mListeners.add(listener);
            if (modified && mListeners.size() == 1) {
                onFirstListenerRegistered();
            }
        }
    }

    public final void unregisterListener(SettingDataEntryChangeListener<T> listener){
        synchronized (mListeners) {
            boolean modified = mListeners.remove(listener);
            if (modified && mListeners.isEmpty()) {
                onLastListenerUnregistered();
            }
        }
    }

    /**
     * This "hook" method can be overridden if any actions need to be performed when first listener
     * being registered
     */
    protected void onFirstListenerRegistered() {}

    /**
     * This "hook" method can be overridden if any actions need to be performed when last listener
     * being unregistered
     */
    protected void onLastListenerUnregistered() {}

    protected void notifyListeners(String key, T value){
        final List<SettingDataEntryChangeListener<T>> listenersCopy;
        synchronized (mListeners) {
            listenersCopy = new ArrayList<>(mListeners);
        }

        for (SettingDataEntryChangeListener<T> listener : listenersCopy){
            listener.onValueChanged(this, value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SettingDataEntry<?> that = (SettingDataEntry<?>) o;

        return mKey.equals(that.mKey);

    }

    @Override
    public int hashCode() {
        return mKey.hashCode();
    }
}
