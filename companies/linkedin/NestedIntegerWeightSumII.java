package linkedin;

import java.util.ArrayList;
import java.util.List;

import static linkedin.NestedIntegerWeightSum.createNestedList;

public class NestedIntegerWeightSumII {

    public static void main(String[] args) {
        List<NestedInteger> nestedList = createNestedList();
        int result = depthSumInverse(nestedList);
        System.out.println(result);
    }

    private static int depthSumInverse(List<NestedInteger> nestedList) {
        int result = 0, maxDepth = Integer.MAX_VALUE, minDepth = maxDepth;
        List<Entity> list = flatten(nestedList, maxDepth);

        for (Entity e : list) minDepth = Math.min(minDepth, e.depth);
        for (Entity e : list) result += e.value * (e.depth - minDepth + 1);

        return result;
    }

    private static List<Entity> flatten(List<NestedInteger> nl, int depth) {
        List<Entity> result = new ArrayList<>();

        for (NestedInteger ni : nl) {
            if (ni.isInteger()) result.add(new Entity(ni.getInteger(), depth));
            else {
                List<Entity> innerList = flatten(ni.getList(), depth + 1);
                result.addAll(innerList);
            }
        }
        return result;
    }
}

class Entity {
    int value, depth;

    public Entity(int value, int depth) {
        this.value = value; this.depth = depth;
    }
}
