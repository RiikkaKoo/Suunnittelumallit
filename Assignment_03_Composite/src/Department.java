import java.util.ArrayList;
import java.util.List;

public class Department extends Component {
    private List<Component> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    public double getSalary() {
        double totalSalary = 0;
        for (Component child : this.children) {
            totalSalary += child.getSalary();

            }
        return totalSalary;
    }

    @Override
    public void printData(String indent) {
        System.out.println(indent + "<department>");
        System.out.println(indent + "   <name>" + super.name + "</name>");
        for (Component child : this.children) {
            child.printData(indent + "   ");
        }
        System.out.println(indent + "</department>");
    }

    @Override
    public void printSalary() {
        double totalSalary = 0;
        for (Component child : this.children) {
            totalSalary += child.getSalary();

        }
        System.out.print(super.name + " - Total salary: " + totalSalary);
    }

    @Override
    public void add(Component component) {
        this.children.add(component);
    }

    @Override
    public void remove(Component component) {
        this.children.remove(component);
    }

    @Override
    public Component getChild(int index) {
        return this.children.get(index);

    }



}
