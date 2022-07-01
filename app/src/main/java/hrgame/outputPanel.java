package hrgame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class outputPanel extends JPanel{
	int u;
	int[] m;
	int h;
	
	String[] result;
	
	JLabel[] re;
	
	outputPanel(){
		

	}
	
	public void outPut() {
		
		this.setVisible(false);
		this.setLayout(null);
		this.setBounds(100, 100, 1000, 600);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
	
		re = new JLabel[u];
		
		for(int i=0; i<u; i++) {
			re[i] = new JLabel();
			re[i].setText(result[i]);
			re[i].setFont(new Font("Arial", Font.ITALIC, 20));
			re[i].setBounds(100, 75+i*h, 300, 100);
			this.add(re[i]);
			System.out.println(result[i]);
		}
		
	}
	
	public void setResult(String[] name, String[] target) {
		for(int i=0;i<u;i++) {
			this.result[i]= name[m[i]] + " --->   " + target[i];
		}
		

	}
	
	public void getu(int n) {
		this.u = n;
		result = new String[u];
	}
	
	public void getmappp(int[] m) {
		this.m = m;
		
	}
	
	public void seth(int h) {
		this.h = h;
	}
	
}
