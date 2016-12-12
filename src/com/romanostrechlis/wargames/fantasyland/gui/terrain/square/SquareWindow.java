package com.romanostrechlis.wargames.fantasyland.gui.terrain.square;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;
import com.romanostrechlis.wargames.fantasyland.gui.controls.SidePanel;
import com.romanostrechlis.wargames.fantasyland.gui.terrain.IWindow;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainType;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 * Created by Romanos on 12/9/2016.
 */
public class SquareWindow extends JPanel implements IWindow {

  private Game game;
  private GridBagConstraints gbc;
  private GameBoardGUI gui;

  /**
   * JPanel window for terrain constructor.
   *
   * @param game
   * @param gui
   */
  public SquareWindow(Game game,
                      GameBoardGUI gui) {
    this.game = game;
    this.gui = gui;
  }

  public void draw() {
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    Integer height = game.getBoard().getHeight();
    Integer width = game.getBoard().getWidth();
    this.gbc = new GridBagConstraints();
    drawGrid(height, width, panel);
    this.add(panel);

    JPanel sidePanel = new SidePanel(game);
    this.add(sidePanel);
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

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        gbc.gridx = col; gbc.gridy = row;
        //Border border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
        JButton button = new JButton();
        button.setBorderPainted(true);
        button.setPreferredSize(new Dimension(buttonSize, buttonSize));

        button.setBackground(Color.white);
        SquareActionListener action = new SquareActionListener(game, gui);
        button.addActionListener(action);
        panel.add(button, gbc);
      }
    }
  }
}
