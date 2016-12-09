package com.romanostrechlis.wargames.fantasyland.unit;

import com.romanostrechlis.wargames.fantasyland.core.Player;

/**
 * Created by Romanos on 9/12/2016.
 */
public interface IUnitBuilder {

  public <T extends Unit> T build(Class<T> buildClass) throws Exception;

  public IUnitBuilder player(Player player);

  public IUnitBuilder name(String name);

  public IUnitBuilder melee(Integer attack, Integer defence);
  public IUnitBuilder ranged(Integer attack, Integer defence);
  public IUnitBuilder move(Integer movement);

  public IUnitBuilder unitStrength(Integer maxStrength, Integer currentStrength);

  public IUnitBuilder cost(Integer cost);
}
