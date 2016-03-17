package org.hellforge.raspberry.response;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Anton Afanasyeu on 16.03.16.
 */
public final class APIResponseBuilder {

    private APIResponseBuilder() {

    }

    public static <T extends Serializable> APIResponse<T> build(Collection<T> elements) {
        final APIResponse<T> apiResponse = new APIResponse<>();
        apiResponse.addElements(elements);
        return apiResponse;
    }

    public static <T extends Serializable> APIResponse<T> build(T element) {
        final APIResponse<T> apiResponse = new APIResponse<>();
        apiResponse.addElement(element);
        return apiResponse;
    }
}
