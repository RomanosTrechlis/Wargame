package com.romanostrechlis.wargames.fantasyland.gui.controls;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.model.terrain.TerrainType;
import com.romanostrechlis.wargames.fantasyland.util.ComboBoxItems;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.MatteBorder;

/**
 * Created by Romanos on 12/12/2016.
 */
public class SidePanel extends JPanel {

  private Game game;

  public SidePanel(Game game) {
    this.game = game;
    drawControls();
  }

  private void drawControls() {
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setAlignmentX(Component.LEFT_ALIGNMENT);
    JLabel label = new JLabel();
    label.setText("Player: " + game.getCurrentPlayer().getName());
    label.setBorder(new MatteBorder(0, 1, 0, 0, Color.GRAY));
    label.setAlignmentX(Component.LEFT_ALIGNMENT);
    this.add(label);

    JComboBox comboBox = new JComboBox(ComboBoxItems.terrainTypes);
    comboBox.setEditable(false);
    comboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox) e.getSource();
        game.getBoard().setCurrentTerrain((String) cb.getSelectedItem());
      }
    });
    this.add(comboBox);

    JPanel panel = new JPanel();
    this.add(panel);
  }

}
