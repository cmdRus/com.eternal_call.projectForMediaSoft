package com.eternal_call.projectForMediaSoft.ResumeAndVacancy;
import com.eternal_call.projectForMediaSoft.DataBase.ConnectionToDataBase;
import java.io.IOException;
import java.sql.*;


public abstract class Template {
    protected Template()  {
    }

    public String jobTitle;
    public int conditions;
    public double salary;
    public String description;


    protected void outInfo(ResultSet resSet) throws SQLException {
        while (resSet.next()){ //Вывод на экран результата запроса
            System.out.print(resSet.getInt(1) + "   ");
            System.out.print(resSet.getString(2) + "   ");
            System.out.print(resSet.getString(3) + "   ");
            System.out.println(resSet.getString(4));
            System.out.println(resSet.getInt(5) + " |  ");
            System.out.println("--------------------------------------------------------------");
        }
    }
}
