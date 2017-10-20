package com.cszjo.design.patterns.proto;

import java.io.Serializable;

/**
 * Created by hansiming on 2017/10/20.
 */
public interface Clone<T> extends Cloneable, Serializable {

    T clone();
}
