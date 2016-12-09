package com.romanostrechlis.wargames.fantasyland.terrain;

import com.romanostrechlis.wargames.fantasyland.core.Position;

import java.util.List;

/**
 * Created by Romanos on 9/12/2016.
 */
public abstract class TerrainBase implements Terrain {

  public Long Id;

  public List<Position> area;
  public TerrainType type;
  public TerrainCover cover;
  public TerrainSpeed speed;

  public List<Position> getArea() {
    return area;
  }

  public Long getId() {
    return Id;
  }

  public TerrainType getType() {
    return type;
  }

  public void setType(TerrainType type) {
    this.type = type;
  }

  public TerrainCover getCover() {
    return cover;
  }

  public void setCover(TerrainCover cover) {
    this.cover = cover;
  }

  public TerrainSpeed getSpeed() {
    return speed;
  }

  public void setSpeed(TerrainSpeed speed) {
    this.speed = speed;
  }

  @Override
  public String toString() {
    return "Id=" + Id +
        ", area=" + area +
        ", type=" + type +
        ", cover=" + cover +
        ", speed=" + speed;
  }
}
