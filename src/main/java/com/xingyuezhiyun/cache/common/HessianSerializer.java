package com.xingyuezhiyun.cache.common;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

/**
 * 暂时没有使用
 */
public class HessianSerializer implements Serializer {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T read(InputStream stream, Class<T> clazz) {
        Hessian2Input in = new Hessian2Input(stream);
        try {
            if (clazz == Optional.class) {
                in.readObject(OptionalMark.class);
                return (T) Optional.ofNullable(in.readObject());
            }
            return (T) in.readObject(clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(OutputStream stream, Object o) {
        Hessian2Output out = new Hessian2Output(stream);
        try {
            if (o instanceof Optional) {
                out.writeObject(OptionalMark.MARK);
                out.writeObject(((Optional<?>) o).orElse(null));
            } else {
                out.writeObject(o);
            }
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
