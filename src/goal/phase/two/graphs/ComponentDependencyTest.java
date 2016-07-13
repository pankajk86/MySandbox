package goal.phase.two.graphs;


public class ComponentDependencyTest {

    public static void main(String[] args) {
        Component a = new Component("a");
        Component b = new Component("b");
        Component c = new Component("c");
        Component d = new Component("d");
        Component e = new Component("e");
        Component f = new Component("f");

        ComponentGraph cg = new ComponentGraph();

        cg.install(a);
        cg.install(b);
        cg.install(c);
        cg.install(d);
        cg.install(e);
        cg.install(f);

        cg.makeDependency(a, b);
        cg.makeDependency(a, c);
        cg.makeDependency(b, d);
        cg.makeDependency(c, d);
        cg.makeDependency(c, e);
        cg.makeDependency(e, d);
        cg.makeDependency(d, f);

        cg.remove(d);
    }

}
