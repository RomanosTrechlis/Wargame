package com.romanostrechlis.wargames.fantasyland.unit;

import com.romanostrechlis.wargames.fantasyland.core.Position;

import java.util.List;

/**
 * Created by Romanos on 9/12/2016.
 */
public class Militia extends UnitBase {

  public Militia(UnitBuilder builder) {
    name = builder.getName();
    meleeAttack = builder.getMeleeAttack();
    meleeDefence = builder.getMeleeDefence();
    rangedAttack = builder.getRangedAttack();
    rangedDefence = builder.getRangedDefence();
    movement = builder.getMovement();
    unitMaxStrength = builder.getUnitMaxStrength();
    unitStrength = builder.getUnitStrength();
  }

  @Override
  public boolean validateMovement(Position endPosition) {
    return false;
  }

  @Override
  public List<Position> drawPath(Position endPosition) {
    return null;
  }

  @Override
  public UnitType getUnitType() {
    return UnitType.MILITIA;
  }

  @Override
  public String toString() {
    return "Militia: " + super.toString();
  }
}
