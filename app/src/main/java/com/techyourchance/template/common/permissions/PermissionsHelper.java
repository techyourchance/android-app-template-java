package com.techyourchance.template.common.permissions;

import android.app.Activity;
import android.content.pm.PackageManager;

import com.techyourchance.template.common.Observable;

import java.util.LinkedList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

@UiThread
public class PermissionsHelper extends Observable<PermissionsHelper.Listener> {

    public interface Listener {
        void onRequestPermissionsResult(int requestCode, PermissionsResult result);
        void onPermissionsRequestCancelled(int requestCode);
    }

    public static class PermissionsResult {
        public final List<MyPermission> granted;
        public final List<MyPermission> denied;
        public final List<MyPermission> deniedDoNotAskAgain;

        public PermissionsResult(List<MyPermission> granted, List<MyPermission> denied, List<MyPermission> deniedDoNotAskAgain) {
            this.granted = granted;
            this.denied = denied;
            this.deniedDoNotAskAgain = deniedDoNotAskAgain;
        }
    }

    private final Activity mActivity;

    public PermissionsHelper(Activity activity) {
        mActivity = activity;
    }

    public boolean hasPermission(MyPermission permission) {
        return ContextCompat.checkSelfPermission(mActivity, permission.getAndroidPermission()) == PackageManager.PERMISSION_GRANTED;
    }

    public boolean hasAllPermissions(MyPermission[] permissions) {
        for (MyPermission permission : permissions) {
            if (ContextCompat.checkSelfPermission(mActivity, permission.getAndroidPermission()) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public void requestPermission(MyPermission permission, int requestCode) {
        ActivityCompat.requestPermissions(mActivity, new String[] { permission.getAndroidPermission() }, requestCode);
    }

    public void requestAllPermissions(MyPermission[] permissions, int requestCode) {
        String[] androidPermissions = new String[permissions.length];
        for (int i = 0; i < permissions.length; i++) {
            androidPermissions[i] = permissions[i].getAndroidPermission();
        }
        ActivityCompat.requestPermissions(mActivity, androidPermissions, requestCode);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] androidPermissions, @NonNull int[] grantResults) {
        if (androidPermissions.length == 0 || grantResults.length == 0) {
            notifyPermissionsRequestCancelled(requestCode);
        }

        List<MyPermission> grantedPermissions = new LinkedList<>();
        List<MyPermission> deniedPermissions = new LinkedList<>();
        List<MyPermission> deniedAndDoNotAskAgainPermissions = new LinkedList<>();

        String androidPermission;
        MyPermission permission;

        for (int i = 0; i < androidPermissions.length; i++) {
            androidPermission = androidPermissions[i];
            permission = MyPermission.fromAndroidPermission(androidPermission);
            if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                grantedPermissions.add(permission);
            } else if (ActivityCompat.shouldShowRequestPermissionRationale(mActivity, androidPermission)) {
                deniedPermissions.add(permission);
            } else {
                deniedAndDoNotAskAgainPermissions.add(permission);
            }
        }

        PermissionsResult result = new PermissionsResult(grantedPermissions, deniedPermissions, deniedAndDoNotAskAgainPermissions);
        notifyPermissionsResult(requestCode, result);
    }

    private void notifyPermissionsResult(int requestCode, PermissionsResult permissionsResult) {
        for (Listener listener : getListeners()) {
            listener.onRequestPermissionsResult(requestCode, permissionsResult);
        }
    }

    private void notifyPermissionsRequestCancelled(int requestCode) {
        for (Listener listener : getListeners()) {
            listener.onPermissionsRequestCancelled(requestCode);
        }
    }


}
