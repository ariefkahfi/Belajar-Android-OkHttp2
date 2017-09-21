package com.kahfi.arief.belajarokhttp2denganbroadcastreceiver.prerequestokhttp.base;

import java.io.IOException;
import java.util.List;

/**
 * Created by arief on 20/09/17.
 */

public interface BaseCrud<T,ID> {
    String save(T t) throws IOException;
    List<T> getAll() throws IOException;
    String delete(ID id) throws IOException;

}
