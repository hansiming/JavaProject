package com.cszjo.obj;

import java.util.ArrayList;
import java.util.List;

public class FormatTree {

    private void formatData(TargetTree parent, Group group) {
        List<DataSet> childrenDatasets = group.childrenDatasets;
        for (DataSet dataSet : childrenDatasets) {
            TargetTree targetTree = new TargetTree();
            targetTree.title = dataSet.name;
            parent.children.add(targetTree);
        }

        if (group.childrenGroups.size() == 0) {
            return;
        }

        for (Group curGroup : group.childrenGroups) {
            TargetTree targetTree = new TargetTree();
            targetTree.title = curGroup.name;
            parent.children.add(targetTree);
            formatData(targetTree, curGroup);
        }
    }

    /**
     * output
     */
    private static class TargetTree {
        List<TargetTree> children;
        String title;
    }

    /**
     * input
     */
    private static class Group {
        String name;
        List<Group> childrenGroups = new ArrayList<>();
        List<DataSet> childrenDatasets = new ArrayList<>();
    }

    private static class DataSet {
        String name;
    }
}
