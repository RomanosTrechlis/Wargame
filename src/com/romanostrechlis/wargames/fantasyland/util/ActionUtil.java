package com.romanostrechlis.wargames.fantasyland.util;

import com.romanostrechlis.wargames.fantasyland.core.Board;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.model.terrain.Terrain;
import com.romanostrechlis.wargames.fantasyland.util.TerrainUtil;

import java.awt.*;

import javax.swing.*;

/**
 * Created by xa86 on 12/12/2016.
 */
public class ActionUtil {

  /**
   * Add or remove terrain from board.
   *
   * @param board
   * @param button
   * @throws Exception
   */
  public static void performAction(Board board,
                                   JComponent button) throws Exception {
    Point rv = new Point();
    Integer squareSize = board.getSquareSize();

    Position position = new Position(button.getLocation(rv).x / squareSize,
        button.getLocation(rv).y / squareSize);

    Terrain terrain;
    if (TerrainUtil.isLake(board.getCurrentTerrain())) {
      terrain = TerrainUtil.createLake(position);
    } else if (TerrainUtil.isDenseForrest(board.getCurrentTerrain())) {
      terrain = TerrainUtil.createDenseForrest(position);
    } else {
      terrain = TerrainUtil.createSparseForrest(position);
    }
    System.out.println(terrain.toString());

    if (board.getTerrainList().contains(terrain)) {
      board.getTerrainList().remove(terrain);
      button.setBackground(Color.white);
    } else {
      board.getTerrainList().add(terrain);
      button.setBackground(terrain.getTileColor());
    }
  }
}
