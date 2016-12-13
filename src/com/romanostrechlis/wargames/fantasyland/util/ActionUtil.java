package com.romanostrechlis.wargames.fantasyland.util;

import com.romanostrechlis.wargames.fantasyland.core.Board;
import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.gui.terrain.hexagon.Hexagon;
import com.romanostrechlis.wargames.fantasyland.model.terrain.Terrain;
import com.romanostrechlis.wargames.fantasyland.util.TerrainUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by xa86 on 12/12/2016.
 */
public class ActionUtil {

  /**
   * Add or remove terrain from board.
   *
   * @param game
   * @param button
   * @throws Exception
   */
  public static void performAction(Game game,
                                   JComponent button) throws Exception {
    Board board = game.getBoard();
    Hexagon hex = null;
    if (game.getPreferences().getTilesType().equals("HEXAGONAL")) {
      hex = (Hexagon) button;
    }

    Point rv = new Point();
    Integer squareSize = board.getSquareSize();
    Position position = new Position(button.getLocation(rv).x / squareSize,
        button.getLocation(rv).y / squareSize);

    Terrain terrain = getTerrain(board, position);
    System.out.println(terrain.toString());

    if (board.getTerrainList().contains(terrain)) {
      board.getTerrainList().remove(terrain);
      if (terrain.getTilePath() != null) {
        hex.removeIcon();
      } else {
        button.setBackground(Color.white);
      }
    } else {
      board.getTerrainList().add(terrain);
      if (terrain.getTilePath() != null) {
        hex.drawIcon(ImageIO.read(new File(terrain.getTilePath())));
      } else {
        button.setBackground(terrain.getTileColor());
      }
    }
  }

  private static Terrain getTerrain(Board board,
                                    Position position) throws Exception {
    Terrain terrain;
    if (TerrainUtil.isLake(board.getCurrentTerrain())) {
      terrain = TerrainUtil.createLake(position);
    } else if (TerrainUtil.isDenseForrest(board.getCurrentTerrain())) {
      terrain = TerrainUtil.createDenseForrest(position);
    } else if (TerrainUtil.isHill(board.getCurrentTerrain())) {
      terrain = TerrainUtil.createHill(position);
    } else if (TerrainUtil.isRocks(board.getCurrentTerrain())) {
      terrain = TerrainUtil.createRocks(position);
    } else if (TerrainUtil.isDesert(board.getCurrentTerrain())) {
      terrain = TerrainUtil.createDesert(position);
    } else if (TerrainUtil.isMountain(board.getCurrentTerrain())) {
      terrain = TerrainUtil.createMountain(position);
    } else {
      terrain = TerrainUtil.createSparseForrest(position);
    }
    return terrain;
  }
}
