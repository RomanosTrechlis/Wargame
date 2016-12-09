package com.romanostrechlis.wargames.fantasyland.core;

import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;

/**
 * Created by xa86 on 9/12/2016.
 */
public class Game {
  private Board board;
  private Player p1, p2;
  public int turn;

  public Game(GameBuilder builder) {
    board = new Board(builder.getHeight(), builder.getWidth(), this);
  }

  public void gameLoop() {
    GameBoardGUI gui = new GameBoardGUI(this);

  }

  public void setPlayers(Player p1,
                         Player p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  public Board getBoard() {
    return board;
  }

  public Player getPlayer1() {
    return p1;
  }

  public Player getPlayer2() {
    return p2;
  }

  public int getTurn() {
    return turn;
  }
}
