package com.eternal_call.projectForMediaSoft.ResumeAndVacancy;
import com.eternal_call.projectForMediaSoft.Interfaces.*;
import org.apache.log4j.Logger;
import java.io.*;
import java.sql.*;
import java.util.Scanner;


public class Resume extends Template implements Removing, Searching, Viewing, Recording {
    public Resume() throws SQLException, IOException, ClassNotFoundException{
    }

    private String sql_view = "select * from " + dataBaseForResume;
    private String sql_searchRes = "SELECT * FROM " + dataBaseForResume + " WHERE id LIKE '";
    private String sql_removeRes = "DELETE FROM " + dataBaseForResume  + " WHERE id LIKE '";



    @Override
    public void remove(int id) {
        try{
            state.executeUpdate(this.sql_removeRes + id + sql_end); //SQL запрос в БД
            connect().close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void search(int id)  throws IOException {
        try{
            System.out.println("Поиск вакансии в базе данных");
            ResultSet resSet = state.executeQuery(this.sql_searchRes + id + sql_end); //SQL запрос в БД
            outInfoVac(resSet);
            connect().close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void view() {
        try{
            System.out.println("Просмотр всех данных в базе данных: Вакансии");
            ResultSet resSet = state.executeQuery(this.sql_view); //SQL запрос в БД
            outInfoRes(resSet);
            connect().close();
            record();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void record() {
        System.out.println("Хотите выгрузить всё в файл? Нажмите 1");
        System.out.println("В обратном случае, нажмите 2");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a==1) {
            try{ // Реализация записи резюме в файл, которое срабатывает при нажатии 1
                ResultSet resSet = state.executeQuery(this.sql_view); //SQL запрос в БД
                File fileName = new File(fileForRes); //Определение файла, для выгрузки всех вакансий
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                while (resSet.next()){ // Запись результата запроса в файл в файл
                    writer.write(resSet.getInt(1) + " |  ");
                    writer.write(resSet.getString(2) + " |  ");
                    writer.write(resSet.getString(3) + " |  ");
                    writer.write(resSet.getString(4) + " |  ");
                    writer.write(resSet.getString(5) + " |  \n");
                    writer.write("-------------------------------------------------------------- \n");
                }
                writer.flush();
                writer.close();
                connect().close();
            } catch (ClassNotFoundException | SQLException | IOException e) {
                logger.error(e);
            }
        }
    }
}
