package com.romanostrechlis.wargames.fantasyland.unit;

import com.romanostrechlis.wargames.fantasyland.core.Player;
import com.romanostrechlis.wargames.fantasyland.core.Position;

/**
 * Created by Romanos on 9/12/2016.
 */
public abstract class UnitBase implements Unit {

  private Position currentPosition;
  private Player player;

  public String name = "";
  public Integer meleeAttack = -1;
  public Integer meleeDefence = -1;
  public Integer rangedAttack = -1;
  public Integer rangedDefence = -1;
  public Integer movement = -1;
  public Integer unitStrength = -1;
  public Integer unitMaxStrength = -1;

  public Integer cost = -1;

  public boolean isBloodied() {
    if ((this.unitStrength / this.unitMaxStrength) >= 0.5) {
      return false;
    }
    return true;
  }

  public Player getPlayer() {
    return player;
  }

  public Position getCurrentPosition() {
    return currentPosition;
  }

  public void setCurrentPosition(Position currentPosition) {
    this.currentPosition = currentPosition;
  }

  public void setUnitStrength(Integer unitStrength) {
    this.unitStrength = unitStrength;
  }

  public String getName() {
    return name;
  }

  public Integer getMeleeAttack() {
    return meleeAttack;
  }

  public Integer getMeleeDefence() {
    return meleeDefence;
  }

  public Integer getRangedAttack() {
    return rangedAttack;
  }

  public Integer getRangedDefence() {
    return rangedDefence;
  }

  public Integer getMovement() {
    return movement;
  }

  public Integer getUnitStrength() {
    return unitStrength;
  }

  public Integer getUnitMaxStrength() {
    return unitMaxStrength;
  }

  @Override
  public String toString() {
    return "name='" + name + '\'' +
        ", meleeAttack=" + meleeAttack +
        ", meleeDefence=" + meleeDefence +
        ", rangedAttack=" + rangedAttack +
        ", rangedDefence=" + rangedDefence +
        ", movement=" + movement +
        ", unitStrength=" + unitStrength +
        ", unitMaxStrength=" + unitMaxStrength +
        ", cost=" + cost;
  }
}
