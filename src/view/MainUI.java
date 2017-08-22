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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

import view.LoginUI.StyledButtonUI;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUI extends JFrame {

	private JPanel contentPane;
	private JLabel background;

	public MainUI() {
		setTitle("Main Menu");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\bg.png"));
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\bg.png"));
		background.setBounds(0, 0, 665, 425);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		centerFrame();

		JButton btnMain = new JButton("Maintain Product");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MaintainUI();
				dispose();
			}
		});
		btnMain.setFont(new Font("Calibri", Font.BOLD, 14));
		btnMain.setBackground(Color.DARK_GRAY);
		btnMain.setForeground(Color.white);
		btnMain.setUI(new StyledButtonUI());
		btnMain.setBounds(163, 33, 319, 79);
		contentPane.add(btnMain);

		JButton btnPR = new JButton("Print Reports");
		btnPR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPR.setFont(new Font("Calibri", Font.BOLD, 14));
		btnPR.setBackground(Color.DARK_GRAY);
		btnPR.setForeground(Color.white);
		btnPR.setUI(new StyledButtonUI());
		btnPR.setBounds(163, 123, 319, 79);
		contentPane.add(btnPR);

		JButton btnSetAdmin = new JButton("Set Admin");
		btnSetAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SetAdminUI();
				dispose();
			}
		});
		btnSetAdmin.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSetAdmin.setBackground(Color.DARK_GRAY);
		btnSetAdmin.setForeground(Color.white);
		btnSetAdmin.setUI(new StyledButtonUI());
		btnSetAdmin.setBounds(163, 213, 319, 79);
		contentPane.add(btnSetAdmin);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int dialogButton = JOptionPane.showConfirmDialog(null, "Are you sure to Log out?", "WARNING",
						JOptionPane.YES_NO_OPTION);

				if (dialogButton == JOptionPane.YES_OPTION) {
					new LoginUI();
					dispose();
				} else {
					disableEvents(dialogButton);
				}

			}
		});
		btnLogout.setFont(new Font("Calibri", Font.BOLD, 14));
		btnLogout.setBackground(Color.DARK_GRAY);
		btnLogout.setForeground(Color.white);
		btnLogout.setUI(new StyledButtonUI());
		btnLogout.setBounds(327, 303, 155, 29);
		contentPane.add(btnLogout);

		contentPane.add(background);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainUI();

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
