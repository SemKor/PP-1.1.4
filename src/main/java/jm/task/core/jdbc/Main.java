package jm.task.core.jdbc;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        //Создаем таблицу users
        userService.createUsersTable();

        //Добавляем 4-х users в таблицу
        userService.saveUser("Alex", "Mirniy", (byte) 33);
        userService.saveUser("Petr", "Gordiy", (byte) 24);
        userService.saveUser("Irina", "Konchalovskaya", (byte) 26);
        userService.saveUser("Pavel", "Kovalev", (byte) 31);

        // Получаем всх users из базы в консоль
        List<User> listUsers = userService.getAllUsers();
        listUsers.forEach(System.out::println);

        // Очищаем таблицу
        userService.cleanUsersTable();

        // Удаляем таблицу
        userService.dropUsersTable();
    }
}
