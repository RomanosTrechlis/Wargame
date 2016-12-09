package com.romanostrechlis.wargames.fantasyland.core;

/**
 * Created by Romanos on 9/12/2016.
 */
public class Position {

  private Integer x, y;

  public Position(Integer x,
                  Integer y) {
    this.x = x;
    this.y = y;
  }

  public Integer getX() {
    return x;
  }

  public Integer getY() {
    return y;
  }

  @Override
  public boolean equals(Object obj) {
    Position position = (Position) obj;
    return this.x.compareTo(position.getX()) == 0
           && this.y.compareTo(position.getY()) == 0;
  }

  @Override
  public int hashCode() {
    return this.x.hashCode() + this.y.hashCode();
  }

  @Override
  public String toString() {
    return "Position{" +
           "x=" + x +
           ", y=" + y +
           '}';
  }
}
