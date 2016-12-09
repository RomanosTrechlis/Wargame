package com.romanostrechlis.wargames.fantasyland.gui;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.util.TerrainUtil;

import java.awt.*;

import javax.swing.*;

/**
 * Created by Romanos on 12/9/2016.
 */
public class TerrainWindow extends JPanel {

  public TerrainWindow(Game game,
                       GameBoardGUI gui) {
    setLayout(new GridBagLayout());
    Integer height = game.getBoard().getHeight();
    Integer width = game.getBoard().getWidth();
    GridBagConstraints gbc = new GridBagConstraints();
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        gbc.gridx = col;
        gbc.gridy = row;
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
