package com.romanostrechlis.wargames.fantasyland.gui.terrain.hexagon;

import com.romanostrechlis.wargames.fantasyland.core.Board;
import com.romanostrechlis.wargames.fantasyland.util.ActionUtil;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

/**
 * Created by Romanos on 12/11/2016.
 */
public class Hexagon extends JComponent implements MouseListener {

  Polygon hexagonalShape;
  Board board;

  public Hexagon(Board board) {
    super();
    hexagonalShape = getHexPolygon();
    setOpaque(false);
    addMouseListener(this);
    this.board = board;
  }

  /**
   * Generates the buttons Hexagonal shape
   *
   * @return Polygon with the buttons hexagonal shape.
   */
  private Polygon getHexPolygon() {
    Polygon hex = new Polygon();
    int w = getWidth() - 1;
    int h = getHeight() - 1;
    int r = (int) (h * .25);

    hex.addPoint(w / 2, 0);
    hex.addPoint(w, r);
    hex.addPoint(w, h - r);
    hex.addPoint(w / 2, h);
    hex.addPoint(0, h - r);
    hex.addPoint(0, r);

    return hex;
  }

  @Override
  public boolean contains(Point p) {
    return hexagonalShape.contains(p);
  }

  @Override
  public boolean contains(int x, int y) {
    return hexagonalShape.contains(x, y);
  }

  @Override
  public void setSize(Dimension d) {
    super.setSize(d);
    hexagonalShape = getHexPolygon();
  }

  @Override
  public void setSize(int w, int h) {
    super.setSize(w, h);
    hexagonalShape = getHexPolygon();
  }

  @Override
  public void setBounds(int x, int y, int width, int height) {
    super.setBounds(x, y, width, height);
    hexagonalShape = getHexPolygon();
  }

  @Override
  public void setBounds(Rectangle r) {
    super.setBounds(r);
    hexagonalShape = getHexPolygon();
  }

  @Override
  protected void paintComponent(Graphics g) {
    g.setColor(getBackground());
    g.fillPolygon(hexagonalShape);
    g.setColor(getForeground());
    g.drawPolygon(hexagonalShape);
  }

  protected void paintBorder(Graphics g) {
    // no border
  }

  @Override
  public void mouseClicked(MouseEvent mouseEvent) {
    Hexagon hex = (Hexagon) mouseEvent.getSource();
    try {
      ActionUtil.performAction(board, hex);
    } catch (Exception e) {

    }
  }

  @Override
  public void mousePressed(MouseEvent e) {}

  @Override
  public void mouseReleased(MouseEvent e) {}

  @Override
  public void mouseEntered(MouseEvent e) {}

  @Override
  public void mouseExited(MouseEvent e) {}
}
