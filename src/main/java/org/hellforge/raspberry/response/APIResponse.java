package org.hellforge.raspberry.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Anton Afanasyeu on 16.03.16.
 */
public final class APIResponse<T extends Serializable> {

    private final Collection<T> data = new ArrayList<>();

    public Collection<T> getData() {
        return data;
    }

    public void addElements(Collection<T> elements) {
        if (elements != null) {
            this.data.addAll(elements);
        }
    }

    public void addElement(T element) {
        if (element != null) {
            this.data.add(element);
        }
    }

}
