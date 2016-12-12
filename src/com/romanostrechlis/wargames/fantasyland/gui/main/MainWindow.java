package com.romanostrechlis.wargames.fantasyland.gui.main;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.GamePreferences;
import com.romanostrechlis.wargames.fantasyland.core.TileType;
import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;
import com.romanostrechlis.wargames.fantasyland.util.ComboBoxItems;
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
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    JComboBox tileType = drawTileTypeCheckBox();
    JTextField width = drawBoardSizeWidth();
    JTextField height = drawBoardSizeHeight();
    JTextField tileSize = drawTileSizeTextBox();
    drawButtons(tileType, width, height, tileSize);
  }

  private JComboBox drawTileTypeCheckBox() {
    JPanel panel = new JPanel();
    JLabel infoTilesLabel = new JLabel("Choose tile type: ");
    panel.add(infoTilesLabel);
    JComboBox comboBox = new JComboBox(ComboBoxItems.tileTypes);
    panel.add(comboBox);
    this.add(panel);
    return comboBox;
  }

  private JTextField drawBoardSizeWidth() {
    JPanel panelWidth = new JPanel();
    panelWidth.setLayout(new BoxLayout(panelWidth, BoxLayout.X_AXIS));
    JLabel widthLabel = new JLabel("Board Width: ");
    JTextField width = new JTextField("10");
    panelWidth.add(widthLabel);
    panelWidth.add(width);
    this.add(panelWidth);
    return width;
  }

  private JTextField drawBoardSizeHeight() {
    JPanel panelHeight = new JPanel();
    panelHeight.setLayout(new BoxLayout(panelHeight, BoxLayout.X_AXIS));
    JLabel heightLabel = new JLabel("Board Height: ");
    JTextField height = new JTextField("10");
    panelHeight.add(heightLabel);
    panelHeight.add(height);
    this.add(panelHeight);
    return height;
  }

  private JTextField drawTileSizeTextBox() {
    JPanel panelTileSize = new JPanel();
    panelTileSize.setLayout(new BoxLayout(panelTileSize, BoxLayout.X_AXIS));
    JLabel tileSizeLabel = new JLabel("Tile Size: ");
    JTextField tileSize = new JTextField("50");
    panelTileSize.add(tileSizeLabel);
    panelTileSize.add(tileSize);
    this.add(panelTileSize);
    return tileSize;
  }

  private void drawButtons(JComboBox tileType,
                           JTextField width,
                           JTextField height,
                           JTextField tileSize) {
    JPanel panel = new JPanel();
    JButton startButton = new JButton("Start");
    startButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        game.getPreferences().setTilesType(String.valueOf(tileType.getSelectedItem()));
        game.getPreferences().setTileSize(Integer.valueOf(
            StringUtils.nvl(tileSize.getText(), game.getPreferences().getTileSize().toString())));
        game.getPreferences().setWidth(Integer.valueOf(
            StringUtils.nvl(width.getText(), game.getPreferences().getWidth().toString())));
        game.getPreferences().setHeight(Integer.valueOf(
            StringUtils.nvl(height.getText(), game.getPreferences().getHeight().toString())));
        frame.dispose();
      }
    });
    panel.add(startButton);
    this.add(panel);
  }
}
