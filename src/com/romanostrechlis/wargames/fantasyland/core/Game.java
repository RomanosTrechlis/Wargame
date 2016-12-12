package com.romanostrechlis.wargames.fantasyland.core;

import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;

/**
 * Created by Romanos on 9/12/2016.
 */
public class Game {

  private Board board;
  private Player p1, p2;
  private GameBoardGUI gui;
  private Integer boardSquareSize;
  private GamePreferences preferences;

  public int turn;

  /**
   * Game constructor
   *
   * @param builder
   */
  public Game(GameBuilder builder) {
    this.preferences = new GamePreferences();
    this.p1 = builder.getPlayer1();
    this.p2 = builder.getPlayer2();
    this.gui = new GameBoardGUI(this);
  }

  public void runMainWindow() throws Exception {
    gui.createMainWindow();
  }

  public void runTerrainWindow() throws Exception {
    this.board = new Board(preferences.getHeight(), preferences.getWidth(), this);
    this.board.setSquareSize(preferences.getTileSize());
    gui.createTerrainWindow();
  }

  public void runGameWindow() {
    gui.createGameWindow();
  }

  public void runHexWindow() {
    gui.createHexWindow();
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

  public Player getCurrentPlayer() {
    if (turn%2 == 0) {
      return getPlayer1();
    }
    return getPlayer2();
  }

  public GamePreferences getPreferences() {
    return preferences;
  }
}
