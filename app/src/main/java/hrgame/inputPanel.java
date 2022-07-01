package hrgame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class inputPanel extends JPanel{
	int d;
	int h;
	
	int n;
	int m;
	
	JButton[] namebtn;
	JButton[] targetbtn;
	
	String name[];
	String[] target;
	
	public int[] branch;
	public static int[] mapping;

	
	inputPanel(){
		
	}
	
	public void makep() {
		this.setVisible(false);
		this.setLayout(null);
		this.setBounds(100, 100, 1000, 600);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
		
		
	}
	
	public void btn() {
		namebtn = new JButton[n];
		targetbtn = new JButton[n];
		for(int i=0;i<n;i++) {
			namebtn[i]= new JButton(name[i]);
			namebtn[i].setBounds(57+i*d, 15, 85, 35);
//			namebtn[i].addActionListener(clk);
			namebtn[i].setVisible(false);
			this.add(namebtn[i]);
			
		}
		
		for(int i=0;i<n;i++) {
			targetbtn[i]= new JButton(target[i]);
			targetbtn[i].setBounds(57+i*d, 550, 85, 35);
			targetbtn[i].setVisible(false);
			this.add(targetbtn[i]);
		}
	}
	
	
//	
//	public JTextField[] gettf() {
//		return nameinput;
//	}
	
	
	public void paintComponent(Graphics g){
//		int i = 600/n;
		d = 800/(n-1);
		h = 530/(m+1);
		
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		
		for(int j =0 ;j<880;j+=d) {
			g2.drawLine(j+100, 50, j+100, 550);
		}
		
		
		if(m!=0) {
			for (int i = 0; i <branch.length; i++) {//y값
		           for(int j=0; j<n-1; j++) {//x값
		              if(branch[i] == j) {
		                 g2.drawLine(j*d+100, i*h+80, (j+1)*d+100, i*h+80);
		                 break;
		              }
		           }
			}
		}
		
		if(Frame.drawLine == true) {
			int height = 0;
			for(int i=0; i<m; i++) {
				 g2.setColor(Color.BLUE);
				 g2.setStroke(new BasicStroke(3));
				 g2.drawLine(d*Frame.draw, h*i, d*Frame.draw,h*i+h); //세로 그리기 
				if(branch[i] == Frame.draw) {
					//오른쪽으로 가기
					g2.drawLine(Frame.draw*d, i*h+h, (Frame.draw+1)*d, i*h+h); //가로 그리기 
					//index 이동 
					Frame.draw++;
				}
				else if(branch[i] == Frame.draw-1) {
					//왼쪽으로 가기
					g2.drawLine((Frame.draw-1)*d, i*h+h, (Frame.draw)*d, i*h+h); //가로 그리기 
					//index 이동
					Frame.draw--;
				}
				if(i==m-1) {
					height = h*i+h;
				}
			}
			
			while(height <= 800) {
				g2.drawLine(d*Frame.draw, height, d*Frame.draw,height+h);
				height+=h;
			}
			Frame.drawLine = false;
		}
	}
	
	public void brancharray() {
		branch = new int[m];
		
		for(int i=0 ; i<m ; i++) {
			branch[i] = (int)(Math.random()*(n)-1);
			
//			System.out.println(branch[i]);
		}
	}
	
	public void map() {
		mapping = new int[n];
		
		for(int i=0 ; i<n ; i++) {
			mapping[i] = i;
			System.out.println("기본 : " + mapping[i]);
		}
		
	}
	
	public void doMapping() {
		for(int k = 0 ; k<m ; k++) {
			
		
			int temp = mapping[branch[k]];
			
			mapping[branch[k]] = mapping[branch[k]+1];
			mapping[branch[k]+1] = temp;
			
			System.out.print("mapping 후의 배열 :");
			for(int i = 0; i < mapping.length; i++) {
				System.out.print(" " + mapping[i]);
			}
			System.out.println();
			
				
			
		}
		
	}
	
	public void setname(String[] name) {
		this.name = name;
	
	}
	public void settarget(String[] target) {
		this.target = target;
	
	}
	
	public int geth() {
		return h;
	}
	
	public int[] getmapp() {
		return mapping;
	}
	
	public void setn(int n) {
		this.n = n;
	}
	 

	    
    public void setm(int m) {
    	this.m = m;
    }
    
    public JButton[] getnBtn() {
		return namebtn;
	}
	

}
