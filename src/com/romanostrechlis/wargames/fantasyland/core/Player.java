package com.romanostrechlis.wargames.fantasyland.core;

import com.romanostrechlis.wargames.fantasyland.model.unit.Unit;

import java.util.List;

/**
 * Created by Romanos on 9/12/2016.
 */
public class Player {

  private String name;

  private List<Unit> units;
  private boolean turn = false;
  private boolean winner = false;
  private boolean playsFirst = false;

  public Player(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
