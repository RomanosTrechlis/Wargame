package com.romanostrechlis.wargames.fantasyland.gui.controls;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainType;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 * Created by Romanos on 12/12/2016.
 */
public class SidePanel {
  private void drawControls(Game game,
                            JPanel panel) {
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
