package com.romanostrechlis.wargames.fantasyland.gui.main;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.GamePreferences;
import com.romanostrechlis.wargames.fantasyland.core.TileType;
import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;
import com.romanostrechlis.wargames.fantasyland.util.StringUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Created by Romanos on 12/11/2016.
 */
public class MainWindow extends JPanel {
  private Game game;
  private GameBoardGUI gui;
  private JFrame frame;

  public MainWindow(Game game,
                    GameBoardGUI gui,
                    JFrame frame) {
    this.frame = frame;
    this.game = game;
    this.gui = gui;
    draw();
  }

  private void draw() {
    frame.setMinimumSize(new Dimension(600, 400));

    JPanel labelPanel = new JPanel();
    JLabel errorLabel = new JLabel();
    labelPanel.add(errorLabel);
    this.add(labelPanel);

    JPanel panel = new JPanel();
    JLabel infoTilesLabel = new JLabel("Choose tile type: ");
    panel.add(infoTilesLabel);

    String comboBoxItems[] = {"",
                              TileType.HEXAGONAL.toString(),
                              TileType.SQUARE.toString()};
    JComboBox comboBox = new JComboBox(comboBoxItems);
    comboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JComboBox combo = (JComboBox)e.getSource();
        String selection = (String)combo.getSelectedItem();
        game.getPreferences().setTilesType(selection);
      }
    });
    panel.add(comboBox);

    JButton startButton = new JButton("Start");
    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (StringUtils.isNotEmptyOrNull(game.getPreferences().getTilesType())) {
          frame.dispose();
        } else {
          errorLabel.setText("You must choose the tile type.");
        }
      }
    });
    panel.add(startButton);
    this.add(panel);
  }
}
