package com.romanostrechlis.wargames.fantasyland.gui;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.Position;
import com.romanostrechlis.wargames.fantasyland.terrain.Terrain;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;


/**
 * Created by Romanos on 9/12/2016.
 */
public class GameBoardGUI {
  private Game game;

  public GameBoardGUI(Game game) {
    this.game = game;
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame("FantasyLand");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        TerrainWindow window = new TerrainWindow(game);
        frame.add(window);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }
}
