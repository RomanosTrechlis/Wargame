package com.romanostrechlis.wargames.fantasyland.util;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.model.terrain.Terrain;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainBuilder;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainCover;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainImpl;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainSpeed;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainType;

import java.awt.*;
import java.util.List;

/**
 * Created by Romanos on 12/9/2016.
 */
public class TerrainUtil {

  public static boolean isOnSpot(Game game,
                                 Position position) {
    for (Terrain terrain : game.getBoard().getTerrainList()) {
      List<Position> area = terrain.getArea();
      if (area.contains(position)) {
        return true;
      }
    }
    return false;
  }

  public static Terrain createDenseForrest(Position position) throws Exception {
    return new TerrainBuilder()
        .addPosition(position)
        .cover(TerrainCover.FULL)
        .speed(TerrainSpeed.HALF)
        .type(TerrainType.DENSE_FORREST)
        .tileColor(Color.green)
        .build(TerrainImpl.class);
  }

  public static Terrain createSparseForrest(Position position) throws Exception {
    return new TerrainBuilder()
        .addPosition(position)
        .cover(TerrainCover.HALF)
        .speed(TerrainSpeed.HALF)
        .type(TerrainType.SPARSE_FORREST)
        .tileColor(Color.green)
        .build(TerrainImpl.class);
  }

  public static Terrain createLake(Position position) throws Exception {
    return new TerrainBuilder()
        .addPosition(position)
        .cover(TerrainCover.NONE)
        .speed(TerrainSpeed.IMPASSABLE)
        .type(TerrainType.LAKE)
        .tileColor(Color.blue)
        .build(TerrainImpl.class);
  }

  public static boolean isDenseForrest(String terrainType) {
    return terrainType.equals(TerrainType.DENSE_FORREST.toString());
  }

  public static boolean isSparseForrest(String terrainType) {
    return terrainType.equals(TerrainType.SPARSE_FORREST.toString());
  }

  public static boolean isLake(String terrainType) {
    return terrainType.equals(TerrainType.LAKE.toString());
  }

  public static boolean isHill(String terrainType) {
    return terrainType.equals(TerrainType.HILL.toString());
  }

  public static boolean isRocks(String terrainType) {
    return terrainType.equals(TerrainType.ROCKS.toString());
  }

}
