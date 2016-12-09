package com.romanostrechlis.wargames.fantasyland.unit;

import com.romanostrechlis.wargames.fantasyland.core.Player;
import com.romanostrechlis.wargames.fantasyland.core.Position;

import java.util.List;

/**
 * Created by Romanos on 9/12/2016.
 */
public interface Unit {

  public boolean validateMovement(Position endPosition);

  public List<Position> drawPath(Position endPosition);

  public boolean isBloodied();

  public Player getPlayer();

  public Position getCurrentPosition();

  public void setCurrentPosition(Position currentPosition);

  public void setUnitStrength(Integer unitStrength);

  public String getName();

  public Integer getMeleeAttack();

  public Integer getMeleeDefence();

  public Integer getRangedAttack();

  public Integer getRangedDefence();

  public Integer getMovement();

  public Integer getUnitStrength();

  public Integer getUnitMaxStrength();

  public UnitType getUnitType();

}
