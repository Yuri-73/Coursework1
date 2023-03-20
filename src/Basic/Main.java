package Basic;

public class Main {
    public static Employee[] journal = new Employee[11];
    public static void addNick(String nick, int department, int salary) {
        //Ввод нового сотрудника в журнал учёта:
        if (Employee.counter >= journal.length) {
            System.out.println("Нельзя добавить новые данные - закончилось место");
        }
        Employee newNick = new Employee(nick, department, salary);
        journal[Employee.counter++] = newNick;
    }
    public static void printAllNick() {
        System.out.println("Распечатка данных сотрудников всех отделов:");
        for (int i = 1; i < Employee.counter; i++) {
            System.out.println(journal[i].toString());
        }
    }
    public static void amountOfSalariesForMonth() {
        System.out.print("Распечатка суммы затрат на месячные зарплаты сотрудников и её среднее значение: ");
        int sum = 0;
        int averageSalary;
        for (int i = 1; i < Employee.counter; i++) {
            sum = sum + journal[i].getSalary();
        }
        averageSalary = sum / Employee.counter;
        System.out.println("общая сумма за месяц составляет " + sum + " рублей. Средняя зарплата составляет " + averageSalary + " рублей");
    }
    public static void minimumWage() {
        System.out.print("Распечатка самой меньшей зарплаты из всех сотрудников: ");
        int min = Integer.MAX_VALUE;
        int x = 0;
        for (int i = 1; i < Employee.counter; i++) {
            if (min > journal[i].getSalary()) {
                min = journal[i].getSalary();
                x = i;
            }
        }
        System.out.println("сотрудник '" + journal[x].getNick() + "' имеет минимальную зарплату " + min + " рублей");
    }
    public static void maximumWage() {
        System.out.print("Распечатка самой большой зарплаты из всех сотрудников: ");
        int max = Integer.MIN_VALUE;
        int x = 0;
        for (int i = 1; i < Employee.counter; i++) {
            if (max < journal[i].getSalary()) {
                max = journal[i].getSalary();
                x = i;
            }
        }
        System.out.println("сотрудник '" + journal[x].getNick() + "' имеет максимальную зарплату " + max + " рублей");
    }
    public static void indexingAllSalary(int percent) {
        System.out.println("Индексация окладов всех сотрудников организации на " + percent + " процентов. ");
        for (int i = 1; i < Employee.counter; i++) {
            journal[i].setSalary(journal[i].getSalary() + (journal[i].getSalary() / 100) * percent);
        }
    }
    public static void listDepartment(int department) {
        System.out.println("Распечатка списка сотрудников отдела: " + department);
        for (int i = 1; i < Employee.counter; i++) {
            if(journal[i].getDepartment() == department)
                System.out.println(journal[i].toString());
        }
    }
    public static void maxSalaryDepartment(int department) {
        System.out.println("Найден максимальный оклад сотрудника отдела " + department + ":");
        int max = Integer.MIN_VALUE;
        int x = 0;
        for (int i = 1; i < Employee.counter; i++) {
            if (journal[i].getDepartment() == department)
                if (max < journal[i].getSalary()) {
                    max = journal[i].getSalary();
                    x = i;
                }
        }
        System.out.println("Сотрудник отдела " + journal[x].getDepartment() + " " + journal[x].getNick() + " имеет максимальную в отделе зарплату " + max + " рублей");
    }
    public static void minSalaryDepartment(int department) {
        System.out.println("Найден минимальный оклад сотрудника отдела " + department + ":");
        int min = Integer.MAX_VALUE;
        int x = 0;
        for (int i = 1; i < Employee.counter; i++) {
            if (journal[i].getDepartment() == department)
                if (min > journal[i].getSalary()) {
                    min = journal[i].getSalary();
                    x = i;
                }
        }
        System.out.println("Сотрудник отдела " + journal[x].getDepartment() + " " + journal[x].getNick() + " имеет минимальную в отделе зарплату " + min + " рублей");
    }
    public static void indexingSalaryDepartment(int department, int percent) {
        System.out.println("Индексация окладов сотрудников отдела " + department + " на " + percent + " процентов: ");
        for (int i = 1; i < Employee.counter; i++) {
            if (journal[i].getDepartment() == department) {
                journal[i].setSalary(journal[i].getSalary() + (journal[i].getSalary() / 100) * percent);
                System.out.println("Сотрудник " + journal[i].getNick() + " получил проиндексированный оклад " + journal[i].getSalary() + " рублей. Id: " + i);
            }
        }
    }
    public static void sumSalaryDepartment(int department) {
        System.out.println("Сумма расходов на всех сотрудников отдела " + department + " в месяц: ");
        int sum = 0;
        for (int i = 1; i < Employee.counter; i++) {
            if (journal[i].getDepartment() == department) {
                sum = sum + journal[i].getSalary();
            }
        }
        System.out.println("Общая сумма окладов отдела " + department + " за месяц составляет " + sum + " рублей");
    }
    public static void averageSalaryDepartment(int department) {
        System.out.println("Средняя величина окладов сотрудников отдела " + department + " в месяц: ");
        int sum = 0;
        int averageSalary = 0;
        int score = 0;
        for (int i = 1; i < Employee.counter; i++) {
            if (journal[i].getDepartment() == department) {
                sum = sum + journal[i].getSalary();
                score++;
                averageSalary = sum / score;
            }
        }
        System.out.println("Средний оклад в отделе " + department + " составляет " + averageSalary + " рублей");
    }
    public static void findLessSalaryDepartment(int number, int department) {
        System.out.println("Поиск сотрудников отдела " + department + ", у которых оклад меньше заданной величины " + number + ":");
        int a = 0; // Переменная счёта для определения отсутствия сотрудников такой категории
        for (int i = 1; i < Employee.counter; i++) {
            if (journal[i].getDepartment() == department)
                if (journal[i].getSalary() < number) {
                    System.out.println(journal[i].toString());
                    a++;
                }
        }
        if (a == 0)
            System.out.println("Таких сотрудников нет");
    }
    public static void findMoreSalaryDepartment(int number, int department) {
        System.out.println("Поиск сотрудников отдела " + department + ", у которых оклад больше заданной величины " + number + ":");
        int a = 0; // Переменная счёта для определения отсутствия сотрудников такой категории
        for (int i = 1; i < Employee.counter; i++) {
            if (journal[i].getDepartment() == department)
                if (journal[i].getSalary() > number) {
                    System.out.println(journal[i].toString());
                    a++;
                }
        }
        if (a == 0)
            System.out.println("Таких сотрудников нет");
    }
    public static void main(String[] args) {
        Employee.counter = 1;
        addNick("Иванов Вячеслав Николаевич", 1, 120000);
        addNick("Петров Юрий Николаевич", 1, 70000);
        addNick("Решетов Сергей Анатольевич", 2, 55000);
        addNick("Печёнкин Евгений Александрович", 2, 65000);
        addNick("Васильев Антон Братиславович", 3, 115000);
        addNick("Петров Юрий Николаевич", 3, 110000);
        addNick("Христенко Виктор Иванович", 4, 45000);
        addNick("Алфимов Валерий Иванович", 4, 138000);
        addNick("Яковлев Александр Сергеевич", 5, 75000);
        addNick("Золотов Олег Борисович", 5, 135000);
        printAllNick(); //Распечатка полного списка сотрудников после инициализации
        amountOfSalariesForMonth(); //Определение общей суммы расходов за месяц и среднего оклада
        minimumWage(); //Определение самого маленького оклада
        maximumWage(); //Определение самого большого оклада
        journal[1].setDepartment(5); //Сотрудник первого отдела (Id-1)  перешёл в 5 отдел (Id сохранен)
        journal[1].setSalary(125000); //Повышение оклада того же сотрудника с Id-1
        printAllNick(); //Распечатка полного списка после изменений в полях сотрудника (Id-1)
        indexingAllSalary(5); //Индексация окладов всех сотрудников
        printAllNick(); //Распечатка списка сотрудников после проведенной индексации
        listDepartment(3); //Распечатка списка сотрудников отдела 3
        minSalaryDepartment(3); //Определение минимального оклада отдела 3
        maxSalaryDepartment(3); //Определение максимального оклада отдела 3
        sumSalaryDepartment(3); //Определение суммы расходов за месяц по отделу 3
        averageSalaryDepartment(3); //Определение среднего оклада в отделе 3
        indexingSalaryDepartment(3, 10); //Индексация окладов для всех сотрудников отдела 3
        findLessSalaryDepartment(70000, 5); // Сверка: есть ли в отделе сотрудники с окладом меньше заданного числа
        findLessSalaryDepartment(80000, 5); // Сверка: есть ли в отделе сотрудники с окладом меньше заданного числа
        findMoreSalaryDepartment(70000, 5); // Сверка: есть ли в отделе сотрудники с окладом больше заданного числа
        findMoreSalaryDepartment(140000, 4); // Сверка: есть ли в отделе сотрудники с окладом больше заданного числа
    }
}
