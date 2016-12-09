package com.romanostrechlis.wargames.fantasyland.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Created by Romanos on 12/9/2016.
 */
public class TerrainActionListener implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    JButton button = (JButton) e.getSource();
    Point rv = new Point();
    //Piece selection = game.gameBoard.boardArray[button.getLocation(rv).x/100][button.getLocation(rv).y/100];
  }

}
