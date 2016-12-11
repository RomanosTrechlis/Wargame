package com.romanostrechlis.wargames.fantasyland.gui.main;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.core.TileType;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Romanos on 12/9/2016.
 */
public class MainWindowListener implements WindowListener {

  private Game game;

  public MainWindowListener(Game game) {
    this.game = game;
  }

  @Override
  public void windowOpened(WindowEvent e) {

  }

  @Override
  public void windowClosing(WindowEvent e) {

  }

  @Override
  public void windowClosed(WindowEvent e) {
    try {
      game.runTerrainWindow();
    } catch (Exception ex) {

    }
  }

  @Override
  public void windowIconified(WindowEvent e) {

  }

  @Override
  public void windowDeiconified(WindowEvent e) {

  }

  @Override
  public void windowActivated(WindowEvent e) {

  }

  @Override
  public void windowDeactivated(WindowEvent e) {

  }
}
