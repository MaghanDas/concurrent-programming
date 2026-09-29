public class Subordinate extends Employee{

    Subordinate(float salary, String name) {
        super(salary, name);
    }

    @Override
    public float getSalary() {
        return  this.getSalary();
    }
}
