package org.simulation.pathfinding;

import java.util.ArrayList;
import java.util.List;

public class ListForPathFinding<T extends PathNode> extends ArrayList<T> {
    public ListForPathFinding() {
        super();
    }

    public ListForPathFinding(List<T> list) {
        super(list);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (T node : this) {
            hash = 31 * hash + node.hashCode();
        }
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListForPathFinding<?> other = (ListForPathFinding<?>) o;
        if (this.size() != other.size()) return false;
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }
}
