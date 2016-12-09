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
 * Created by xa86 on 9/12/2016.
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
        Window window = new Window(game.getBoard().getHeight(), game.getBoard().getWidth());
        frame.add(window);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
      }
    });
  }

  class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      JButton button = (JButton) e.getSource();
      Point rv = new Point();
      //Piece selection = game.gameBoard.boardArray[button.getLocation(rv).x/100][button.getLocation(rv).y/100];




    }
  }

  public class Window extends JPanel {

    public Window(Integer height, Integer width) {
      setLayout(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
          gbc.gridx = col;
          gbc.gridy = row;
          //Border border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
          Position position = new Position(row, col);
          JButton button = new JButton();
          button.setBorderPainted(true);
          button.setPreferredSize(new Dimension(100, 100));

          if (isOnSpot(position)) {
            button.setBackground(Color.green);
          } else {
            button.setBackground(Color.white);
          }
          MyActionListener mal = new MyActionListener();
          button.addActionListener(mal);
          add(button, gbc);
        }
      }
    }
  }

  public boolean isOnSpot(Position position) {
    for (Terrain terrain : game.getBoard().getTerrainList()) {
      List<Position> area = terrain.getArea();
      if (area.contains(position)) {
        return true;
      }
    }
    return false;
  }
}
