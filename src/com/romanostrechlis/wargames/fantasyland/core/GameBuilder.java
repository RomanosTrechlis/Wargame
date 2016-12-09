package com.romanostrechlis.wargames.fantasyland.core;

import java.lang.reflect.Constructor;

/**
 * Created by Romanos on 9/12/2016.
 */
public class GameBuilder {

  private Integer height;
  private Integer width;
  private Player player1;
  private Player player2;

  public <T> T build(Class<T> buildClass) throws Exception {
    Constructor constructor = buildClass.getConstructor(this.getClass());
    return buildClass.cast(constructor.newInstance(this));
  }

  public GameBuilder boardSize(Integer height, Integer width) {
    this.height = height;
    this.width = width;
    return this;
  }

  public GameBuilder players(Player player1,
                             Player player2) {
    this.player1 = player1;
    this.player2 = player2;
    return this;
  }

  public Integer getHeight() {
    return height;
  }

  public Integer getWidth() {
    return width;
  }
}
