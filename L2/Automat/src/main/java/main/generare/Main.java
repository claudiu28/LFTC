package main.generare;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> states = new HashSet<>();
        Set<Character> alphabet = new HashSet<>();
        Map<Automate.Pair<String, Character>, Set<String>> transitions = new HashMap<>();
        Set<String> endStates = new HashSet<>();

        Automate aut = new Automate(states, alphabet, transitions, null, endStates);
        System.out.println("Meniu \n Introduceti varianta de cititre:\n");
        System.out.println("1. Tastatura");
        System.out.println("2. Fisier");
        System.out.println("Introduce optiune");
        Scanner scanner = new Scanner(System.in);
        int opt = scanner.nextInt();
        if (opt == 1) {
            aut.readKeyboard(scanner);
        } else if (opt == 2) {
            String fileName = args[0];
            aut.readFile(fileName);
        } else {
            System.out.println("Optiune invalida");
        }

        if (aut.isDeterministic()) {
            System.out.println("Automatul este determinist");
        } else {
            System.out.println("Automatul este nedeterminist");
        }

        int o;
        do {
            System.out.println("MENIU");
            System.out.println("1. Afisare stari");
            System.out.println("2. Afisare alfabet");
            System.out.println("3. Afisare tranzitii");
            System.out.println("4. Afisare stari finale");
            System.out.println("5. Verifica secventa");
            System.out.println("6. Cel mai lung prefix acceptat");
            System.out.println("0. Iesire");
            System.out.print("Optiune: ");
            o = scanner.nextInt();

            switch (o) {
                case 1 -> aut.writeStates();
                case 2 -> aut.writeAlphabet();
                case 3 -> aut.writeTransitions();
                case 4 -> aut.writeFinalStates();
                case 5 -> {
                    String s = scanner.next();
                    Boolean isAcc = aut.isAccepted(s);
                    if (isAcc) {
                        System.out.println("Secventa a fost acceptata cu succes, este valida");
                    } else {
                        System.out.println("Secventa nu a fost acceptata cu succes");
                    }
                }
                case 6 -> {
                    System.out.println("Secventa: ");
                    String s = scanner.next();
                    System.out.println("Cel mai lung preefix acceptat: " + aut.prefix(s));
                }
            }
        } while (o != 0);
    }
}
