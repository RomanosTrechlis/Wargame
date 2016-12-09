package com.romanostrechlis.wargames.fantasyland.gui;

import com.romanostrechlis.wargames.fantasyland.core.Board;
import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.terrain.Forrest;
import com.romanostrechlis.wargames.fantasyland.terrain.Terrain;
import com.romanostrechlis.wargames.fantasyland.terrain.TerrainBuilder;
import com.romanostrechlis.wargames.fantasyland.terrain.TerrainCover;
import com.romanostrechlis.wargames.fantasyland.terrain.TerrainSpeed;
import com.romanostrechlis.wargames.fantasyland.terrain.TerrainType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Created by Romanos on 12/9/2016.
 */
public class TerrainActionListener implements ActionListener {

  private Game game;
  private GameBoardGUI gui;

  public TerrainActionListener(Game game,
                               GameBoardGUI gui) {
    this.game = game;
    this.gui = gui;
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    JButton button = (JButton) actionEvent.getSource();
    Point rv = new Point();
    Board board = game.getBoard();
    Integer squareSize = board.getSquareSize();

    Position position = new Position(button.getLocation(rv).x / squareSize,
                                     button.getLocation(rv).y / squareSize);
    try {
      Terrain forrest = new TerrainBuilder()
          .addPosition(position)
          .cover(TerrainCover.FULL)
          .speed(TerrainSpeed.HALF)
          .type(TerrainType.DENSE_FORREST)
          .build(Forrest.class);
      System.out.println(forrest.toString());
      if (board.getTerrainList().contains(forrest)) {
        board.getTerrainList().remove(forrest);
        button.setBackground(Color.gray);
      } else {
        board.getTerrainList().add(forrest);
        button.setBackground(Color.green);
      }
      gui.notifyInput();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}
