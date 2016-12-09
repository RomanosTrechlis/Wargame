package com.romanostrechlis.wargames.fantasyland.gui;

import com.romanostrechlis.wargames.fantasyland.core.Game;

import java.awt.*;

import javax.swing.*;


/**
 * Created by Romanos on 9/12/2016.
 */
public class GameBoardGUI {

  private Game game;
  private GameBoardGUI gui;

  public GameBoardGUI(Game game) {
    this.game = game;
    gui = this;
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame("FantasyLand");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        TerrainWindow window = new TerrainWindow(game, gui);
        frame.add(window);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }

  public synchronized void notifyInput() {
    notifyAll();
  }
}
