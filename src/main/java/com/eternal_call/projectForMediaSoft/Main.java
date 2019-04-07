package com.eternal_call.projectForMediaSoft;
import com.eternal_call.projectForMediaSoft.Sweatchers.SweatcherForMainMenu;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать в систему поиска и размещения вакансий");
        mainer();
        System.out.println("Finish program. THX for using ;)");
    }

    /* Реализация главного меню*/
    public static void mainer() throws IOException {
        System.out.println("Если вы хотите работать с вакансиями, нажмите 1:");
        System.out.println("Если вы хотите работать с резюме соискателей, нажмите 2:");
        System.out.println("Если вы хотите закончить работу программы, нажмите 3:");
        try{ //Обработка правильности вводимого значения для главного меню
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            SweatcherForMainMenu sweatcherForMainMenu = new SweatcherForMainMenu();
            sweatcherForMainMenu.switcher(x);
        } catch (Exception e) { // Обработка логером ошибки
            System.out.println("Упс... Где-то ошибка");
            mainer();
        }
    }
}