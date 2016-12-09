package com.romanostrechlis.wargames.fantasyland.core;

import com.romanostrechlis.wargames.fantasyland.terrain.Terrain;
import com.romanostrechlis.wargames.fantasyland.unit.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xa86 on 9/12/2016.
 */
public class Board {
  private Integer height, width;
  private List<Terrain> terrainList = new ArrayList<>();
  private Player p1;
  private Player p2;
  private Game game;

  public Board(Integer height,
               Integer width,
               Game game) {
    this.height = height;
    this.width = width;
    this.game = game;
  }

  public void addTerrain(Terrain terrain) {
    if (!terrainList.contains(terrain)) {
      terrainList.add(terrain);
    }
  }

  public void setUnit(Player player, Unit unit) {

  }

  public void moveUnit(Unit unit, Position destination) {

  }

  private boolean isInBounds(Position position) {
    return true;
  }

  public Integer getHeight() {
    return height;
  }

  public Integer getWidth() {
    return width;
  }

  public List<Terrain> getTerrainList() {
    return terrainList;
  }
}
