package com.eternal_call.projectForMediaSoft.Sweatchers;
import java.util.Scanner;

public class SweatcherForResumeMenu {
    public void sweatcher(){
        this.outForWindow();
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        switch (x){
            case(1):{ // Просмотр всех резюме

                break;
            }case(2):{ // Удаление резюме

                break;
            }case(3):{ // Поиск определенной вакансии

                break;
            }case(4):{ //Вернутся в главное меню

                break;
            }default: break;
        }
    }

    private void outForWindow(){
        System.out.println("Просмотр всех резюме, нажмите 1");
        System.out.println("Удалить резюме, нажмите 2");
        System.out.println("Поиск определенной вакансии, нажмите 3");
        System.out.println("Вернутся в главное меню, нажмите 4");
    }
}
