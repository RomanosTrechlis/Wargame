package com.romanostrechlis.wargames.fantasyland.gui.terrain.square;

import com.romanostrechlis.wargames.fantasyland.core.Game;
import com.romanostrechlis.wargames.fantasyland.gui.GameBoardGUI;
import com.romanostrechlis.wargames.fantasyland.util.ActionUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Created by Romanos on 12/9/2016.
 */
public class SquareActionListener implements ActionListener {

  private Game game;
  private GameBoardGUI gui;

  public SquareActionListener(Game game,
                              GameBoardGUI gui) {
    this.game = game;
    this.gui = gui;
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    JButton button = (JButton) actionEvent.getSource();
    try {
      ActionUtil.performAction(game, button);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
