package com.eternal_call.projectForMediaSoft.Sweatchers;
import com.eternal_call.projectForMediaSoft.ResumeAndVacancy.Vacancy;

import java.io.IOException;
import java.util.Scanner;


public class SweatcherForVacancyMenu {
    public SweatcherForVacancyMenu()  {
    }


    public void sweatcher() throws IOException {

        Scanner scanner = new Scanner(System.in);
        this.outForWindow();
        int x = scanner.nextInt();
        switch (x){
            case (1):{ // Создание вакансии
                break;
            }case (2):{ // Поиск определенной вакансии
                Vacancy vacancy = new Vacancy();
                System.out.println("Введите id вакансии");
                int id = scanner.nextInt();
                vacancy.search(id);
                break;
            }case (3):{ //Просмотр всех вакансий
                break;
            }case (4):{ //Удаление вакансии
                break;
            }case (5):{ //Вернутся в главное меню
                break;
            }default: break;
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
