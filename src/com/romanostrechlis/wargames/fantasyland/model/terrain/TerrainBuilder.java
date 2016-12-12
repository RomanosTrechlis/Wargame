package com.romanostrechlis.wargames.fantasyland.model.terrain;

import com.romanostrechlis.wargames.fantasyland.core.Position;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romanos on 9/12/2016.
 */
public class TerrainBuilder {

  private List<Position> area = new ArrayList<>();
  private TerrainType type;
  private TerrainCover cover;
  private TerrainSpeed speed;
  private Long Id;
  private Color color;

  public <T extends Terrain> T build(Class<T> buildClass) throws Exception {
    this.Id = System.currentTimeMillis();
    Constructor constructor = buildClass.getConstructor(this.getClass());
    return buildClass.cast(constructor.newInstance(this));
  }

  public TerrainBuilder tileColor(Color color) {
    this.color = color;
    return this;
  }

  public TerrainBuilder cover(TerrainCover cover) {
    this.cover = cover;
    return this;
  }

  public TerrainBuilder speed(TerrainSpeed speed) {
    this.speed = speed;
    return this;
  }

  public TerrainBuilder type(TerrainType type) {
    this.type = type;
    return this;
  }

  public TerrainBuilder area(List<Position> area) {
    this.area = area;
    return this;
  }

  public TerrainBuilder addPosition(Position position) {
    if (!area.contains(position)) {
      area.add(position);
    }
    return this;
  }

  public Color getColor() {
    return color;
  }

  public List<Position> getArea() {
    return area;
  }

  public TerrainType getType() {
    return type;
  }

  public TerrainCover getCover() {
    return cover;
  }

  public TerrainSpeed getSpeed() {
    return speed;
  }

  public Long getId() {
    return Id;
  }
}
