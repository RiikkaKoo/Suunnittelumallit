public class Employee extends Component {

    protected int salary;

    public Employee(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void printData(String indent) {
        System.out.println(indent + "<employee>");
        System.out.println(indent + "   <name>" + super.name + "</name>");
        System.out.println(indent + "   <salary>" + this.salary + "</salary>");
        System.out.println(indent + "</employee>");
    }

    @Override
    public void printSalary() {
        System.out.println(this.salary);
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public Component getChild(int index) {
        throw new UnsupportedOperationException("Not supported in leaf.");
    }
}
