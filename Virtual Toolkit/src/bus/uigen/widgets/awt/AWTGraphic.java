package bus.uigen.widgets.awt;

import java.util.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;

import org.eclipse.swt.events.PaintEvent;

import bus.uigen.widgets.VirtualGraphic;
import bus.uigen.widgets.VirtualGraphicObject;
import bus.uigen.widgets.graphics.VirtualLine;
import bus.uigen.widgets.graphics.VirtualOval;
import bus.uigen.widgets.graphics.VirtualRectangle;


public class AWTGraphic implements VirtualGraphic { 
	
	Graphics g;
	Graphics2D g2;
	
	public AWTGraphic(Graphics graphics)
	{
		g = graphics;
		g2 = (Graphics2D) g;
	}
	
	public AWTGraphic() {
		
	}

	public void drawLine(int x1, int y1, int x2, int y2) {
		g.drawLine(x1,y1,x2,y2);
	}

	
	public void drawOval(int x1, int y1, int width, int height) {
		g.drawOval(x1,y1,width,height);
		Color c = new Color(2,2,2,2);
		g.setColor(c);
	}
	
	
	public void drawRectangle(int x1, int y1, int width, int height) {
		g.drawRect(x1,y1,width,height);
		
	}
	
	public void setColor(float red, float green, float blue, float alpha)
	{
		Color c = new Color(red, green, blue, alpha);
		g.setColor(c);
	}
	

	public void paintControl(PaintEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Graphics getGraphic()
	{
		return g;
	}
	
	public void setGraphic(Graphics test)
	{
		g = test;
	}

	public void setColor(float r, float g, float b) {
		// TODO Auto-generated method stub
		
	}

	public void setColor(int red, int green, int blue) {
		Color c = new Color(red,green,blue);
		g.setColor(c);
		// TODO Auto-generated method stub
		
	}

	public void fill(VirtualGraphicObject vo) {
		vo.fill(g2);		
	}

	public void setLineWidth(int thickness) {
		
		g2.setStroke(new BasicStroke(thickness));
	}

	public void setDashed(int thickness) {
		Stroke dashedStroke = new BasicStroke(thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		g2.setStroke(dashedStroke);
	}

	public void setDotted(int thickness) {
		// TODO Auto-generated method stub
		Stroke dottedStroke = new BasicStroke((float)thickness, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, new float[]{3}, 0.0f);
		g2.setStroke(dottedStroke);
	}

	public void setSolid(int thickness) {
		setLineWidth(thickness);
		
	}

	public void setFont(String fontName, String[] params, int size) {
		if (params.length > 0)
		{
			int paramsInt = 0;
			for (String currentParam: params)
			{
				currentParam = currentParam.toLowerCase();
				if (currentParam.equals("italic"))
					paramsInt+= Font.ITALIC;
				else if (currentParam.equals("bold"))
					paramsInt+= Font.BOLD;
				else if (currentParam.equals("plain"))
					paramsInt+= Font.PLAIN;
				
			}
		
			Font currentFont = new Font(fontName, paramsInt ,size );
			g2.setFont(currentFont);
		
		}
		
		// TODO Auto-generated method stub
		
	}
	public void drawString(String text, int x, int y)
	{
		g2.drawString(text, x, y);
	}
}
