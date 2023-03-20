package Basic;

public class Employee {
    private final String nick;
    private int department;
    private int salary;
    static int counter;
    static int id;

    public Employee(String nick, int department, int salary) {
        this.nick = nick;
        this.department = department;
        this.salary = salary;
        this.id = this.counter;
    }
    public String getNick() {
        return nick;
    }
    public int getDepartment() {
        return department;
    }
    public int getSalary() {
        return salary;
    }
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return  "id: " + id + ", сотрудник: " + nick + ", отдел: " + department + ", оклад: " + salary;
    }

}
