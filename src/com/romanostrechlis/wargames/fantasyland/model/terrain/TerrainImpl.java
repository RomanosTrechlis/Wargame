package com.romanostrechlis.wargames.fantasyland.model.terrain;

import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.model.unit.Unit;

import java.awt.*;
import java.util.List;

/**
 * Created by xa86 on 12/12/2016.
 */
public class TerrainImpl implements Terrain {

  public Long Id;

  public List<Position> area;
  public TerrainType type;
  public TerrainCover cover;
  public TerrainSpeed speed;
  public Color tileColor;

  public TerrainImpl(TerrainBuilder builder) {
    Id = builder.getId();
    cover = builder.getCover();
    area = builder.getArea();
    speed = builder.getSpeed();
    type = builder.getType();
    tileColor = builder.getColor();
  }

  public Color getTileColor() {
    return tileColor;
  }

  @Override
  public boolean isPositionCovered(Position position) {
    return getArea().contains(position);
  }

  @Override
  public TerrainCover offersCoverTo(Unit unit) {
    if (getArea().contains(unit.getCurrentPosition())) {
      if (getType().equals(TerrainType.DENSE_FORREST)) {
        return TerrainCover.FULL;
      } else {
        return TerrainCover.THREE_QUARTERS;
      }
    }
    return TerrainCover.NONE;
  }

  @Override
  public TerrainSpeed affectsSpeedOf(Unit unit) {
    return null;
  }

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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    TerrainImpl terrain = (TerrainImpl) o;

    if (area != null ? !area.equals(terrain.area) : terrain.area != null) {
      return false;
    }
    return type == terrain.type;

  }

  @Override
  public int hashCode() {
    return area != null ? area.hashCode() : 0;
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
