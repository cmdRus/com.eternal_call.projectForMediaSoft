package com.eternal_call.projectForMediaSoft.Sweatchers;
import com.eternal_call.projectForMediaSoft.ResumeAndVacancy.Resume;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import static com.eternal_call.projectForMediaSoft.Main.mainer;


public class SweatcherForResumeMenu {
    private static Logger logger = Logger.getLogger(SweatcherForResumeMenu.class); //инициализация логирования

    public void sweatcher() throws SQLException, IOException, ClassNotFoundException {
        this.outForWindow(); //вывод на экран меню резюме
        Scanner scanner = new Scanner(System.in);
        Resume resume = new Resume();
        int x = scanner.nextInt();

        switch (x){
            case(1):{ // Просмотр всех резюме
                System.out.println("Вы выбрали пункт: Просмотр всех резюме в БД");
                resume.view();
                this.sweatcher();
                break;
            }case(2):{ // Удаление резюме
                System.out.println("Вы выбрали пункт: Удаление резюме по id");
                System.out.println("Введите id резюме, которую следует удалить");
                int id = scanner.nextInt();
                resume.remove(id);
                logger.info("Удаление успешно выполненно!");
                this.sweatcher();
                break;
            }case(3):{ // Поиск определенной вакансии
                System.out.println("Вы выбрали пункт: Поиск резюме по id");
                System.out.println("Введите id резюме, которую следует найти");
                int id = scanner.nextInt();
                resume.search(id);
                this.sweatcher();
                break;
            }case(4):{ //Вернутся в главное меню
                mainer();
                break;
            }default:
                logger.error("Error");
                this.sweatcher();
                break;
        }
    }

    private void outForWindow(){
        System.out.println("Просмотр всех резюме, нажмите 1");
        System.out.println("Удалить резюме, нажмите 2");
        System.out.println("Поиск определенной вакансии, нажмите 3");
        System.out.println("Вернутся в главное меню, нажмите 4");
    }
}
