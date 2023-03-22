package Basic;

public class Main {

    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        Employee.counter = 1;
        employeeBook.addNick("Иванов Вячеслав Николаевич", 1, 120000); //Ввод сотрудников в журнал учёта по всем отделам
        employeeBook.addNick("Петров Юрий Николаевич", 1, 70000);
        employeeBook.addNick("Решетов Сергей Анатольевич", 2, 55000);
        employeeBook.addNick("Печёнкин Евгений Александрович", 2, 65000);
        employeeBook.addNick("Васильев Антон Братиславович", 3, 115000);
        employeeBook.addNick("Петров Юрий Николаевич", 3, 110000);
        employeeBook.addNick("Христенко Виктор Иванович", 4, 45000);
        employeeBook.addNick("Алфимов Валерий Иванович", 4, 138000);
        employeeBook.addNick("Яковлев Александр Сергеевич", 5, 75000);
        employeeBook.addNick(null, 0, 0);
        employeeBook.addNick("Золотов Олег Борисович", 5, 135000);
        employeeBook.printAllNick(); //Распечатка полного списка сотрудников после инициализации
        employeeBook.amountOfSalariesForMonth(); //Определение общей суммы расходов за месяц и среднего оклада
        employeeBook.minimumWage(); //Определение самого маленького оклада
        employeeBook.maximumWage(); //Определение самого большого оклада
        employeeBook.getJournal()[1].setDepartment(5); //Сотрудник первого отдела (Id-1)  перешёл в 5 отдел (Id сохранен)
        employeeBook.getJournal()[1].setSalary(125000); //Повышение оклада того же сотрудника с Id-1
        employeeBook.printAllNick(); //Распечатка полного списка после изменений в полях сотрудника (Id-1)
        employeeBook.indexingAllSalary(5); //Индексация окладов всех сотрудников
        employeeBook.printAllNick(); //Распечатка списка сотрудников после проведенной индексации
        employeeBook.listDepartment(3); //Распечатка списка сотрудников отдела 3
        employeeBook.minSalaryDepartment(3); //Определение минимального оклада отдела 3
        employeeBook.maxSalaryDepartment(3); //Определение максимального оклада отдела 3
        employeeBook.sumSalaryDepartment(3); //Определение суммы расходов за месяц по отделу 3
        employeeBook.averageSalaryDepartment(3); //Определение среднего оклада в отделе 3
        employeeBook.indexingSalaryDepartment(3, 10); //Индексация окладов для всех сотрудников отдела 3
        employeeBook.findLessSalaryDepartment(70000, 5); // Сверка: есть ли в отделе сотрудники с окладом меньше заданного числа
        employeeBook.findLessSalaryDepartment(80000, 5); // Сверка: есть ли в отделе сотрудники с окладом меньше заданного числа
        employeeBook.findMoreSalaryDepartment(70000, 5); // Сверка: есть ли в отделе сотрудники с окладом больше заданного числа
        employeeBook.findMoreSalaryDepartment(140000, 4); // Сверка: есть ли в отделе сотрудники с окладом больше заданного числа
        employeeBook.printAllNick(); //Распечатка полного списка сотрудников
        employeeBook.addNewNick("Рябов Игорь Васильевич", 1, 57000); //Добавляю нового сотрудника на вакантное место
        employeeBook.printAllNick(); //Распечатка полного списка сотрудников после внесения нового сотрудника
        employeeBook.addNewNick("Северов Петр Валерьевич", 4, 77000); //Добавляю очередного нового сотрудника на вакантное место
        employeeBook.removeNick("Золотов Олег Борисович", 0, 0);
        employeeBook.printAllNick(); //Распечатка полного списка сотрудников
        employeeBook.removeNick("Христенко Виктор Иванович", 0, 0);
        employeeBook.printAllNick(); //Распечатка полного списка сотрудников
        employeeBook.modeNick("Печёнкин Евгений Александрович", 2, 65000); //Добавляю очередного нового сотрудника на вакантное место
        employeeBook.printAllNick(); //Распечатка полного списка сотрудников
        employeeBook.addNewNick("Северов Нестор Петрович", 1, 57000); //Добавляю нового сотрудника на первое вакантное место
        employeeBook.printAllNick(); //Итоговая распечатка списка сотрудников по всем отделам, включая вакансии


    }
}
