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
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

@SuppressWarnings("serial")
public class SetAdminUI extends JFrame {
	private static final TexturePaint TEXTURE = makeCheckerTexture();
	private JPanel contentPane;
	private JTextField userTF;
	private JLabel background;
	private JCheckBox MPview, PRview, MPadd, MPedit, MPdelete, SAview, SAadd, SAedit, SAdelete;
	private JButton btnBack, btnSave, btnCancel;
	static Boolean hasAdd = false, hasEdit = false, hasDelete = false;
	private JTextField fullTF;

	public SetAdminUI() {
		setTitle("Set Admin");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\settings.png"));
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\ann.jpg"));
		background.setBounds(0, 0, 656, 388);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.black);
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
		userTF.setBounds(252, 11, 212, 23);
		userTF.setEditable(false);
		contentPane.add(userTF);
		userTF.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(147, 15, 71, 14);
		lblUsername.setForeground(Color.white);
		contentPane.add(lblUsername);

		JLabel lblFullname = new JLabel("Fullname");
		lblFullname.setBounds(147, 49, 71, 14);
		lblFullname.setForeground(Color.white);
		contentPane.add(lblFullname);

		JLabel lblView = new JLabel("View Reports");
		lblView.setBounds(151, 86, 78, 20);
		lblView.setForeground(Color.white);
		contentPane.add(lblView);

		PRview = new JCheckBox("View");
		PRview.setBounds(148, 113, 87, 23);
		PRview.setBackground(Color.black);
		PRview.setEnabled(false);
		contentPane.add(PRview);

		JLabel lblMaintainProduct = new JLabel("Maintain Product");
		lblMaintainProduct.setBounds(252, 86, 110, 20);
		lblMaintainProduct.setForeground(Color.white);
		contentPane.add(lblMaintainProduct);

		MPview = new JCheckBox("View");
		MPview.setBounds(247, 113, 76, 23);
		MPview.setBackground(Color.black);
		MPview.setEnabled(false);
		contentPane.add(MPview);

		MPadd = new JCheckBox("Add");
		MPadd.setBounds(247, 135, 71, 23);
		MPadd.setBackground(Color.black);
		MPadd.setEnabled(false);
		contentPane.add(MPadd);

		MPedit = new JCheckBox("Edit");
		MPedit.setBounds(247, 157, 62, 23);
		MPedit.setBackground(Color.black);
		MPedit.setEnabled(false);
		contentPane.add(MPedit);

		MPdelete = new JCheckBox("Delete");
		MPdelete.setBounds(247, 179, 71, 23);
		MPdelete.setBackground(Color.black);
		MPdelete.setEnabled(false);
		contentPane.add(MPdelete);

		JLabel lblSetAdmin = new JLabel("Set Admin");
		lblSetAdmin.setBounds(402, 86, 78, 20);
		lblSetAdmin.setForeground(Color.white);
		contentPane.add(lblSetAdmin);

		SAview = new JCheckBox("View");
		SAview.setBounds(402, 113, 71, 23);
		SAview.setBackground(Color.black);
		SAview.setEnabled(false);
		contentPane.add(SAview);

		SAadd = new JCheckBox("Add");
		SAadd.setBounds(402, 135, 71, 23);
		SAadd.setBackground(Color.black);
		SAadd.setEnabled(false);
		contentPane.add(SAadd);

		SAedit = new JCheckBox("Edit");
		SAedit.setBounds(402, 157, 62, 23);
		SAedit.setBackground(Color.black);
		SAedit.setEnabled(false);
		contentPane.add(SAedit);

