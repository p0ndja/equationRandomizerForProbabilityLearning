package main.palapon2545.smd36.myClassRoom.chairRandom;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class MainSM extends JFrame implements ActionListener {
	private static final long serialVersionUID = 561811103320831759L;
	private JPanel contentPane;
	public final String title = "main.palapon2545.smd36.myClassRoom.chairRandom.MainSM.java";
	public final int width = 1073;
	public final int height = 631;
	public final Color bgcolor = Color.BLACK;
	public final String randomButton = "\u0E2A\u0E38\u0E48\u0E21";
	public final String closeButton = "\u0E2D\u0E2D\u0E01";
	public final String mainText = "\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21\u0E2A\u0E38\u0E48\u0E21\u0E17\u0E35\u0E48\u0E19\u0E31\u0E48\u0E07 [5/1]";
	public final String subText = "Chair Random Position";
	private JTextField txtA;
	public JLabel lblAaaa = new JLabel();
	public JLabel lblZero = new JLabel("");
	public static long one = 0;
	public static long zero = 0;
	public ArrayList<String> temp = new ArrayList<String>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSM frame = new MainSM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void announce(String m) {
		System.out.print(m + String.format("%n"));
	}

	public MainSM() {
		announce("running program . . .");
		setTitle(title);
		announce("set title = " + title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width, height);
		announce("set gui border");
		announce(" width = " + width);
		announce(" height = " + height);
		announce("set background = " + bgcolor.toString());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(bgcolor);
		setContentPane(contentPane);

		JButton btnRandom = new JButton(randomButton);
		btnRandom.setFont(new Font("Cordia New", Font.BOLD, 56));
		btnRandom.setBounds(936, 510, 111, 71);
		btnRandom.addActionListener(this);
		btnRandom.setBackground(Color.GREEN);
		btnRandom.setForeground(Color.WHITE);
		contentPane.setLayout(null);
		contentPane.add(btnRandom);
		announce("add button '" + randomButton + "'");
		contentPane.setLayout(null);

		txtA = new JTextField();
		txtA.setText("a");
		txtA.setBounds(10, 11, 1037, 328);
		contentPane.add(txtA);
		txtA.setColumns(10);

		lblAaaa.setForeground(Color.YELLOW);
		lblAaaa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAaaa.setBounds(109, 429, 172, 71);
		contentPane.add(lblAaaa);
		
		lblZero.setForeground(Color.GREEN);
		lblZero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblZero.setBounds(109, 510, 172, 71);
		contentPane.add(lblZero);

		announce("add button '" + closeButton + "'");
		announce("add text '" + mainText + "'");
		announce("add text '" + subText + "'");
		announce("");
	}

	public void actionPerformed(ActionEvent e) {
		randomMize();
		one = 0;
		zero = 0;
	}

	public void randomMize() {
		for (int a = 0; a < 10000; a++) {
			Random rand = new Random();
			
			int i = ((rand.nextInt(9484)) + 1) + 3387;
			int o = ((rand.nextInt(9484)) + 1) + 3387;
			
			temp.add(i + "x" + o);
			if (((i * o) / 1000) > 1000)
				one++;
			else
				zero++;
			announce(i + "x" + o);
			announce(one + "," + zero);
			announce("");
		}
		txtA.setText(temp.toString());
		long percentOne = ((one * 100) / (one + zero));
		long percentZero = ((zero * 100) / (one + zero));
		lblAaaa.setText( percentOne + "%");
		lblZero.setText( percentZero + "%");
	}
}