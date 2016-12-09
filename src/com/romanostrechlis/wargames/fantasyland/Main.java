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

import java.util.List;

/**
 * Created by Romanos on 9/12/2016.
 */
public class Main {

  public static void main(String[] args) throws Exception {
    try {
      Unit militia = new UnitBuilder().name("test").build(Militia.class);
      Terrain forrest = new TerrainBuilder()
          .addPosition(new Position(0, 0))
          .cover(TerrainCover.FULL)
          .speed(TerrainSpeed.HALF)
          .type(TerrainType.DENSE_FORREST)
          .build(Forrest.class);
      System.out.println(militia.toString());
      System.out.println(forrest.toString());


      Player p1 = new Player();
      Player p2 = new Player();
      Game game = new GameBuilder()
          .boardSize(5, 5)
          .players(p1, p2)
          .build(Game.class);
      List<Terrain> list = game.getBoard().getTerrainList();
      list.add(
          new TerrainBuilder()
              .addPosition(new Position(0, 0))
              .addPosition(new Position(1, 0))
              .cover(TerrainCover.FULL)
              .speed(TerrainSpeed.HALF)
              .type(TerrainType.DENSE_FORREST)
              .build(Forrest.class));
      game.gameLoop();
    }catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      throw e;
    }

  }
}
