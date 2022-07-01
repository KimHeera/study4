package hrgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame{
	int n;
	int m=0;
	int d;
	
	static boolean drawLine =false;
	
	static int draw=0;
	JTextField[] nameinput;
	JTextField[] targetinput;
	
	JButton[] namebtn;
	JButton[] targetbtn;
	
	JTextField branchinput = new JTextField();
	JTextField choose = new JTextField();
	
	JLabel basicLabel = new JLabel();
	JLabel mLabel = new JLabel();
	JButton undo = new JButton();
	JButton branchbtn = new JButton();
	JButton outbtn = new JButton();
	JButton click = new JButton();
	
	HomePanel basicPanel;
	inputPanel playPanel;
	outputPanel resultPanel;
	CharBtn bt;
	JPanel backPanel = new JPanel();
	
	static public String[] name;	
	static public String[] target;	
	
	String[] result;
	
	int flag=0;
	
	
	Frame(){
		
	}

	
	public void makeFrame() {
		Font font = new Font("Arial", Font.ITALIC, 40);
		basicLabel.setText("GHOST LEG GAME");
		basicLabel.setBounds(400, 0, 400, 100);
		basicLabel.setForeground(Color.BLACK);
		basicLabel.setFont(font);
		backPanel.add(basicLabel);
		
		basicPanel = new HomePanel();
		basicPanel.make();
		basicPanel.setVisible(true);
		
		
		basicPanel.getStartButton().addActionListener(clk);
		
		backPanel.add(basicPanel);
		
		playPanel = new inputPanel();
		
		
		
	

		resultPanel = new outputPanel();
		
		undo.setBounds(1000, 50, 100, 50);
		undo.setText("사다리 타기 시작");
		undo.addActionListener(clk);
		undo.setVisible(false);
		backPanel.add(undo);
		
		choose.setText("");
		choose.setBounds(100, 50, 100, 50);
		choose.setVisible(false);
		backPanel.add(choose);
		
		branchinput.setText("");
		branchinput.setBounds(100, 50, 50, 50);
		branchinput.setVisible(false);
		backPanel.add(branchinput);
		
		mLabel.setText("개");
		mLabel.setBounds(150, 70, 20, 20);
		mLabel.setFont(new Font("Arial", Font.ITALIC, 20));
		mLabel.setForeground(Color.BLACK);
		mLabel.setVisible(false);
		backPanel.add(mLabel);
		
		
		outbtn.setBounds(900, 50, 100, 50);
		outbtn.setText("전체 결과보기");
		outbtn.addActionListener(clk);
		outbtn.setVisible(false);
		backPanel.add(outbtn);
		
		branchbtn.setBounds(180, 50, 100, 50);
		branchbtn.setText("입력하기");
		branchbtn.addActionListener(clk);
		branchbtn.setVisible(false);
		backPanel.add(branchbtn);
		
		
		click.setBounds(200, 50, 50, 50);
		click.setText("선택");
		click.addActionListener(clk);
		click.setVisible(false);
		backPanel.add(click);
		
		backPanel.setLayout(null);
		backPanel.setBounds(0, 0, 1200, 800); //프레임 초기 사이즈
		backPanel.setBackground(Color.lightGray);
		backPanel.setVisible(true); //프레임이 보이도록
		this.add(backPanel);
//메인 프레임		
		this.setLayout(null);
		this.setTitle("사다리타기"); //타이틀
		this.setSize(1200, 800); //프레임 초기 사이즈
		this.setLocationRelativeTo(null);
		this.setResizable(true); //프레임크기 조절 가능
		this.setVisible(true); //프레임이 보이도록
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 활성
	}
	
	ActionListener clk = new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		String cmd = e.getActionCommand();
    		
    		
    		
    		switch(cmd) {
    		case "START!":{
    			undo.setVisible(true);
    			branchbtn.setVisible(true);
    			branchinput.setVisible(true);
    			mLabel.setVisible(true);
    			
    			n = Integer.parseInt(basicPanel.getInputTextField().getText());
    			playPanel.setn(n);
    			
        		if(n!=1) {
//        			System.out.println("참여 인원 : " + n);
            		
            		playPanel.makep();
            		playPanel.setVisible(true);
            		
            		
            		d = 800/(n-1);
            		
            		
            		
            		nameinput =  new JTextField[n];
            		targetinput =  new JTextField[n];
            		
//            		System.out.println(n);
            		
            		for(int i=0;i<n;i++) {
            			nameinput[i]= new JTextField("");
            			nameinput[i].setBounds(57+i*d, 15, 85, 35);
  
            			playPanel.add(nameinput[i]);
            			System.out.println(1);
            		}
            		
            		for(int i=0;i<n;i++) {
            			targetinput[i]= new JTextField("");
            			targetinput[i].setBounds(57+i*d, 550, 85, 35);
            			playPanel.add(targetinput[i]);
            		}
            		
            		playPanel.repaint();


            		basicPanel.setVisible(false);
            		backPanel.add(playPanel);
            		
            		break;
        		}
    			break;
    		}
    		case "입력하기":{
    			outbtn.setVisible(false);

    			
    			name = new String[n];
    			target = new String[n];
    			
    			
    			for(int i=0;i<n;i++) {
        			name[i]= nameinput[i].getText();
        			
        		}
    			
    			playPanel.setname(name);
    			
    			for(int i=0;i<n;i++) {
    				target[i]= targetinput[i].getText();
        		}
    			
    			playPanel.settarget(target);
    			
    			for(int i=0;i<n;i++) {
    				nameinput[i].setVisible(false);
    				targetinput[i].setVisible(false);
    			}
    		
    			
    			playPanel.btn();
    			
    			
    			for(int i=0;i<n;i++) {
    				playPanel.namebtn[i].setVisible(true);
    				playPanel.targetbtn[i].setVisible(true);
    			}
    			
    			
    			for(int r =0 ; r<n ; r++) {
    				if(cmd.equals(nameinput[r].getText())) {
    					
    				}
    			}
    	    		
    			
    			
    			m =Integer.parseInt(Frame.this.branchinput.getText());
    			playPanel.setm(m);
    			
    			playPanel.brancharray();
    			playPanel.repaint();
    			
    			break;
    
    		}
    		case "사다리 타기 시작" :{
    			branchbtn.setVisible(false);
    			branchinput.setVisible(false);
    			mLabel.setVisible(false);
    			outbtn.setVisible(true);
    			choose.setVisible(true);
    			click.setVisible(true);
    			playPanel.map();
    			
    			playPanel.doMapping();
    			break;
    		}
    		case "전체 결과보기" :{
    			
    			if(flag==0) {
    				undo.setVisible(false);
        			branchbtn.setVisible(false);
        			branchinput.setVisible(false);
        			mLabel.setVisible(false);
    				flag=1;
    				
    				resultPanel.getu(n);
    				resultPanel.getmappp(playPanel.getmapp());
    				resultPanel.setResult(name, target);
    				
    				
    				resultPanel.seth(playPanel.geth());
    				resultPanel.outPut();
    				
    				
    				
        			resultPanel.setVisible(true);
        			playPanel.setVisible(false);
            		backPanel.add(resultPanel);
            		
            		break;
    				
    			}
    			
    			if(flag==1) {
    				undo.setVisible(true);
        			branchbtn.setVisible(true);
        			branchinput.setVisible(true);
        			mLabel.setVisible(true);
    				flag=0;
    				resultPanel.setVisible(false);
        			playPanel.setVisible(true);
        			
        			break;
    			}
    		}
    		
    		case "선택" :{
    			drawLine = true;
    			draw=0;
    			String s = choose.getText();
    			for(int k = 0 ; k<n ; k++) {
    				if(!s.equals(name[k])) {
    					draw++;
    					break;
    				}
    			}
    			
    			playPanel.repaint();
    			
    			System.out.println(draw);
    		}
    			
    		
    		
    		}
    
    	
    		
    	}
    	
    };
    
//    public JButton act() {
//    	for(int u=0;u<n;u++) {
//    		playPanel.getnBtn()[u].addActionListener(clk);
//    		return playPanel.getnBtn()[u];
//    	}
	
        		
//    }
    
    public String[] getname() {
    	return name;
    }
    public String[] gettarget() {
    	return target;
    }
    
   
    
    
}
