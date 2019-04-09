package com.eternal_call.projectForMediaSoft.Sweatchers;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

import static com.eternal_call.projectForMediaSoft.Main.mainer;

public class SweatcherForMainMenu {
    private static Logger logger = Logger.getLogger(SweatcherForMainMenu.class);
    public void switcher(int x) throws IOException, SQLException, ClassNotFoundException {
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
            }default:
                logger.error("Error");
                mainer();
                break;
        }
    }
}

