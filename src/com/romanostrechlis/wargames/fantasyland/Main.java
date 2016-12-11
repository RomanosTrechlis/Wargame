package com.romanostrechlis.wargames.fantasyland;

import com.romanostrechlis.wargames.fantasyland.core.Board;
import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.GameBuilder;
import com.romanostrechlis.wargames.fantasyland.core.Player;

/**
 * Created by Romanos on 9/12/2016.
 */
public class Main {

  public static void main(String[] args) throws Exception {
    try {
      initializeGame();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      throw e;
    }
  }

  /**
   * Game initializer.
   *
   * @throws Exception
   */
  private static void initializeGame() throws Exception {
    Player p1 = new Player("Player_1");
    Player p2 = new Player("Player_2");
    Game game = new GameBuilder()
        .boardSize(10, 10)
        .players(p1, p2)
        .squareSize(50)
        .build(Game.class);
    game.runMainWindow();
    //game.runHexWindow();
  }
}
