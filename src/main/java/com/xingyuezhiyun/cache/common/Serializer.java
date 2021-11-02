package com.xingyuezhiyun.cache.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public interface Serializer {

    default <T> T read(byte[] bytes, Class<T> clazz) {
        return read(new ByteArrayInputStream(bytes), clazz);
    }

    <T> T read(InputStream stream, Class<T> clazz);

    default byte[] write(Object o) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        write(out, o);
        return out.toByteArray();
    }

    void write(OutputStream stream, Object o);

}
