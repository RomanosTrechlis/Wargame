package com.romanostrechlis.wargames.fantasyland.gui.terrain.square;

import com.romanostrechlis.wargames.fantasyland.core.Game;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Romanos on 12/9/2016.
 */
public class TerrainWindowListener implements WindowListener {

  private Game game;

  public TerrainWindowListener(Game game) {
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
    //game.runGameWindow();
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
