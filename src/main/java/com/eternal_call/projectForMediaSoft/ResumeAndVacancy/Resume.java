package com.eternal_call.projectForMediaSoft.ResumeAndVacancy;
import com.eternal_call.projectForMediaSoft.DataBase.ConnectionToDataBase;
import com.eternal_call.projectForMediaSoft.Interfaces.*;
import java.io.*;
import java.sql.*;


public class Resume extends Template implements Removing, Searching, Viewing, Recording {
    Resume() throws IOException {
    }



    private String firstName;
    private String secondName;
    private String experience;

    @Override
    public void record() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void search(int id)  throws IOException {
        try{
            ConnectionToDataBase conn = new ConnectionToDataBase();
            Class.forName(conn.getdDriverName()); // Определение имени класса драйвера
            Connection connect = DriverManager.getConnection(conn.getdUrl(), conn.getdLogin(),
                    conn.getPassword()); // Создание подключения
            Statement state = connect.createStatement();
            String code = "SELECT * FROM vacancy WHERE name LIKE '" + id + "%'" ; //SQL запрос в БД
            ResultSet resSet = state.executeQuery(code);
            outInfo(resSet);
            connect.close();
        } catch (ClassNotFoundException | SQLException e) {

        }
    }

    @Override
    public void view() {

    }


}
