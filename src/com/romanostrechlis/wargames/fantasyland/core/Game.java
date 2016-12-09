package com.romanostrechlis.wargames.fantasyland.core;

import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;

import java.awt.*;

/**
 * Created by Romanos on 9/12/2016.
 */
public class Game {

  private Board board;
  private Player p1, p2;
  public int turn;
  private boolean terrainClosed = false;
  private GameBoardGUI gui;

  public Game(GameBuilder builder) {
    this.board = new Board(builder.getHeight(), builder.getWidth(), this);
    this.p1 = builder.getPlayer1();
    this.p2 = builder.getPlayer2();
    this.gui = new GameBoardGUI(this);
  }

  public void runTerrainWindow() throws Exception {
    gui.createTerrainWindow();
  }

  public void runGameWindow() {
    gui.createGameWindow();
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
