package com.romanostrechlis.wargames.fantasyland.terrain;

import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.unit.Unit;

/**
 * Created by xa86 on 9/12/2016.
 */
public class Forrest extends TerrainBase {

  public Forrest(TerrainBuilder builder) {
    Id = builder.getId();
    cover = builder.getCover();
    area = builder.getArea();
    speed = builder.getSpeed();
    type = builder.getType();
  }

  @Override
  public boolean isPositionCovered(Position position) {
    return getArea().contains(position);
  }

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

  @Override
  public String toString() {
    return "Forrest: " + super.toString();
  }
}
