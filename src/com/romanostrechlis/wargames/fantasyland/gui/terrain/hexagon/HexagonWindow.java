package com.romanostrechlis.wargames.fantasyland.gui.terrain.hexagon;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;

import java.awt.*;

import javax.swing.*;

/**
 * Created by Romanos on 12/11/2016.
 */
public class HexagonWindow extends JPanel {

  private Game game;
  private GridBagConstraints gbc;
  private GameBoardGUI gui;
  private HexLayout layout;

  public HexagonWindow(Game game,
                       GameBoardGUI gui) {
    this.gui = gui;
    this.game = game;
    draw();
  }

  private void draw() {
    JPanel panel = new JPanel();
    Integer height = game.getBoard().getHeight();
    Integer width = game.getBoard().getWidth();
    this.layout = new HexLayout(height, width);

    panel.setLayout(layout);
    this.gbc = new GridBagConstraints();
    drawGrid(height, width, panel);
    this.add(panel);
  }

  /**
   * Draws a grid of buttons on the window.
   *
   * @param height
   * @param width
   */
  private void drawGrid(Integer height,
                        Integer width,
                        JPanel panel) {
    int buttonSize = game.getBoard().getSquareSize();

    for (int row = 0; row < width; row++) {
      for (int col = 0; col < height; col++) {
        gbc.gridx = row; gbc.gridy = col;
        Hexagon button = new Hexagon(game.getBoard());
        button.setPreferredSize(new Dimension(buttonSize, buttonSize));

        button.setBackground(Color.white);
        panel.add(button, gbc);
      }
    }
  }
}
