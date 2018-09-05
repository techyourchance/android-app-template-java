package com.techyourchance.template.common.usecases;

import com.techyourchance.template.common.BaseAsyncObservable;

public abstract class BaseAsyncUseCase<LISTENER_TYPE> extends BaseAsyncObservable<LISTENER_TYPE> {
    // currently no special functionality here, but if all use cases will extend this class
    // it will be clearer and provide an extension point which might be required in the future
}
