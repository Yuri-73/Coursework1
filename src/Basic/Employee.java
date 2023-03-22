package Basic;

import java.util.Objects;

public class Employee {
    private final String nick;
    private int department;
    private int salary;
    static int counter;
    public int id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(nick, employee.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick, department, salary);
    }
}
