package com.eternal_call.projectForMediaSoft.ResumeAndVacancy;
import com.eternal_call.projectForMediaSoft.DataBase.ConnectionToDataBase;
import com.eternal_call.projectForMediaSoft.Interfaces.*;
import java.io.*;
import java.sql.*;


public class Vacancy extends Template implements Creating, Removing, Searching, Viewing, Recording  {
    public Vacancy() throws IOException {
    }
    ConnectionToDataBase connect = new ConnectionToDataBase(); // Создание url, login, password, driverName
    private String requirements;
    private String duties;

    @Override
    public void create() {

    }

    @Override
    public void record() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void view() {

    }

    @Override
    public void search(int id) throws IOException {
        try{
            Class.forName(connect.getdDriverName()); // Определение имени класса драйвера
            Connection connect = DriverManager.getConnection(this.connect.getdUrl(), this.connect.getdLogin(),
                    this.connect.getPassword()); // Создание подключения
            Statement state = connect.createStatement();
            String code = "SELECT * FROM vacancy WHERE name LIKE '" + id + "%'" ; //SQL запрос в БД
            ResultSet resSet = state.executeQuery(code);
            outInfo(resSet);
            connect.close();
        } catch (ClassNotFoundException | SQLException e) {

        }
    }
}
