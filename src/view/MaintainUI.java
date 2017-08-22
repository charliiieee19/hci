package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.RenderingHints;
<<<<<<< HEAD
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
=======

import javax.swing.JFrame;
>>>>>>> 7adf33179aed1dc7d8a569f51c1eb7ab8d45dc79
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import view.LoginUI.StyledButtonUI;
<<<<<<< HEAD

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MaintainUI extends JFrame {

	private JScrollPane sp;
	private JTable jt;
	private JLabel background;

	public MaintainUI() {
		setTitle("Maintain Product");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\10.jpg"));
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\10.jpg"));
		background.setBounds(0, 0, 687, 428);
		setBounds(100, 100, 687, 428);
=======

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MaintainUI extends JFrame {

	private JScrollPane sp;
	private JTable jt;

	public MaintainUI() {
		setBounds(100, 100, 567, 366);
>>>>>>> 7adf33179aed1dc7d8a569f51c1eb7ab8d45dc79
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		centerFrame();

		String data[][] = { { "10001", "Razer Mouse", "2,500", "1 week" },
				{ "10002", "Razer Keyboard", "4,000", "2 weeks" },
				{ "10003", "Acer Aspire Laptop", "27,000", "1 week" },
<<<<<<< HEAD
				{ "10004", "Google Pixel Phone", "10,500", "1 month" },
				{ "10005", "1TB Flash Drive", "3000", "1 week" } };
=======
				{ "10004", "Google Pixel Phone", "10,500", "1 month" } };
>>>>>>> 7adf33179aed1dc7d8a569f51c1eb7ab8d45dc79
		String column[] = { "Product ID", "Product Name", "Price", "Warranty" };
		jt = new JTable(data, column);
		jt.setBounds(55, 11, 450, 200);
		sp = new JScrollPane(jt);
<<<<<<< HEAD
		sp.setBounds(50, 11, 571, 238);
		getContentPane().add(sp);
		jt.setSize(450, 200);

=======
		sp.setBounds(50, 11, 450, 200);
		getContentPane().add(sp);
		jt.setSize(450, 200);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAdd.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAdd.setBackground(Color.DARK_GRAY);
		btnAdd.setForeground(Color.white);
		btnAdd.setUI(new StyledButtonUI());
		btnAdd.setBounds(66, 226, 89, 23);
		getContentPane().add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEdit.setFont(new Font("Calibri", Font.BOLD, 14));
		btnEdit.setBackground(Color.DARK_GRAY);
		btnEdit.setForeground(Color.white);
		btnEdit.setUI(new StyledButtonUI());
		btnEdit.setBounds(178, 226, 89, 23);
		getContentPane().add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDelete.setBackground(Color.DARK_GRAY);
		btnDelete.setForeground(Color.white);
		btnDelete.setUI(new StyledButtonUI());
		btnDelete.setBounds(284, 226, 89, 23);
		getContentPane().add(btnDelete);

>>>>>>> 7adf33179aed1dc7d8a569f51c1eb7ab8d45dc79
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainUI();
				dispose();
			}
		});
		btnBack.setFont(new Font("Calibri", Font.BOLD, 14));
		btnBack.setBackground(Color.DARK_GRAY);
		btnBack.setForeground(Color.white);
		btnBack.setUI(new StyledButtonUI());
<<<<<<< HEAD
		btnBack.setBounds(515, 277, 106, 26);
		getContentPane().add(btnBack);

		getContentPane().add(background);
=======
		btnBack.setBounds(392, 226, 89, 23);
		getContentPane().add(btnBack);

>>>>>>> 7adf33179aed1dc7d8a569f51c1eb7ab8d45dc79
		setVisible(true);
	}

	public static void main(String[] args) {
		new MaintainUI();

	}
<<<<<<< HEAD

=======
>>>>>>> 7adf33179aed1dc7d8a569f51c1eb7ab8d45dc79
	private void centerFrame() {

		Dimension windowSize = getSize();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();

		int dx = centerPoint.x - windowSize.width / 2;
		int dy = centerPoint.y - windowSize.height / 2;
		setLocation(dx, dy);
	}
<<<<<<< HEAD

=======
	
>>>>>>> 7adf33179aed1dc7d8a569f51c1eb7ab8d45dc79
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
