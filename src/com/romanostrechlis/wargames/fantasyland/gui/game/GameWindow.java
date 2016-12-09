package com.romanostrechlis.wargames.fantasyland.gui.game;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;
import com.romanostrechlis.wargames.fantasyland.gui.terrain.TerrainActionListener;
import com.romanostrechlis.wargames.fantasyland.util.TerrainUtil;

import java.awt.*;

import javax.swing.*;

/**
 * Created by Romanos on 12/9/2016.
 */
public class GameWindow extends JPanel {

  private Game game;
  private GridBagConstraints gbc;
  private GameBoardGUI gui;

  /**
   * JPanel window for terrain constructor.
   *
   * @param game
   * @param gui
   */
  public GameWindow(Game game,
                    GameBoardGUI gui) {
    this.game = game;
    this.gui = gui;

    setLayout(new GridBagLayout());
    Integer height = game.getBoard().getHeight();
    Integer width = game.getBoard().getWidth();
    this.gbc = new GridBagConstraints();
    drawGrid(height, width);
  }

  /**
   * Draws a grid of buttons on the window.
   *
   * @param height
   * @param width
   */
  private void drawGrid(Integer height,
                        Integer width) {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        gbc.gridx = row;
        gbc.gridy = col;
        //Border border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
        Position position = new Position(row, col);
        JButton button = new JButton();
        button.setBorderPainted(true);
        button.setPreferredSize(new Dimension(100, 100));

        if (TerrainUtil.isOnSpot(game, position)) {
          button.setBackground(Color.green);
        } else {
          button.setBackground(Color.white);
        }
        TerrainActionListener action = new TerrainActionListener(game, gui);
        button.addActionListener(action);
        add(button, gbc);
      }
    }
  }
}
