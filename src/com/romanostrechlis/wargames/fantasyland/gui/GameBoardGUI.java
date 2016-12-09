package com.romanostrechlis.wargames.fantasyland.gui;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.gui.game.GameWindow;
import com.romanostrechlis.wargames.fantasyland.gui.terrain.TerrainWindow;
import com.romanostrechlis.wargames.fantasyland.gui.terrain.TerrainWindowListener;

import java.awt.*;

import javax.swing.*;


/**
 * Created by Romanos on 9/12/2016.
 */
public class GameBoardGUI {

  private Game game;
  private GameBoardGUI gui;
  private boolean startGameWindow = false;

  public GameBoardGUI(Game game) {
    this.game = game;
    gui = this;
  }

  public void createTerrainWindow() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame("FantasyLand - Terrain");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new TerrainWindowListener(game));
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(addMenuBar());
        TerrainWindow window = new TerrainWindow(game, gui);
        frame.add(window);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }

  public void createGameWindow() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame("FantasyLand - Game");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(addMenuBar());
        GameWindow window = new GameWindow(game, gui);
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

  private JMenuBar addMenuBar() {
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu();
    menu.add("Test");
    menuBar.add(menu);
    return menuBar;
  }
}
