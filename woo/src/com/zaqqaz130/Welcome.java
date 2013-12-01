package com.zaqqaz130;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JTextPane;
import java.awt.Font;

public class Welcome extends JFrame {

	private JPanel contentPane;
	private final JButton btnCake = new JButton("Cake");
	private JTextField txtYourTextHere;
	private JTextField txtNothing;
	private Numbers nums = new Numbers();

	public int theSum, userGuess;
	public String numone;
	public String numtwo;

	private JTextField txtGuess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setTitle("Maths Test Thing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnWoo = new JMenu("Woo");
		menuBar.add(mnWoo);

		JMenu mnPizza = new JMenu("Pizza");
		mnWoo.add(mnPizza);

		JMenu mnPepperoni = new JMenu("Pepperoni");
		mnPizza.add(mnPepperoni);

		final JCheckBoxMenuItem chckbxmntmHehehe = new JCheckBoxMenuItem(
				"Hehehe");
		chckbxmntmHehehe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (chckbxmntmHehehe.isSelected()) {
					contentPane.setBackground(Color.gray);
				} else {
					contentPane.setBackground(Color.ORANGE);
				}
			}
		});

		mnPepperoni.add(chckbxmntmHehehe);

		JMenuItem mntmHello = new JMenuItem("Hello");
		menuBar.add(mntmHello);

		JMenu mnDoo = new JMenu("Doo");
		menuBar.add(mnDoo);

		JMenuItem mntmDooo = new JMenuItem("dooo");
		mnDoo.add(mntmDooo);

		JMenu mnWooo = new JMenu("wooo");
		mnDoo.add(mnWooo);

		JMenuItem mntmVooo = new JMenuItem("vooo");
		mnWooo.add(mntmVooo);

		JMenuItem mntmLooo = new JMenuItem("looo");
		mnWooo.add(mntmLooo);

		JMenuItem mntmBooo = new JMenuItem("booo");
		mnDoo.add(mntmBooo);

		JMenuItem mntmNice = new JMenuItem("Nice");
		menuBar.add(mntmNice);

		JMenuItem mntmCookies = new JMenuItem("Cookies");
		menuBar.add(mntmCookies);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		btnCake.setBounds(12, 11, 69, 25);
		btnCake.addActionListener(new ActionListener() {
			// Button Click
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Clicky\n");
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCake);

		Button button = new Button("New button");
		button.setBounds(12, 42, 80, 23);
		button.addActionListener(new ActionListener() {
			// Button Click
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.BLUE);
			}
		});
		contentPane.add(button);

		JLabel lblHelloThere = new JLabel("Hello There:");
		lblHelloThere.setBounds(99, 16, 86, 15);
		contentPane.add(lblHelloThere);

		final JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(99, 211, 335, 15);
		contentPane.add(lblOutput);

		txtYourTextHere = new JTextField();
		txtYourTextHere.setBounds(188, 14, 114, 19);
		txtYourTextHere.setText("Your Text Here");
		contentPane.add(txtYourTextHere);
		txtYourTextHere.setColumns(10);
		// SAY HI BUTTON
		final JButton btnSayHi = new JButton("Say Hi");
		btnSayHi.addActionListener(new ActionListener() {
			// BUTTON CLICK
			public void actionPerformed(ActionEvent e) {
				String name = txtYourTextHere.getText();
				txtNothing.setText(txtYourTextHere.getText()
						+ "\n cookies |  |  " + name);
			}
		});
		btnSayHi.setBounds(308, 11, 80, 25);
		contentPane.add(btnSayHi);

		txtNothing = new JTextField();
		txtNothing.setEditable(false);
		txtNothing.setHorizontalAlignment(SwingConstants.LEFT);
		txtNothing.setText("nothing");
		txtNothing.setBounds(12, 71, 80, 166);
		contentPane.add(txtNothing);
		txtNothing.setColumns(10);

		final JLabel lblOne = new JLabel("One");
		lblOne.setBounds(212, 71, 70, 15);
		contentPane.add(lblOne);

		final JLabel lblTwo = new JLabel("Two");
		lblTwo.setBounds(212, 108, 70, 15);
		contentPane.add(lblTwo);

		final String incorrect = "Incorrect!, try again";
		// BUTTON ANSWER CLICK
		JButton btnAnswer = new JButton("Answer");
		btnAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theSum = nums.numSum;
				userGuess = Integer.valueOf(txtGuess.getText());

				if (userGuess == theSum) {
					System.out.println("Correct!\n " + numone + " + " + numtwo
							+ " = " + theSum);
					lblOutput.setText("Correct! " + numone + " + " + numtwo
							+ " = " + theSum);

					nums.genNums();
					numone = String.valueOf(nums.numOne);
					numtwo = String.valueOf(nums.numTwo);

					lblOne.setText(numone);
					lblTwo.setText(numtwo);
					
					txtGuess.setText("");
					txtGuess.grabFocus();
				} else {
					System.out.println("Incorrect!, try again");
					lblOutput.setText(incorrect);
				}
			}
		});
		btnAnswer.setBounds(99, 167, 95, 25);
		contentPane.add(btnAnswer);

		JLabel lblOperator = new JLabel("+");
		lblOperator.setFont(new Font("Dialog", Font.BOLD, 20));
		lblOperator.setBounds(212, 90, 70, 15);
		contentPane.add(lblOperator);
		// BUTTON START CLICK
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nums.genNums();
				numone = String.valueOf(nums.numOne);
				numtwo = String.valueOf(nums.numTwo);

				lblOne.setText(numone);
				lblTwo.setText(numtwo);
			}
		});
		btnStart.setBounds(99, 103, 95, 25);
		contentPane.add(btnStart);

		JTextPane muffle = new JTextPane();
		muffle.setText("Answer");
		muffle.setBounds(99, 65, 81, 21);
		contentPane.add(muffle);

		txtGuess = new JTextField();
		txtGuess.setText("Guess");
		txtGuess.setBounds(93, 144, 114, 19);
		contentPane.add(txtGuess);
		txtGuess.setColumns(10);
	}
}
