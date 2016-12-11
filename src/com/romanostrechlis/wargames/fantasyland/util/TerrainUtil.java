package com.romanostrechlis.wargames.fantasyland.util;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.model.terrain.Terrain;

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

}
