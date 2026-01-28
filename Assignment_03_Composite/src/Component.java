public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public void printData(String indent) {
        System.out.println(this.name);
    }

    public abstract void printSalary();
    public abstract void add(Component component);
    public abstract void remove(Component component);
    public abstract double getSalary();
    public abstract Component getChild(int index);
}
