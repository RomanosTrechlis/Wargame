package com.romanostrechlis.wargames.fantasyland.util;

import com.romanostrechlis.wargames.fantasyland.core.TileType;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainType;

/**
 * Created by Romanos on 12/12/2016.
 */
public class ComboBoxItems {
  public static String[] tileTypes = {TileType.HEXAGONAL.toString(),
      TileType.SQUARE.toString()};

  public static String[] terrainTypes = {TerrainType.DENSE_FORREST.toString(),
      TerrainType.LAKE.toString(),
      TerrainType.HIGH_GRASS.toString(),
      TerrainType.RIVER.toString()};
}
