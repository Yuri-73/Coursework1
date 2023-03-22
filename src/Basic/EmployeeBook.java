package Basic;

public class EmployeeBook {
    private Employee[] journal;
    public EmployeeBook() {
        this.journal = new Employee[12];
    }

    public Employee[] getJournal() {
        return this.journal;
    }

    public void setJournal(Employee[] journal) {
        this.journal = journal;
    }

    public void addNick(String nick, int department, int salary) {
        //Ввод нового сотрудника в журнал учёта:
        if (Employee.counter >= journal.length) {
            System.out.println("Нельзя добавить новые данные - закончилось место");
        }
        Employee newNick = new Employee(nick, department, salary);
        journal[Employee.counter++] = newNick;
    }
    public void printAllNick() {
        System.out.println("Распечатка данных сотрудников всех отделов:");
        for (int i = 1; i < Employee.counter; i++) {
            System.out.println(journal[i].toString());
        }
    }
    public void amountOfSalariesForMonth() {
        System.out.print("Распечатка суммы затрат на месячные зарплаты сотрудников и её среднее значение: ");
        int sum = 0;
        int averageSalary;
        for (int i = 1; i < journal.length; i++) {
            sum = sum + journal[i].getSalary();
        }
        averageSalary = sum / Employee.counter;
        System.out.println("общая сумма за месяц составляет " + sum + " рублей. Средняя зарплата составляет " + averageSalary + " рублей");
    }
    public void minimumWage() {
        System.out.print("Распечатка самой меньшей зарплаты из всех сотрудников: ");
        int min = Integer.MAX_VALUE;
        int x = 0;
        for (int i = 1; i < journal.length; i++) {
            if (min > journal[i].getSalary()) {
                min = journal[i].getSalary();
                x = i;
            }
        }
        System.out.println("сотрудник '" + journal[x].getNick() + "' имеет минимальную зарплату " + min + " рублей");
    }
    public void maximumWage() {
        System.out.print("Распечатка самой большой зарплаты из всех сотрудников: ");
        int max = Integer.MIN_VALUE;
        int x = 0;
        for (int i = 1; i < journal.length; i++) {
            if (max < journal[i].getSalary()) {
                max = journal[i].getSalary();
                x = i;
            }
        }
        System.out.println("сотрудник '" + journal[x].getNick() + "' имеет максимальную зарплату " + max + " рублей");
    }
    public void indexingAllSalary(int percent) {
        System.out.println("Индексация окладов всех сотрудников организации на " + percent + " процентов. ");
        for (int i = 1; i < journal.length; i++) {
            journal[i].setSalary(journal[i].getSalary() + (journal[i].getSalary() / 100) * percent);
        }
    }
    public void listDepartment(int department) {
        System.out.println("Распечатка списка сотрудников отдела: " + department);
        for (int i = 1; i < journal.length; i++) {
            if(journal[i].getDepartment() == department) //Поиск всех линейных массивов одного отдела
                System.out.println(journal[i].toString());
        }
    }
    public void maxSalaryDepartment(int department) {
        System.out.println("Найден максимальный оклад сотрудника отдела " + department + ":");
        int max = Integer.MIN_VALUE;
        int x = 0;
        for (int i = 1; i < journal.length; i++) {
            if (journal[i].getDepartment() == department)
                if (max < journal[i].getSalary()) {
                    max = journal[i].getSalary();
                    x = i;
                }
        }
        System.out.println("Сотрудник отдела " + journal[x].getDepartment() + " " + journal[x].getNick() + " имеет максимальную в отделе зарплату " + max + " рублей");
    }
    public void minSalaryDepartment(int department) {
        System.out.println("Найден минимальный оклад сотрудника отдела " + department + ":");
        int min = Integer.MAX_VALUE;
        int x = 0;
        for (int i = 1; i < journal.length; i++) {
            if (journal[i].getDepartment() == department)
                if (min > journal[i].getSalary()) {
                    min = journal[i].getSalary();
                    x = i;
                }
        }
        System.out.println("Сотрудник отдела " + journal[x].getDepartment() + " " + journal[x].getNick() + " имеет минимальную в отделе зарплату " + min + " рублей");
    }
    public void indexingSalaryDepartment(int department, int percent) {
        System.out.println("Индексация окладов сотрудников отдела " + department + " на " + percent + " процентов: ");
        for (int i = 1; i < journal.length; i++) {
            if (journal[i].getDepartment() == department) {
                journal[i].setSalary(journal[i].getSalary() + (journal[i].getSalary() / 100) * percent);
                System.out.println("Сотрудник " + journal[i].getNick() + " получил проиндексированный оклад " + journal[i].getSalary() + " рублей. Id: " + i);
            }
        }
    }
    public void sumSalaryDepartment(int department) {
        System.out.println("Сумма расходов на всех сотрудников отдела " + department + " в месяц: ");
        int sum = 0;
        for (int i = 1; i < journal.length; i++) {
            if (journal[i].getDepartment() == department) {
                sum = sum + journal[i].getSalary();
            }
        }
        System.out.println("Общая сумма окладов отдела " + department + " за месяц составляет " + sum + " рублей");
    }
    public void averageSalaryDepartment(int department) {
        System.out.println("Средняя величина окладов сотрудников отдела " + department + " в месяц: ");
        int sum = 0;
        int averageSalary = 0;
        int score = 0;
        for (int i = 1; i < journal.length; i++) {
            if (journal[i].getDepartment() == department) {
                sum = sum + journal[i].getSalary();
                score++;
                averageSalary = sum / score;
            }
        }
        System.out.println("Средний оклад в отделе " + department + " составляет " + averageSalary + " рублей");
    }
    public void findLessSalaryDepartment(int number, int department) {
        System.out.println("Поиск сотрудников отдела " + department + ", у которых оклад меньше заданной величины " + number + ":");
        int a = 0; // Переменная счёта для определения отсутствия сотрудников такой категории
        for (int i = 1; i < journal.length; i++) {
            if (journal[i].getDepartment() == department)
                if (journal[i].getSalary() < number) {
                    System.out.println(journal[i].toString());
                    a++;
                }
        }
        if (a == 0)
            System.out.println("Таких сотрудников нет");
    }
    public void findMoreSalaryDepartment(int number, int department) {
        System.out.println("Поиск сотрудников отдела " + department + ", у которых оклад больше заданной величины " + number + ":");
        int a = 0; // Переменная счёта для определения отсутствия сотрудников такой категории
        for (int i = 1; i < journal.length; i++) {
            if (journal[i].getDepartment() == department)
                if (journal[i].getSalary() > number) {
                    System.out.println(journal[i].toString());
                    a++;
                }
        }
        if (a == 0)
            System.out.println("Таких сотрудников нет");
    }
    public void addNewNick(String nick, int department, int salary) { //Ввод нового сотрудника в журнал учёта, если имеется вакансия:
        System.out.println("Ввод нового сотрудника в отдел " + department);
        int a = 0;
        for (int i = 1; i < journal.length; i++) {
            if (journal[i].getDepartment() == 0) {
                Employee newNick = new Employee(nick, department, salary); //Создание объекта подскока, чтобы на него сослаться нашему массиву, иначе не изменить приватное nick
                newNick.id = i; //Надо принудительно оставить тот же Id, потому что он может поменяться из-за статической переменной счётчика counter
                journal[i] = newNick;
                System.out.println("Заполнение вакансии по Id-" + i + " в отдел " + department + " произведено. Обновлённый список сотрудников: ");
                a++;
                break; //Пройдет лишь одна вакансия
            }
        }
        if (a == 0)
            System.out.println("Попытка ввода нового сотрудника неудачная. Вакансий нет");
    }
    public void removeNick(String nick, int department, int salary) { //
        System.out.println("Удаление сотрудника с распечаткой после удаления: ");
        int i;
        for (i = 1; i < journal.length; i++) {
            if (journal[i].getNick().equals(nick)) {
                Employee newContact = new Employee("'образована вакансия'", department, salary);
                System.out.println(journal[i].getNick() + " удален.");
                journal[i] = newContact;
                journal[i].id = i;
                System.out.println(journal[i].toString());
            }
        }
    }
    public void modeNick(String nick, int department, int salary) { //
        System.out.println("Изменение данных на другого сотрудника под тем же Id: ");
        int i;
        for (i = 1; i < journal.length; i++) {
            if (journal[i].getNick().equals(nick)) {
                Employee newContact = new Employee("Копылов Сергей Иванович", 3, 70000);
                journal[i] = newContact;
                journal[i].id = i;
                System.out.println(journal[i].toString());
            }
        }
    }
}


