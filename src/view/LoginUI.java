package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import view.SetAdminUI.StyledButtonUI;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField userTF;
	private JLabel lblPassword, background;
	private JPasswordField passPF;
	private JButton btnExit;

	public LoginUI() {

		setTitle("Payroll System");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\ZenMate.jpg"));
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\ZenMate.jpg"));
		background.setBounds(0, 0, 761, 452);
		setTitle("Product Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		centerFrame();

		userTF = new JTextField();
		userTF.setBounds(288, 116, 276, 35);
		contentPane.add(userTF);
		userTF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBounds(141, 116, 124, 25);
		contentPane.add(lblNewLabel);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPassword.setForeground(Color.white);
		lblPassword.setBounds(141, 176, 124, 25);
		contentPane.add(lblPassword);

		passPF = new JPasswordField();
		passPF.setBounds(288, 173, 276, 35);
		contentPane.add(passPF);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainUI();
				dispose();
			}
		});
		btnLogin.setFont(new Font("Calibri", Font.BOLD, 14));
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setForeground(Color.white);
		btnLogin.setUI(new StyledButtonUI());
		btnLogin.setBounds(457, 240, 107, 35);
		contentPane.add(btnLogin);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Calibri", Font.BOLD, 14));
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setForeground(Color.white);
		btnExit.setUI(new StyledButtonUI());
		btnExit.setBounds(457, 286, 107, 35);
		contentPane.add(btnExit);

		contentPane.add(background);
		setVisible(true);

	}

	public static void main(String[] args) {
		new LoginUI();

	}

	private void centerFrame() {

		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();

		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	}
	class StyledButtonUI extends BasicButtonUI {

		@Override
		public void installUI(JComponent c) {
			super.installUI(c);
			AbstractButton button = (AbstractButton) c;
			button.setOpaque(false);
			button.setBorder(new EmptyBorder(5, 15, 5, 15));
		}

		@Override
		public void paint(Graphics g, JComponent c) {
			AbstractButton b = (AbstractButton) c;
			paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
			super.paint(g, c);
		}

		private void paintBackground(Graphics g, JComponent c, int yOffset) {
			Dimension size = c.getSize();
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setColor(c.getBackground().darker());
			g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
			g.setColor(c.getBackground());
			g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
		}
	}
}
