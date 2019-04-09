package com.eternal_call.projectForMediaSoft.ResumeAndVacancy;
import com.eternal_call.projectForMediaSoft.Interfaces.*;
import java.io.*;
import java.sql.*;
import java.util.Scanner;


public class Vacancy extends Template implements Creating, Removing, Searching, Viewing, Recording  {
    public Vacancy() throws SQLException, IOException, ClassNotFoundException{
    }

    private String sql_searchVac = "SELECT * FROM " + dataBaseForVakancy + " WHERE id LIKE '"; //запрос в бд, для поиска вакансии
    private String sql_removeVac = "DELETE FROM " + dataBaseForVakancy  + " WHERE id LIKE '"; //запрос в бд, для удаления вакансии
    private String sql_view = "select * from " + dataBaseForVakancy; //запрос в бд, для просмотра всех вакансий
    private String sql_columns = "name, duties, hoursInWeek, salary)"; //инициализация колонок, для создания вакансии
    private String sql_createVac = "INSERT INTO " + dataBaseForVakancy + " (" + this.sql_columns + " VALUES ('"; //запрос в бд, для создания вакансии

    @Override
    public void create(String nameNew, String dutiesNew, int conditionsNew, int salaryNew) {
        try{
            state.executeUpdate(this.sql_createVac + nameNew + sql_separator
                    + dutiesNew + sql_separator  + conditionsNew + sql_separator
                    + salaryNew + sql_separator_end); //SQL запрос в БД
            connect().close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void remove(int id) {  //реализация удаления данных из БД
        try{
            state.executeUpdate(this.sql_removeVac + id + sql_end); //SQL запрос в БД
            connect().close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void view() { //реализация просмотра всех данных из БД
        try{
            System.out.println("Просмотр всех данных в базе данных: Вакансии");
            ResultSet resSet = state.executeQuery(this.sql_view); //SQL запрос в БД
            outInfoVac(resSet);
            connect().close();
            record();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void search(int id)  { //реализация поиска в БД
        try{
            System.out.println("Поиск вакансии в базе данных");
            ResultSet resSet = state.executeQuery(this.sql_searchVac + id + sql_end); //SQL запрос в БД
            outInfoVac(resSet);
            connect().close();
        } catch (ClassNotFoundException | SQLException | IOException e) {
            logger.error(e);
        }
    }

    @Override
    public void record() { //запись в файл вакансий
        System.out.println("Хотите выгрузить всё в файл? Нажмите 1");
        System.out.println("В обратном случае, нажмите 2");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a==1) {
            try{ // Реализация записи вакансий в файл, которое срабатывает при нажатии 1
                ResultSet resSet = state.executeQuery(this.sql_view); //SQL запрос в БД
                File fileName = new File(fileForVac); //Определение файла, для выгрузки всех вакансий
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                while (resSet.next()){ // Запись результата запроса в файл в файл
                    writer.write(resSet.getInt(1) + " |  ");
                    writer.write(resSet.getString(2) + " |  ");
                    writer.write(resSet.getString(3) + " |  ");
                    writer.write(resSet.getString(4) + " |  ");
                    writer.write(resSet.getInt(5) + " |  \n");
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
