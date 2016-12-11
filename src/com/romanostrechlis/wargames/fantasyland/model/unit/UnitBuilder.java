package com.romanostrechlis.wargames.fantasyland.model.unit;

import com.romanostrechlis.wargames.fantasyland.core.Player;

import java.lang.reflect.Constructor;

/**
 * Created by Romanos on 9/12/2016.
 */
public class UnitBuilder {

  private String name;
  private Integer meleeAttack;
  private Integer meleeDefence;
  private Integer rangedAttack;
  private Integer rangedDefence;
  private Integer movement;
  private Integer unitStrength;
  private Integer unitMaxStrength;
  private Player player;
  private Integer cost;

  public <T extends Unit> T build(Class<T> buildClass) throws Exception {
    Constructor constructor = buildClass.getConstructor(this.getClass());
    return buildClass.cast(constructor.newInstance(this));
  }

  public UnitBuilder player(Player player) {
    this.player = player;
    return this;
  }

  public UnitBuilder name(String name) {
    this.name = name;
    return this;
  }

  public UnitBuilder melee(Integer attack,
                           Integer defence) {
    this.meleeAttack = attack;
    this.meleeDefence = defence;
    return this;
  }

  public UnitBuilder ranged(Integer attack,
                            Integer defence) {
    this.rangedAttack = attack;
    this.rangedDefence = defence;
    return this;
  }

  public UnitBuilder move(Integer movement) {
    this.movement = movement;
    return this;
  }

  public UnitBuilder unitStrength(Integer maxStrength,
                                  Integer currentStrength) {
    this.unitMaxStrength = maxStrength;
    this.unitStrength = currentStrength;
    return this;
  }

  public UnitBuilder cost(Integer cost) {
    this.cost = cost;
    return this;
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
}
