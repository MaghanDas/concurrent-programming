public class Manager extends Employee{

    Manager(float salary, String name) {
        super(salary, name);
    }

    @Override
    public float getSalary() {
        return 0;
    }
}
