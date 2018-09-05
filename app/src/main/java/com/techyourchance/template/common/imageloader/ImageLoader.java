package com.techyourchance.template.common.imageloader;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * This interface should be implemented by a wrapper around some third-party image loading library
 */
public interface ImageLoader {

    void loadImage(String uri, ImageView target);

    void loadImage(String uri, ImageView target, @DrawableRes int inProgressDrawableId, @DrawableRes int errorDrawableId);

    void loadImageCenterCrop(String uri, ImageView target, @DrawableRes int inProgressDrawableId, @DrawableRes int errorDrawableId);

    void loadImageCircular(String uri, ImageView target, @DrawableRes int inProgressDrawableId, @DrawableRes int errorDrawableId);

}
