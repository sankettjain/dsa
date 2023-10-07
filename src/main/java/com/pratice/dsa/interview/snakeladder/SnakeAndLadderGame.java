package com.pratice.dsa.interview.snakeladder;

import java.util.*;

class SnakeAndLadderGame {
    private static final int BOARD_SIZE = 100;
    private static final Map<Integer, Integer> snakes;
    private static final Map<Integer, Integer> ladders;

    static {
        snakes = new HashMap<>();
        snakes.put(16, 6);
        snakes.put(47, 26);
        snakes.put(49, 11);
        snakes.put(56, 53);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 24);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 78);

        ladders = new HashMap<>();
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);
    }

    private int[] players;

    public SnakeAndLadderGame(int numPlayers) {
        players = new int[numPlayers];
        Arrays.fill(players, 1); // Initialize players at position 1
    }

    private int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    private int getNextPosition(int currentPosition, int diceValue, int currentPlayer) {
        int newPosition = currentPosition + diceValue;

        if (newPosition > BOARD_SIZE) {
            newPosition = BOARD_SIZE - (newPosition - BOARD_SIZE);
        }

        // Check for snakes and ladders
        if (snakes.containsKey(newPosition)) {
            System.out.printf("Player %d bitten by snake at a %d.\n", currentPlayer, newPosition);
            newPosition = snakes.get(newPosition);
        } else if (ladders.containsKey(newPosition)) {
            System.out.printf("Player %d git a ladder at a %d.\n", currentPlayer, newPosition);
            newPosition = ladders.get(newPosition);
        }

        return newPosition;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int currentPlayer = 0;

        while (true) {
            System.out.printf("Player %d's turn. Press Enter to roll the dice.", currentPlayer + 1);
            scanner.nextLine();

            int diceValue = rollDice();
            System.out.printf("Player %d rolled a %d.\n", currentPlayer + 1, diceValue);

            players[currentPlayer] = getNextPosition(players[currentPlayer], diceValue, currentPlayer + 1);

            if (players[currentPlayer] == BOARD_SIZE) {
                System.out.printf("Player %d wins!\n", currentPlayer + 1);
                break;
            }

            System.out.printf("Player %d is now at position %d.\n", currentPlayer + 1, players[currentPlayer]);

            currentPlayer = (currentPlayer + 1) % players.length;
        }

        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Snake and Ladder Game!");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();

        SnakeAndLadderGame game = new SnakeAndLadderGame(numPlayers);
        game.playGame();

        scanner.close();
    }
}

