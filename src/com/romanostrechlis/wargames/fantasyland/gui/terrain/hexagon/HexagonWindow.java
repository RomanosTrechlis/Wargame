package com.romanostrechlis.wargames.fantasyland.gui.terrain.hexagon;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;
import com.romanostrechlis.wargames.fantasyland.gui.controls.SidePanel;
import com.romanostrechlis.wargames.fantasyland.gui.terrain.IWindow;

import java.awt.*;

import javax.swing.*;

/**
 * Created by Romanos on 12/11/2016.
 */
public class HexagonWindow extends JPanel implements IWindow {

  private Game game;
  private GridBagConstraints gbc;
  private HexLayout layout;

  public HexagonWindow(Game game) {
    this.game = game;
  }

  public void draw() {
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    this.setMaximumSize(new Dimension(50, 50));

    JPanel panel = new JPanel();
    Integer height = game.getBoard().getHeight();
    Integer width = game.getBoard().getWidth();
    this.setMinimumSize(new Dimension(width ,height));
    this.layout = new HexLayout(height, width);
    panel.setLayout(layout);
    this.gbc = new GridBagConstraints();
    drawGrid(height, width, panel);
    JScrollPane scrollPane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.add(scrollPane);

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
        Hexagon button = new Hexagon(game);
        button.setPreferredSize(new Dimension(buttonSize, buttonSize));

        button.setBackground(Color.white);
        panel.add(button, gbc);
      }
    }
  }
}
