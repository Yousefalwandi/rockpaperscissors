package com.company;

import java.util.Scanner;

public class Main {
    Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        // de steg som vi kommer använda. ett spel för 2 spelare stren sax påse. de kan sätta sina namn.
        // spelarn kan välja sina drag och den som vinner till 3 vinner spelet.

        Main game = new Main();
        String player1, player2;

        System.out.println("Press 1 to start the game");

        int choice = game.reader.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Enter player 1 name");
                player1 = game.getPlayersNamne();
                System.out.println("Enter player 2 name");
                player2 = game.getPlayersNamne();
                System.out.println("Scorre goes to " + game.startGame(player1, player2 ));

                break;
            case 0:
                break;
        }
    }

    private String getPlayersNamne() {

        String player = reader.next();
        return player;

    }

    private String startGame(String player1, String player2) {

        int player1drag = getPlayerChoice(player1);
        int player2drag = getPlayerChoice(player2);
        int winnerNumber = selectWinner(player1drag, player2drag);
        if (winnerNumber ==1){
            return player1;
        }
        if (winnerNumber == 2){
            return player2;
        }
        if (winnerNumber == 0){
            return "Tie";
        }
        return "Wrong";


    }

    private int selectWinner(int player1drag, int player2drag) {
        if (player1drag == 0) {
            if (player2drag != 1) {
                if (player2drag != 0) {
                    return 1;
                }
                return 0;
            }

            return 2;
        }

        if (player1drag == 1) {
            if (player2drag != 2) {
                if (player2drag != 1) {
                    return 1;
                }
                return 0;
            }

            return 2;
        }

        if (player1drag == 2) {
            if (player2drag != 0) {
                if (player2drag != 2) {
                    return 1;
                }
                return 0;
            }

            return 2;
        }
        return -1;
    }

    private int getPlayerChoice(String player1) {
        System.out.println(player1 + ", Choose your weapon: ");
        String choice1 = reader.next();
        int value1 = getValueOfchoice(choice1);
        return value1;
    }

    private int getValueOfchoice(String choice) {
        if (choice.equalsIgnoreCase("rock") || choice.equalsIgnoreCase("1")) {
            return 0;

        }
        if (choice.equalsIgnoreCase("paper") || choice.equalsIgnoreCase("2")) {
            return 1;

        }
        if (choice.equalsIgnoreCase("scissors") || choice.equalsIgnoreCase("3")) {
            return 2;

        }
        return -1;
    }
}