		SAdelete = new JCheckBox("Delete");
		SAdelete.setBounds(402, 179, 97, 23);
		SAdelete.setBackground(Color.black);
		SAdelete.setEnabled(false);
		contentPane.add(SAdelete);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave.setVisible(true);
				btnCancel.setVisible(true);
				enableTF();
				clearTF();
				editCB();
			}
		});
		btnAdd.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAdd.setBackground(Color.DARK_GRAY);
		btnAdd.setForeground(Color.white);
		// customize the button with your own look
		btnAdd.setUI(new StyledButtonUI());
		btnAdd.setBounds(140, 225, 103, 23);
		contentPane.add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave.setVisible(true);
				btnCancel.setVisible(true);
				enableTF();
				editCB();
			}
		});
		btnEdit.setFont(new Font("Calibri", Font.BOLD, 14));
		btnEdit.setBackground(Color.DARK_GRAY);
		btnEdit.setForeground(Color.white);
		// customize the button with your own look
		btnEdit.setUI(new StyledButtonUI());
		btnEdit.setBounds(252, 225, 110, 23);
		contentPane.add(btnEdit);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDelete.setBackground(Color.DARK_GRAY);
		btnDelete.setForeground(Color.white);
		// customize the button with your own look
		btnDelete.setUI(new StyledButtonUI());
		btnDelete.setBounds(370, 225, 110, 23);
		contentPane.add(btnDelete);

		JButton btnFirst = new JButton("<<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTF.setText("Charlie19");
				fullTF.setText("Charles Bermudez");

			}
		});
		btnFirst.setFont(new Font("Calibri", Font.BOLD, 14));
		btnFirst.setBackground(Color.DARK_GRAY);
		btnFirst.setForeground(Color.white);
		// customize the button with your own look
		btnFirst.setUI(new StyledButtonUI());
		btnFirst.setBounds(140, 274, 78, 23);
		contentPane.add(btnFirst);

		JButton btnPrev = new JButton("<");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTF.setText("Charlie19");
				fullTF.setText("Charles Bermudez");
			}
		});
		btnPrev.setFont(new Font("Calibri", Font.BOLD, 14));
		btnPrev.setBackground(Color.DARK_GRAY);
		btnPrev.setForeground(Color.white);
		// customize the button with your own look
		btnPrev.setUI(new StyledButtonUI());
		btnPrev.setBounds(231, 274, 78, 23);
		contentPane.add(btnPrev);

		JButton btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				userTF.setText("WarMachineXX");
				fullTF.setText("Cody Rhodes");

			}
		});
		btnNext.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNext.setBackground(Color.DARK_GRAY);
		btnNext.setForeground(Color.white);
		// customize the button with your own look
		btnNext.setUI(new StyledButtonUI());
		btnNext.setBounds(318, 274, 78, 23);
		contentPane.add(btnNext);

		JButton btnLast = new JButton(">>");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userTF.setText("WarMachineXX");
				fullTF.setText("Cody Rhodes");
			}
		});
		btnLast.setFont(new Font("Calibri", Font.BOLD, 14));
		btnLast.setBackground(Color.DARK_GRAY);
		btnLast.setForeground(Color.white);
		// customize the button with your own look
		btnLast.setUI(new StyledButtonUI());
		btnLast.setBounds(408, 274, 71, 23);
		contentPane.add(btnLast);

		btnBack = new JButton("Back");
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
		btnBack.setBounds(408, 308, 71, 23);
		// 408, 274, 71, 23
		contentPane.add(btnBack);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				disableTF();
				disableCB();
				btnSave.setVisible(false);
				btnCancel.setVisible(false);
			}
		});
		btnSave.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSave.setBackground(Color.DARK_GRAY);
		btnSave.setForeground(Color.white);
		btnSave.setUI(new StyledButtonUI());
		btnSave.setBounds(231, 308, 78, 23);
		btnSave.setVisible(false);
		contentPane.add(btnSave);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				disableTF();
				disableCB();
				display();
				btnSave.setVisible(false);
				btnCancel.setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCancel.setBackground(Color.DARK_GRAY);
		btnCancel.setForeground(Color.white);
		btnCancel.setUI(new StyledButtonUI());
		btnCancel.setBounds(318, 308, 78, 23);
		btnCancel.setVisible(false);
		contentPane.add(btnCancel);

		fullTF = new JTextField() {
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
		fullTF.setEditable(false);
		fullTF.setColumns(10);
		fullTF.setBounds(252, 45, 212, 23);
		contentPane.add(fullTF);
		display();
		contentPane.add(background);
		setVisible(true);
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

	public void enableTF() {
		userTF.setEditable(true);
		fullTF.setEditable(true);
	}

	public void disableTF() {
		userTF.setEditable(false);
		fullTF.setEditable(false);
	}

	public void clearTF() {
		userTF.setText("");
		fullTF.setText("");
	}

	public void display() {
		userTF.setText("Charlie19");
		fullTF.setText("Charles Bermudez");
	}

	public void editCB() {
		PRview.setEnabled(true);
		MPview.setEnabled(true);
		MPadd.setEnabled(true);
		MPedit.setEnabled(true);
		MPdelete.setEnabled(true);
		SAview.setEnabled(true);
		SAadd.setEnabled(true);
		SAedit.setEnabled(true);
		SAdelete.setEnabled(true);
	}

	public void disableCB() {
		PRview.setEnabled(false);
		MPview.setEnabled(false);
		MPadd.setEnabled(false);
		MPedit.setEnabled(false);
		MPdelete.setEnabled(false);
		SAview.setEnabled(false);
		SAadd.setEnabled(false);
		SAedit.setEnabled(false);
		SAdelete.setEnabled(false);
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
