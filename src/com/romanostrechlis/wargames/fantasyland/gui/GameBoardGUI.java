package com.romanostrechlis.wargames.fantasyland.gui;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.TileType;
import com.romanostrechlis.wargames.fantasyland.gui.game.GameWindow;
import com.romanostrechlis.wargames.fantasyland.gui.terrain.hexagon.HexagonWindow;
import com.romanostrechlis.wargames.fantasyland.gui.main.MainWindow;
import com.romanostrechlis.wargames.fantasyland.gui.main.MainWindowListener;
import com.romanostrechlis.wargames.fantasyland.gui.terrain.square.TerrainWindow;
import com.romanostrechlis.wargames.fantasyland.gui.terrain.square.TerrainWindowListener;

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

  public void createMainWindow() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame("FantasyLand - Terrain");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new MainWindowListener(game));
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(addMenuBar());
        MainWindow window = new MainWindow(game, gui, frame);
        frame.add(window);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }

  public void createTerrainWindow() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame("FantasyLand - Terrain");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(addMenuBar());
        if (game.getPreferences().getTilesType().equalsIgnoreCase(TileType.HEXAGONAL.toString())) {
          HexagonWindow window = new HexagonWindow(game, gui);
          frame.add(window);
        } else {
          frame.addWindowListener(new TerrainWindowListener(game));
          TerrainWindow window = new TerrainWindow(game, gui);
          frame.add(window);
        }
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

  public void createHexWindow() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame("FantasyLand - Hexagon");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setJMenuBar(addMenuBar());
        HexagonWindow window = new HexagonWindow(game, gui);
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
