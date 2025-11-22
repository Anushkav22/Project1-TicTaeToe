package org.example.tictactoe.Strategies.winningstrategy;

import org.example.tictactoe.models.Board;
import org.example.tictactoe.models.Cell;
import org.example.tictactoe.models.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player, Cell cell);

}
