package hrgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class HomePanel extends JPanel{
	
	JButton startbtn = new JButton();
	JLabel infoLabel = new JLabel();
	JTextField input = new JTextField();
	JLabel my = new JLabel();
	
	HomePanel(){
		
	}
	
	public void make() {
		startbtn.setText("START!");
//		startbtn.setBorderPainted(false);
		startbtn.setBounds(400, 350, 200, 100);
//		startbtn.setBackground(Color.BLUE);
//		startbtn.setOpaque(true);
		this.add(startbtn);

		Font ffont = new Font("Arial", Font.BOLD, 35);
		infoLabel.setText("참여 인원수를 알려주세요");
		infoLabel.setBounds(320, 50, 400, 100);
		infoLabel.setForeground(Color.BLACK);
		infoLabel.setFont(ffont);
		this.add(infoLabel);
		
		Font font = new Font("Arial", Font.ITALIC, 40);
		input.setText("");
		input.setHorizontalAlignment(JTextField.RIGHT);
		input.setBounds(320, 200, 250, 100);
		input.setForeground(Color.BLACK);
		input.setFont(font);
		this.add(input);
		
		//getter, setter;
		//TextField getInput(){
		//   return input;
		// }
		
		//Integer.parserInt(frame.getInput().getText());
		
		my.setText("명");
		my.setBounds(580, 200, 100, 100);
		my.setForeground(Color.BLACK);
		my.setFont(font);
		this.add(my);
		
		this.setVisible(false); 
		this.setLayout(null);
		this.setBounds(100, 100, 1000, 600);
		this.setBackground(Color.WHITE);
		this.setOpaque(true);
	}
	
	public JButton getStartButton() {
		return startbtn;
	}
	
	public JTextField getInputTextField() {
		return input;
	}

}
