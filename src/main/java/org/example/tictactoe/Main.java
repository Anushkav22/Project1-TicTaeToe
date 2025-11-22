package org.example.tictactoe;

import org.example.tictactoe.Strategies.winningstrategy.WinningStrategy;
import org.example.tictactoe.models.Game;
import org.example.tictactoe.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Game Starts");
        Scanner scanner = new Scanner(System.in);

        int dimension = scanner.nextInt();

        //Take the player information in the input.
        List<Player> players = new ArrayList<>();
        List<WinningStrategy> winningStrategies = new ArrayList<>();

        Game game= Game.getBuilder().setDimensions(dimension)
                                    .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();



    }
}
