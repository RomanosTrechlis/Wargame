package com.romanostrechlis.wargames.fantasyland.gui.terrain.square;

import com.romanostrechlis.wargames.fantasyland.core.Board;
import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;
import com.romanostrechlis.wargames.fantasyland.model.terrain.Forrest;
import com.romanostrechlis.wargames.fantasyland.model.terrain.Terrain;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainBuilder;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainCover;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainSpeed;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Created by Romanos on 12/9/2016.
 */
public class SquareActionListener implements ActionListener {

  private Game game;
  private GameBoardGUI gui;

  public SquareActionListener(Game game,
                              GameBoardGUI gui) {
    this.game = game;
    this.gui = gui;
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    JButton button = (JButton) actionEvent.getSource();
    try {
      performAction(button);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * Add or remove terrain from board.
   *
   * @param button
   * @throws Exception
   */
  private void performAction(JButton button) throws Exception {
    Point rv = new Point();
    Board board = game.getBoard();
    Integer squareSize = board.getSquareSize();

    Position position = new Position(button.getLocation(rv).x / squareSize,
                                     button.getLocation(rv).y / squareSize);

    Terrain forrest = new TerrainBuilder()
        .addPosition(position)
        .cover(TerrainCover.FULL)
        .speed(TerrainSpeed.HALF)
        .type(TerrainType.DENSE_FORREST)
        .build(Forrest.class);
    System.out.println(forrest.toString());

    if (board.getTerrainList().contains(forrest)) {
      board.getTerrainList().remove(forrest);
      button.setBackground(Color.white);
    } else {
      board.getTerrainList().add(forrest);
      button.setBackground(Color.green);
    }
    gui.notifyInput();
  }

}
