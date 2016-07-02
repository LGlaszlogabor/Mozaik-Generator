package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MozaikDrawer extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField nField;
	private JTextField xField;
	private JTextField yField;
	private DrawPanel panel;
	
	public MozaikDrawer(){
		getContentPane().setLayout(null);
		
		panel = new DrawPanel();
		panel.setBounds(10, 92, 565, 565);
		getContentPane().add(panel);
		
		nField = new JTextField();
		nField.setBounds(46, 42, 86, 20);
		getContentPane().add(nField);
		nField.setColumns(10);
		
		JLabel lblN = new JLabel("N:");
		lblN.setBounds(26, 44, 23, 17);
		getContentPane().add(lblN);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(171, 45, 17, 14);
		getContentPane().add(lblX);
		
		JLabel lblEmptyFieldPosition = new JLabel("Empty field position(0<=X,Y<2^N):");
		lblEmptyFieldPosition.setBounds(171, 20, 235, 14);
		getContentPane().add(lblEmptyFieldPosition);
		
		xField = new JTextField();
		xField.setBounds(192, 42, 86, 20);
		getContentPane().add(xField);
		xField.setColumns(10);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(288, 45, 17, 14);
		getContentPane().add(lblY);
		
		yField = new JTextField();
		yField.setBounds(307, 42, 86, 20);
		getContentPane().add(yField);
		yField.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(451, 41, 89, 23);
		btnGenerate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(xField.getText().isEmpty() || yField.getText().isEmpty() || nField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please fill all the fields!");
				}else{
					panel.reDraw(Integer.parseInt(xField.getText()), Integer.parseInt(yField.getText()), (int)Math.pow(2, Integer.parseInt(nField.getText())));
					repaint();
				}					
			}
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(btnGenerate);
		setResizable(false);
		setBounds(100,100,600,650);
		setVisible(true);		
	}
}
