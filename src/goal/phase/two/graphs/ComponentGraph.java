package goal.phase.two.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ComponentGraph {

    private List<Component> components;

    public ComponentGraph() {
        this.components = new ArrayList<Component>();
    }

    public List<Component> getComponents() {
        return this.components;
    }

    public void install(Component c) {
        this.components.add(c);
    }

    public void remove(Component comp) {
        // TODO
    }

    public void makeDependency(Component c1, Component c2) {
        for (Component c : components) {
            if (c.equals(c1)) {
                c.downstreamDependencyList.add(c2);
            } else if (c.equals(c2)) {
                c.upstreamDependencyList.add(c1);
            }
        }
    }
}

class Component {
    String id;
    List<Component> upstreamDependencyList;
    List<Component> downstreamDependencyList;

    public Component(String id) {
        this.id = id;
        this.upstreamDependencyList = new LinkedList<Component>();
        this.downstreamDependencyList = new LinkedList<Component>();
    }
}