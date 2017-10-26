package com.cszjo.design.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hansiming on 2017/10/26.
 */
public class WindowContainer extends Commpont {

    private List<Commpont> commponts = new ArrayList<>();

    @Override
    public void remove(Commpont commpont) {
        commponts.remove(commpont);
    }

    @Override
    public void add(Commpont commpont) {
        commponts.add(commpont);
    }

    @Override
    public void operation() {
        for (Commpont c : commponts) {
            c.operation();
        }
    }
}
