/**
* File: P6.java
* Assignment 6
* Login: cs8bcw
**/

/**
* This program allows the user to select a specified shape from the
* combo box and select the specified color by clicking on the desired 
* color of choice. The program with then display the shape and color of
* choice.
**/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;

/**
* init() - Initialize applet
* paint() - Displays colored shape
* itemStateChanged - Called when user selects item from JComboBox,
* calls repaint()
* actionPerformed() - Called when user clicks on the Radio Buttons,
* calls repaint()
**/

/**
* @see java.awt.Color
* @see java.awt.event.ItemListener
**/

public class P6 extends JApplet implements ItemListener, ActionListener
{
	private int x1 = 20, y1 = 100; // Upper left coord
	private int x2 = 500, y2 = 500; // Lower right coord
	private int[] x = {x1, x2, (x1+x2)/2, x1, x2}; // Set of X coordinates
	private int[] y = {y1, y1, (y1+y2)/2, y2, y2}; // Set of Y coordinates
	// Array of Strings
	private String [] shapeNames = {"Arc","Line","Oval","Polygon"};
	private static int shape; // Selected shape
	// JRadioButton references
	private JRadioButton jrbRed, jrbBlue, jrbGreen, jrbYellow;
	private JComboBox<String> shapeComboBox; // Shape combo box reference
	private Color color; // Color reference
	// Shape index
	private final int ARC = 1, LINE = 2, OVAL = 3, POLYGON = 4;
	private final int ARC_ANGLE = 40;	// Constant angle for the Arc shape
	/**
	* Initializes every component in the container and sets the layout
	**/
	public void init()
	{
		// Instantiate JComboBox object
		shapeComboBox = new JComboBox<String>(shapeNames);
		shapeComboBox.setSelectedIndex(-1);
		shapeComboBox.addItemListener(this); // Register listener to JComboBox
		ButtonGroup bGroup = new ButtonGroup(); // Radio button manager
		jrbBlue = new JRadioButton("Blue"); // Instantiate Blue radio button
		jrbBlue.setForeground( Color.BLUE ); // Blue colored text label
		jrbBlue.setBackground( Color.BLACK ); // Black button
		bGroup.add(jrbBlue); // Group for Radio Button
		jrbRed = new JRadioButton("Red"); // Instantiate Red radio button
		jrbRed.setForeground( Color.RED ); // Red colored text label
		jrbRed.setBackground( Color.BLACK ); // Black button
		bGroup.add(jrbRed); // Group for Radio Button
		jrbYellow = new JRadioButton("Yellow"); // Instantiate Yellow radio button
		jrbYellow.setForeground( Color.YELLOW ); // Yellow colored text label
		jrbYellow.setBackground( Color.BLACK ); // Black button
		bGroup.add(jrbYellow); // Group for Radio Button
		jrbGreen = new JRadioButton("Green"); // Instantiate Green radio button
		jrbGreen.setForeground( Color.GREEN ); // Green colored text label
		jrbGreen.setBackground( Color.BLACK ); // Black button
		bGroup.add(jrbGreen); // Group for Radio Button
		setLayout( new FlowLayout() ); // Set FlowLayout manager
		add(jrbRed); // Place radio button on applet
		add(jrbYellow); // Place radio button on applet
		add(jrbBlue); // Place radio button on applet
		add(jrbGreen); // Place radio button on applet
		add(shapeComboBox); // Place combo box on applet
		setBackground( Color.white ); // Applet background white
		jrbBlue.setSelected(true); // Default color for shape
		color = Color.BLUE;	// Default color for shape
		jrbBlue.addActionListener( this ); // Register listener
		jrbRed.addActionListener( this ); // Register listener
		jrbYellow.addActionListener( this ); // Register listener
		jrbGreen.addActionListener( this ); // Register listener
	}
	/**
	* This method paints the selected shape with the selected color
	* 
	* @param g the Graphocs object
	**/
	public void paint( Graphics g )
	{
		super.paint(g);	// Calls its superclass method paint( Graphics g );
		g.drawRect ( x1, y1, x2-x1, y2-y1 ); // Bounding rectangle
		g.setColor( color ); // Radio button choice
		// Display selected shape
		if (shape == ARC)
		{
			g.fillArc(x1, y1, x2-x1, y2-y1, 0, ARC_ANGLE);
			g.fillArc(x1, y1, x2-x1, y2-y1, 90, ARC_ANGLE);
			g.fillArc(x1, y1, x2-x1, y2-y1, 180, ARC_ANGLE);
			g.fillArc(x1, y1, x2-x1, y2-y1, 270, ARC_ANGLE);
		}
		else if (shape == LINE)
			g.drawLine(x1, y1, x2, y2);
		else if (shape == OVAL)
			g.fillOval(x1, y1, x2-x1, y2-y1);
		else if (shape == POLYGON)
			g.fillPolygon(x, y, 5);
	}
	/**
	* This method repaints the new selected shape
	* 
	* @param e the selected shape
	**/
	// itemStateChanged(){}
	public void itemStateChanged( ItemEvent e )
	{
		shape = shapeComboBox.getSelectedIndex() + 1;
		repaint();	// Repaints the Applet
	}
	/**
	* This method repaints the new selected color
	* 
	* @param e the selected color
	**/
	// actionPerformed(){}
	public void actionPerformed( ActionEvent e )
	{
		if(e.getSource() == jrbBlue ) // "Color color;" reference
			color = Color.BLUE;
		else if(e.getSource() == jrbRed ) // "Color color;" reference
			color = Color.RED;
		else if(e.getSource() == jrbYellow ) // "Color color;" reference
			color = Color.YELLOW;
		else if(e.getSource() == jrbGreen ) // "Color color;" reference
			color = Color.GREEN;
		repaint();	// Repaints the Applet
	}
}
