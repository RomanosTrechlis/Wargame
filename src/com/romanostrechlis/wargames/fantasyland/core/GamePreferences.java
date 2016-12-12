package com.romanostrechlis.wargames.fantasyland.core;

/**
 * Created by Romanos on 12/11/2016.
 */
public class GamePreferences {
  private String tilesType = TileType.HEXAGONAL.toString();
  private Integer width = 5;
  private Integer height = 5;
  private Integer tileSize = 100;

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getTileSize() {
    return tileSize;
  }

  public void setTileSize(Integer tileSize) {
    this.tileSize = tileSize;
  }

  public String getTilesType() {
    return tilesType;
  }

  public void setTilesType(String tilesType) {
    this.tilesType = tilesType;
  }
}
