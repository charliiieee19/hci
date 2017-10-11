package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.TexturePaint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

@SuppressWarnings("serial")
public class LoginUI extends JFrame {
	private static final TexturePaint TEXTURE = makeCheckerTexture();
	private JPanel contentPane;
	private JTextField userTF;
	private JLabel lblPassword, background;
	private JPasswordField passPF;
	private JButton btnExit;

	public LoginUI() {

		setTitle("Payroll System");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\settings.png"));
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\ZenMate.jpg"));
		background.setBounds(0, 0, 761, 413);
		setTitle("Product Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		centerFrame();

		userTF = new JTextField() {
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}

			@Override
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};

		userTF.setBounds(288, 116, 276, 35);
		contentPane.add(userTF);
		userTF.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel.setBounds(141, 119, 124, 25);
		contentPane.add(lblNewLabel);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 15));
		lblPassword.setForeground(Color.white);
		lblPassword.setBounds(141, 165, 124, 25);
		contentPane.add(lblPassword);

		passPF = new JPasswordField() {
			protected void paintComponent(Graphics g) {
				if (!isOpaque() && getBorder() instanceof RoundedCornerBorder) {
					Graphics2D g2 = (Graphics2D) g.create();
					g2.setPaint(getBackground());
					g2.fill(((RoundedCornerBorder) getBorder()).getBorderShape(0, 0, getWidth() - 1, getHeight() - 1));
					g2.dispose();
				}
				super.paintComponent(g);
			}

			@Override
			public void updateUI() {
				super.updateUI();
				setOpaque(false);
				setBorder(new RoundedCornerBorder());
			}
		};
		passPF.setBounds(288, 162, 276, 35);
		contentPane.add(passPF);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if (userTF.getText().length() == 0 || (passPF.getText().length() == 0)) {
					JOptionPane.showMessageDialog(null, "Please Fill up the fields.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else if (userTF.getText().equals("admin") || (passPF.getText().equals("admin"))) {
					new MainUI();
					dispose();
				} else {

					JOptionPane.showMessageDialog(null, "Wrong username and Password", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
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
				int dialogButton = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Warning",
						JOptionPane.YES_NO_OPTION);

				if (dialogButton == JOptionPane.YES_OPTION) {
					dispose();
				} else {
					disableEvents(dialogButton);
				}
			}
		});
		btnExit.setFont(new Font("Calibri", Font.BOLD, 14));
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setForeground(Color.white);
		btnExit.setUI(new StyledButtonUI());
		btnExit.setBounds(457, 286, 107, 35);
		contentPane.add(btnExit);

		JLabel lblForgotPassword = new JLabel("Forgot Password?");
		lblForgotPassword.setBounds(141, 240, 111, 23);
		lblForgotPassword.setForeground(Color.WHITE);
		lblForgotPassword.setToolTipText("Contact admin 09187654321");
		contentPane.add(lblForgotPassword);

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

	class RoundedCornerBorder extends AbstractBorder {
		private final Color ALPHA_ZERO = new Color(0x0, true);

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			Shape border = getBorderShape(x, y, width - 1, height - 1);
			g2.setPaint(ALPHA_ZERO);
			// Area corner = new Area(border.getBounds2D());
			Area corner = new Area(new Rectangle2D.Double(x, y, width, height));
			corner.subtract(new Area(border));
			g2.fill(corner);

			g2.setPaint(Color.GRAY);
			g2.draw(border);
			g2.dispose();
		}

		public Shape getBorderShape(int x, int y, int w, int h) {
			int r = h; // h / 2;
			return new RoundRectangle2D.Double(x, y, w, h, r, r);
		}

		@Override
		public Insets getBorderInsets(Component c) {
			return new Insets(4, 8, 4, 8);
		}

		@Override
		public Insets getBorderInsets(Component c, Insets insets) {
			insets.set(4, 8, 4, 8);
			return insets;
		}
	}

	private static TexturePaint makeCheckerTexture() {
		int cs = 6;
		int sz = cs * cs;
		BufferedImage img = new BufferedImage(sz, sz, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = img.createGraphics();
		g2.setPaint(new Color(100, 100, 100, 50));
		g2.fillRect(0, 0, sz, sz);
		for (int i = 0; i * cs < sz; i++) {
			for (int j = 0; j * cs < sz; j++) {
				if ((i + j) % 2 == 0) {
					g2.fillRect(i * cs, j * cs, cs, cs);
				}
			}
		}
		g2.dispose();
		return new TexturePaint(img, new Rectangle(sz, sz));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		if (!isOpaque()) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setPaint(TEXTURE);
			g2.fillRect(0, 0, getWidth(), getHeight());
			g2.dispose();
		}
	}
}
