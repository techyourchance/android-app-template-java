package com.techyourchance.template.common.permissions;

import android.Manifest;

public enum MyPermission {
    READ_PHONE_STATE(Manifest.permission.READ_PHONE_STATE),
    CAMERA(Manifest.permission.CAMERA);

    public static MyPermission fromAndroidPermission(String androidPermission) {
        for (MyPermission permission : MyPermission.values()) {
            if (permission.getAndroidPermission().equals(androidPermission)) {
                return permission;
            }
        }
        throw new RuntimeException("Android permission not supported yet: " + androidPermission);
    }

    private final String mAndroidPermission;

    MyPermission(String androidPermission) {
        mAndroidPermission = androidPermission;
    }

    public String getAndroidPermission() {
        return mAndroidPermission;
    }
}
