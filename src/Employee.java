
abstract class Employee {
    private float salary;
    private String name;

    Employee(float salary, String name){
        this.name = name;
        this.salary = salary;
    }

    public abstract float getSalary();

    public String getName() {
        return name;
    }

    public float raiseSalary(float percentage) {
        return this.getSalary() * (1 + (percentage / 100));


        // we can use following if percentage is sent in decimal like 0.20 for 20%
        // return this.getSalary() * (1 + percentage);

    }
}


