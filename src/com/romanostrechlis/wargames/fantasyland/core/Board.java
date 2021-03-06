package com.romanostrechlis.wargames.fantasyland.core;

import com.romanostrechlis.wargames.fantasyland.model.terrain.Terrain;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainType;
import com.romanostrechlis.wargames.fantasyland.model.unit.Unit;
import com.romanostrechlis.wargames.fantasyland.util.ComboBoxItems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romanos on 9/12/2016.
 */
public class Board {

  private Integer height, width;
  private List<Terrain> terrainList = new ArrayList<>();
  private List<Unit> unitList = new ArrayList<>();
  private Integer squareSize;
  private Player p1;
  private Player p2;
  private Game game;

  private String currentTerrain = ComboBoxItems.terrainTypes[0];

  /**
   * Board constructor
   *
   * @param height
   * @param width
   * @param game
   */
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

  public void addUnit(Unit unit) {
    if (!unitList.contains(unit)) {
      unitList.add(unit);
    }
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

  public List<Unit> getUnitList() {
    return unitList;
  }

  public Integer getSquareSize() {
    return squareSize;
  }

  public void setSquareSize(Integer squareSize) {
    this.squareSize = squareSize;
  }

  public String getCurrentTerrain() {
    return currentTerrain;
  }

  public void setCurrentTerrain(String currentTerrain) {
    this.currentTerrain = currentTerrain;
  }
}
