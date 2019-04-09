package com.eternal_call.projectForMediaSoft.ResumeAndVacancy;
import com.eternal_call.projectForMediaSoft.DataBase.ConnectionToDataBase;
import org.apache.log4j.Logger;
import java.io.*;
import java.sql.*;


public abstract class Template {
    protected Template() throws SQLException, IOException, ClassNotFoundException {
    }

    Statement state = connect().createStatement();
    protected static Logger logger = Logger.getLogger(Template.class);
    protected String fileForVac = "Vacancy.txt"; //инициализация файла, для выгрузки всех вакансий
    protected String fileForRes = "Resume.txt"; //инициализация файла, для выгрузки всех резюме
    protected String dataBaseForVakancy = "vacancy"; //инициализация БД вакансии
    protected String dataBaseForResume = "resume"; //инициализация БД резюме
    protected String sql_end = "%'";
    protected String sql_separator = "', '";
    protected String sql_separator_end = "')";

    protected Connection connect() throws SQLException, ClassNotFoundException, IOException { //подключение к БД
        ConnectionToDataBase connectionToDB = new ConnectionToDataBase(); // Инициализация класса с  url, login, password, driverName
        Class.forName(connectionToDB.getdDriverName()); // Определение имени класса драйвера
        Connection conn = DriverManager.getConnection(connectionToDB.getdUrl(), connectionToDB.getdLogin(), //установка соединения с БД
                connectionToDB.getPassword()); // Создание подключения
        return conn;
    }

    protected void outInfoVac(ResultSet resSet) throws SQLException { //вывод запроса (вакансии) на экран
        while (resSet.next()){ //Вывод на экран результата запроса
            System.out.print(resSet.getInt(1) + " |  ");
            System.out.print(resSet.getString(2) + " |  ");
            System.out.print(resSet.getString(3) + " |  ");
            System.out.print(resSet.getString(4) + " |  ");
            System.out.println(resSet.getInt(5) + " |  ");
            System.out.println("--------------------------------------------------------------");
        }
    }

    protected void outInfoRes(ResultSet resSet) throws SQLException { //вывод запроса (резюме) на экран
        while (resSet.next()){ //Вывод на экран результата запроса
            System.out.print(resSet.getInt(1) + " |  ");
            System.out.print(resSet.getString(2) + " |  ");
            System.out.print(resSet.getString(3) + " |  ");
            System.out.print(resSet.getString(4) + " |  ");
            System.out.println(resSet.getString(5) + " |  ");
            System.out.println("--------------------------------------------------------------");
        }
    }
}
