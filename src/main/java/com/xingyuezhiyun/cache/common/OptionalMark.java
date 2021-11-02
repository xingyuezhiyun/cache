package com.xingyuezhiyun.cache.common;

import java.io.Serializable;

public class OptionalMark implements Serializable {

    private static final long serialVersionUID = 1L;

    private OptionalMark() {
    }

    public static final OptionalMark MARK = new OptionalMark();
}
