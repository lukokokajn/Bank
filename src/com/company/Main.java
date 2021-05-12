package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(" |  _ \\            | |        \n" +
                " | |_) | __ _ _ __ | | ____ _ \n" +
                " |  _ < / _` | '_ \\| |/ / _` |\n" +
                " | |_) | (_| | | | |   < (_| |\n" +
                " |____/ \\__,_|_| |_|_|\\_\\__,_|\n" +
                "                              \n" +
                "                              ");

        ArrayList<String> ucty = new ArrayList<>();
        ArrayList<Integer> penize = new ArrayList<>();
        Osoba osoba = new Osoba();
        Bank bank = new Bank();
        BankaUcty bankaucty = new BankaUcty();
        menu(osoba, bank, bankaucty, ucty, penize);
    }

    public static void menu(Osoba osoba, Bank bank, BankaUcty bankaucty, ArrayList<String> ucty, ArrayList<Integer> penize) {
        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("1. Vytvořit osobu");
            System.out.println("2. Založit účet (musíš mít osobu)");
            System.out.println("3. Poslat peníze na jiný účet");
            System.out.println("4. Zrušit účet");
            System.out.println("5. Exit");

            int input = sc.nextInt();

            if (input == 1)
                TvorbaCloveka(osoba, bank, bankaucty, ucty, penize);
            if (input == 2)
                TvoreniUctu(osoba, bank, bankaucty, ucty, penize);
            if (input == 3)
                Posilani(bankaucty, ucty, penize);
            if (input == 4)
                OdstraneniUctu(osoba, bank, bankaucty, ucty, penize);
            if (input == 5) {
                System.exit(0);
            }
        }
    }

    public static void TvorbaCloveka(Osoba osoba, Bank bank, BankaUcty bankaucty, ArrayList<String> ucty, ArrayList<Integer> penize) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Zadejte jméno:");
        osoba.setJmeno(sc.nextLine());

        System.out.println("Zadejte přijmení:");
        osoba.setPrijmeni(sc.nextLine());

        System.out.println("Zadejte rok narození");
        osoba.setRoknarozeni(sc.nextInt());

        System.out.println("----Vytváření----");
        System.out.println("----Hotovo----");
        System.out.println("Jméno:" + " " + osoba.getJmeno());
        System.out.println("Přijmení:" + " " + osoba.getPrijmeni());
        System.out.println("Rok narození:" + " " + osoba.getRoknarozeni());
        osoba.setClovek(1);

        menu(osoba, bank, bankaucty, ucty, penize);
    }

    public static void TvoreniUctu(Osoba osoba, Bank bank, BankaUcty bankaucty, ArrayList<String> ucty, ArrayList<Integer> penize) {
        Scanner sc = new Scanner(System.in);

         if (osoba.getClovek() == 1) {
             System.out.println("Vyberte si banku");
             System.out.println("1. Airbank");
             System.out.println("2. Česká spořitelna");
             System.out.println("3. Komerční banka");

             int input = sc.nextInt();

             CisloUctu(bankaucty);

             while (input < 4 && input != 0) {
                 if (input == 1) {
                     bankaucty.setCislobanky("0100");
                     System.out.println("-------------------------");
                     System.out.println("----Vytvořeno----");
                     bank.setBank("Airbank");
                     System.out.println("Banka" + " " + bank.getBank());
                     System.out.println("Číslo účtu" + " " + bankaucty.getCislouctu() + "/" + bankaucty.getCislobanky());
                     System.out.println("-------------------------");
                     ucty.add(bank.getBank() + " " + "-" + " " + bankaucty.getCislouctu() + "/" + bankaucty.getCislobanky());
                 }
                 if (input == 2) {
                     bankaucty.setCislobanky("0200");
                     System.out.println("-------------------------");
                     System.out.println("----Vytvořeno----");
                     bank.setBank("Česká spořitelna");
                     System.out.println("Banka" + " " + bank.getBank());
                     System.out.println("Číslo účtu" + " " + bankaucty.getCislouctu() + "/" + bankaucty.getCislobanky());
                     System.out.println("-------------------------");
                     ucty.add(bank.getBank() + " " + "-" + " " + bankaucty.getCislouctu() + "/" + bankaucty.getCislobanky());
                 }

                 if (input == 3) {
                     bankaucty.setCislobanky("0300");
                     System.out.println("-------------------------");
                     System.out.println("----Vytvořeno----");
                     bank.setBank("Komerční banka");
                     System.out.println("Banka" + " " + bank.getBank());
                     System.out.println("Číslo účtu" + " " + bankaucty.getCislouctu() + "/" + bankaucty.getCislobanky());
                     System.out.println("-------------------------");
                     ucty.add(bank.getBank() + " " + "-" + " " + bankaucty.getCislouctu() + "/" + bankaucty.getCislobanky());
                 }
                 break;
             }
         }
        penize.add(1000);
        System.out.println("K novému účtu jsi dostal 1000 Kč");
        menu(osoba, bank, bankaucty, ucty, penize);
    }

    public static void CisloUctu(BankaUcty bankaucty) {
        Random random = new Random();

        int small = 100000000;
        int big = 999999999;
        int a = random.nextInt(big - small) + small;

        bankaucty.setCislouctu(a);
    }

    public static void OdstraneniUctu(Osoba osoba, Bank bank, BankaUcty bankaucty, ArrayList<String> ucty, ArrayList<Integer> penize) {
        Scanner sc = new Scanner(System.in);

            System.out.println("---Zadejte pozici učtu, který chcete odstranit---");
            System.out.println(ucty);
            int input = sc.nextInt();
            System.out.println("Účet" + " " + ucty.get(input - 1) + " " + "byl zrušen.");
            ucty.remove(input - 1);
            System.out.println("Zbývající účty:" + ucty);

        menu(osoba, bank, bankaucty, ucty, penize);
    }

    public static void Posilani(BankaUcty bankaucty, ArrayList<String> ucty, ArrayList<Integer> penize) {
        Scanner sc = new Scanner(System.in);

        if(bankaucty.getExistence() == 0) {

            System.out.println("---Zvolte pozici učtu ze kterého pošlete peníze---");
            System.out.println(ucty);

            int input = sc.nextInt();
            System.out.println("-----------------");
            System.out.println(ucty.get(input - 1));
            System.out.println("Momentálně na účtu:" + " " + penize.get(input - 1) + " " + "Kč");
            System.out.println("-----------------");
            System.out.println("---Zvolte pozici účtu na který chcete poslat peníze---");

            int input2 = sc.nextInt();
            System.out.println("-----------------");
            System.out.println(ucty.get(input2 - 1));
            System.out.println("Momentálně na účtu:" + " " + penize.get(input2 - 1) + " " + "Kč");
            System.out.println("-----------------");
            System.out.println("---Zvolte částku kterou chcete poslat---");

            int castka = sc.nextInt();
            if (castka > penize.get(input)) {
                System.out.println("---Nemáte dostatek peněz---");
                Posilani(bankaucty, ucty, penize);
            }
            penize.set(input - 1, penize.get(input - 1) - castka);
            penize.set(input2 -1, penize.get(input2 - 1) + castka);
            System.out.println("-----------------");
            System.out.println(ucty.get(input - 1));
            System.out.println("Nyní na účtu:" + " " + penize.get(input - 1) + " " + "Kč");
            System.out.println("-----------------");
            System.out.println("-----------------");
            System.out.println(ucty.get(input2 - 1));
            System.out.println("Nyní na účtu:" + " " + penize.get(input2 - 1) + " " + "Kč");
            System.out.println("-----------------");
            System.out.println("---Částka" + " " + castka + " Kč" + " " + "byla převedena---");
        }
    }
}