package com.eternal_call.projectForMediaSoft.Sweatchers;


import java.io.IOException;

public class SweatcherForMainMenu {
    public void switcher(int x) throws IOException {
        switch (x){
            case (1):{ //Реализация работы с вакансиями
                SweatcherForVacancyMenu sweatcherForVacancyMenu = new SweatcherForVacancyMenu();
                sweatcherForVacancyMenu.sweatcher();
                break;
            }case (2):{ //Реализация работы с резюме
                SweatcherForResumeMenu sweatcherForResumeMenu = new SweatcherForResumeMenu();
                sweatcherForResumeMenu.sweatcher();
                break;
            }case(3):{ //Выход из программы
                break;
            }default: break;
        }
    }
}

