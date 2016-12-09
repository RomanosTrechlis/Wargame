package com.romanostrechlis.wargames.fantasyland.gui.terrain;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;
import com.romanostrechlis.wargames.fantasyland.terrain.TerrainType;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 * Created by Romanos on 12/9/2016.
 */
public class TerrainWindow extends JPanel {

  private Game game;
  private GridBagConstraints gbc;
  private GameBoardGUI gui;

  /**
   * JPanel window for terrain constructor.
   *
   * @param game
   * @param gui
   */
  public TerrainWindow(Game game,
                       GameBoardGUI gui) {
    this.game = game;
    this.gui = gui;
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    Integer height = game.getBoard().getHeight();
    Integer width = game.getBoard().getWidth();
    this.gbc = new GridBagConstraints();
    drawGrid(height, width, panel);
    this.add(panel);
    JPanel newPanel = new JPanel();
    drawControls(newPanel);
    this.add(newPanel);
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
        gbc.gridx = row; gbc.gridy = col;
        //Border border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
        JButton button = new JButton();
        button.setBorderPainted(true);
        button.setPreferredSize(new Dimension(buttonSize, buttonSize));

        button.setBackground(Color.white);
        TerrainActionListener action = new TerrainActionListener(game, gui);
        button.addActionListener(action);
        panel.add(button, gbc);
      }
    }
  }

  private void drawControls(JPanel panel) {
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    JLabel label = new JLabel();
    label.setText("Player: " + game.getCurrentPlayer().getName());
    label.setBorder(new MatteBorder(0, 1, 0, 0, Color.GRAY));
    label.setAlignmentX(Component.LEFT_ALIGNMENT);
    panel.add(label);

    String comboBoxItems[] = {TerrainType.DENSE_FORREST.toString(),
                              TerrainType.LAKE.toString(),
                              TerrainType.HIGH_GRASS.toString(),
                              TerrainType.RIVER.toString()};
    JComboBox comboBox = new JComboBox(comboBoxItems);
    comboBox.setEditable(false);
    comboBox.setBorder(new MatteBorder(0, 1, 0, 0, Color.GRAY));
    comboBox.setAlignmentX(Component.LEFT_ALIGNMENT);
    // todo: add listener to combo box
    panel.add(comboBox);
  }
}
