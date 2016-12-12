package com.romanostrechlis.wargames.fantasyland.model.terrain;

import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.model.unit.Unit;

import java.awt.*;
import java.util.List;

/**
 * Created by Romanos on 9/12/2016.
 */
public interface Terrain {

  public boolean isPositionCovered(Position position);

  public TerrainCover offersCoverTo(Unit unit);

  public TerrainSpeed affectsSpeedOf(Unit unit);

  public List<Position> getArea();

  public Color getTileColor();
}
