package main.generare;

import java.io.File;
import java.util.*;

public class Automate {
    private final Set<String> states;
    private final Set<Character> alphabet;
    private final Map<Pair<String, Character>, Set<String>> transitions;
    private String startState;
    private final Set<String> endStates;

    public static class Pair<A, B> {
        private final A first;
        private final B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }

    public Automate(Set<String> states, Set<Character> alphabet, Map<Pair<String, Character>, Set<String>> transitions, String startState, Set<String> endStates) {
        this.states = states;
        this.alphabet = alphabet;
        this.transitions = transitions;
        this.startState = startState;
        this.endStates = endStates;
    }

    private void readTransitions(Scanner scanner) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String from = scanner.next();
            char symbol = scanner.next().charAt(0);
            String to = scanner.next();
            transitions.computeIfAbsent(new Pair<>(from, symbol),
                    k -> new HashSet<>()).add(to);
        }
    }

    public void readFile(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                states.add(scanner.next());
            }
            int a = scanner.nextInt();
            for (int i = 0; i < a; i++) {
                this.alphabet.add(scanner.next().charAt(0));
            }
            readTransitions(scanner);
            startState = scanner.next();
            int e = scanner.nextInt();
            for (int i = 0; i < e; i++) {
                this.endStates.add(scanner.next());
            }
        } catch (Exception e) {
            System.out.println("Error reading file " + fileName);
        }
    }

    public void readKeyboard(Scanner scanner) {
        System.out.println("Number of states: ");
        int n = scanner.nextInt();
        System.out.println("Initial states: ");
        for (int i = 0; i < n; i++) {
            states.add(scanner.next());
        }
        System.out.println("Number of elements in alphabet: ");
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            this.alphabet.add(scanner.next().charAt(0));
        }
        System.out.println("Number of transitions: ");

        readTransitions(scanner);

        System.out.println("Initial start state: ");
        startState = scanner.next();

        System.out.println("Number of end states: ");
        int e = scanner.nextInt();
        System.out.println("Initial end states: ");
        for (int i = 0; i < e; i++) {
            endStates.add(scanner.next());
        }
    }

    public void writeStates() {
        for (String s : states) {
            System.out.println(s);
        }
    }

    public void writeAlphabet() {
        for (Character c : alphabet) {
            System.out.println(c);
        }
    }

    public void writeTransitions() {
        for (var p : transitions.entrySet()) {
            System.out.println("(" + p.getKey().first + ", " + p.getKey().second + ") -> " + p.getValue());
        }
    }

    public void writeFinalStates() {
        for (String s : endStates) {
            System.out.println(s);
        }
    }

    public Boolean isDeterministic() {
        for (Map.Entry<Pair<String, Character>, Set<String>> entry : transitions.entrySet()) {
            if (entry.getValue().size() > 1) {
                return false;
            }
        }
        return true;
    }

    public Boolean isAccepted(String sequence) {
        if (!isDeterministic()) {
            System.out.println("Automatul e nedeterminist");
            return false;
        }
        String currentState = startState;
        for (char symbol : sequence.toCharArray()) {
            Pair<String, Character> key = new Pair<>(currentState, symbol);
            if (!transitions.containsKey(key)) {
                return false;
            }
            currentState = transitions.get(key).iterator().next();
        }
        return endStates.contains(currentState);
    }

    public String prefix(String sequence) {
        if (!isDeterministic()) {
            System.out.println("Automatul e nedeterminist");
            return "None";
        }
        String currentState = startState;
        StringBuilder current = new StringBuilder();
        String prefix = "";
        for (char symbol : sequence.toCharArray()) {
            Pair<String, Character> key = new Pair<>(currentState, symbol);
            if (!transitions.containsKey(key)) {
                break;
            }
            currentState = transitions.get(key).iterator().next();
            current.append(symbol);
            if (endStates.contains(currentState)) {
                prefix = current.toString();
            }
        }
        return prefix;
    }

}
