package org.example.tictactoe.models;

import org.example.tictactoe.Strategies.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
private Board board;
private List<Player> players;

    public static Builder getBuilder() {
        return new Builder();
    }
    private Game(int dimension, List<Player> players,List<WinningStrategy> winningStrategies) {
        this.board=new Board(dimension);
        this.players=players;
        this.nextMovePlayerIndex =  0;
        this.gameState= GameState.INPROGRESS;
        this.moves=new ArrayList<>();
        this.winningStrategies=winningStrategies;

    }

    public Game(Board board, List<Player> players, List<Move> moves, Player player, GameState gameState, int nextMovePlayerIndex, List<WinningStrategy> winningStrategies) {
        this.board = board;
        this.players = players;
        this.moves = moves;
        this.player = player;
        this.gameState = gameState;
        this.nextMovePlayerIndex = nextMovePlayerIndex;
        this.winningStrategies = winningStrategies;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    private List<Move> moves;
private Player player;
private GameState gameState;
private int nextMovePlayerIndex;
private List<WinningStrategy> winningStrategies;

//Builder Class
public static class Builder {
    private List<WinningStrategy> winningStrategies;
    private List<Player> players;
    private int dimensions;

    public Game build(){
        //validation start
        validations();
        return new Game(dimensions,players,winningStrategies);
    }

    private  Builder() {
        this.players = new ArrayList<>();
        this.dimensions = 0;
        this.winningStrategies = new ArrayList<>();

    }
    private void validateBotCount(){
        int count=0;
        for(Player player : players){
            if(player.getPlayerType().equals(PlayerType.Bot)){
                count +=1;
                if(count>1){
                    throw new RuntimeException("Only one Bot is allowed per game");

                }
            }
        }
    }
    public void validateUniqueSymbols(){
        HashSet<Character> symbolSet=new HashSet<>();
        for(Player player : players){
            symbolSet.add(player.getSymbol().getaChar());
        }
        if(symbolSet.size()!=dimensions - 1){
            throw new RuntimeException("Every player should have a unique symbol");
        }
    }

    private void validations() {
        validateBotCount();
        validateUniqueSymbols();
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
        return this;

    }

    public List<Player> getPlayers() {
        return players;
    }

    public Builder setPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    public int getDimensions() {
        return dimensions;
    }

    public Builder setDimensions(int dimensions) {
        this.dimensions = dimensions;
        return this;
    }
}
}

