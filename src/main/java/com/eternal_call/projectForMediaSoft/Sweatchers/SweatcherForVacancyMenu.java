package com.eternal_call.projectForMediaSoft.Sweatchers;
import com.eternal_call.projectForMediaSoft.ResumeAndVacancy.Vacancy;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import static com.eternal_call.projectForMediaSoft.Main.mainer;


public class SweatcherForVacancyMenu {
    public SweatcherForVacancyMenu()  {
    }
    private static Logger logger = Logger.getLogger(SweatcherForVacancyMenu.class);
    public void sweatcher() throws SQLException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        this.outForWindow();
        int x = scanner.nextInt();
        Vacancy vacancy = new Vacancy();
        switch (x){
            case (1):{ // Создание вакансии
                System.out.println("Вы выбрали пункт: Создание вакансии");
                System.out.println("Введите вакансию, которую нужно создать");
                String name = scanner.next(); //Ввод имени вакансии
                System.out.println("Введите описание создаваемой вакансии");
                String duties = scanner2.next(); //Ввод описания вакансии
                System.out.println("Введите кол-во часов в неделю (от 1 до 168)");
                int conitions  = scanner3.nextInt(); //Ввод кол-во рабочих часов в неделю
                System.out.println("Введите заработную плату");
                int salary = scanner4.nextInt(); //Ввод размер заработной платы
                vacancy.create(name, duties, conitions, salary);
                logger.info("Создание успешно выполненно!");
                this.sweatcher();
                break;
            }case (2):{ // Поиск определенной вакансии
                System.out.println("Вы выбрали пункт: Поиск вакансии по id");
                System.out.println("Введите id вакансии, которую следует найти");
                int id = scanner.nextInt();
                vacancy.search(id);
                this.sweatcher();
                break;
            }case (3):{ //Просмотр всех вакансий
                System.out.println("Вы выбрали пункт: Просмотр всех вакансий в БД");
                vacancy.view();
                this.sweatcher();
                break;
            }case (4):{ //Удаление вакансии
                System.out.println("Вы выбрали пункт: Удаление вакансии по id");
                System.out.println("Введите id вакансии, которую следует удалить");
                int id = scanner.nextInt();
                vacancy.remove(id);
                logger.info("Удаление успешно выполненно!");
                this.sweatcher();
                break;
            }case (5):{ //Вернутся в главное меню
                mainer();
                break;
            }default:
                logger.error("Error");
                this.sweatcher();
                break;
        }
    }

    private void outForWindow(){
        System.out.println("Вы выбрали работу с вакансиями");
        System.out.println("Создание вакансии, нажмите 1");
        System.out.println("Поиск определенной вакансии, нажмите 2");
        System.out.println("Просмотр всех вакансий, нажмите 3");
        System.out.println("Удаление вакансии, нажмите 4");
        System.out.println("Вернутся в главное меню, нажмите 5");
    }
}
