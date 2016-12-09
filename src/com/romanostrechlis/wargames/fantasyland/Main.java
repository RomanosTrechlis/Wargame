package com.romanostrechlis.wargames.fantasyland;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.GameBuilder;
import com.romanostrechlis.wargames.fantasyland.core.Player;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.terrain.Forrest;
import com.romanostrechlis.wargames.fantasyland.terrain.Terrain;
import com.romanostrechlis.wargames.fantasyland.terrain.TerrainBuilder;
import com.romanostrechlis.wargames.fantasyland.terrain.TerrainCover;
import com.romanostrechlis.wargames.fantasyland.terrain.TerrainSpeed;
import com.romanostrechlis.wargames.fantasyland.terrain.TerrainType;
import com.romanostrechlis.wargames.fantasyland.unit.Militia;
import com.romanostrechlis.wargames.fantasyland.unit.Unit;
import com.romanostrechlis.wargames.fantasyland.unit.UnitBuilder;

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
    Player p1 = new Player();
    Player p2 = new Player();
    Game game = new GameBuilder()
        .boardSize(5, 5)
        .players(p1, p2)
        .build(Game.class);
    game.runTerrainWindow();
  }
}
