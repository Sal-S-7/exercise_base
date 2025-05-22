package org.example.exerciseJDBC.exercice1;
import org.example.exerciseJDBC.exercice1.utils.ConnectionUtils;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Menu menu = new Menu();
        AddStudent addStudent = new AddStudent();
        Scanner scanner = new Scanner(System.in);

        System.out.println(menu);

    }
}