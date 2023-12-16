package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("chemistry", "semester"));
        courses.add(new Course("mechanics", "two semesters"));
        courses.add(new Course("biology", "half of semester"));

        /**
         * Подключение к базе данных
         */
        Connector connector = new Connector();

        /**
         * Применение методов для работы с базой данных
         */
        DatabaseHelper.insertData(courses, connector);
        DatabaseHelper.selectData(connector);
        DatabaseHelper.updateData(connector, 2, "new Title", "new Duration");
        DatabaseHelper.deleteData(connector);

    }
}