package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

@SuppressWarnings("serial")
public class MaintainUI extends JFrame {

	private JScrollPane sp;
	private JTable jt;
	private JLabel background;

	public MaintainUI() {
		setTitle("Maintain Product");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\settings.png"));
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\Charlie\\eclipse-workspace\\hci\\src\\view\\Images\\matrix1.png"));
		background.setBounds(0, 0, 671, 389);
		setBounds(100, 100, 687, 428);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		centerFrame();

		String data[][] = { { "10001", "Razer Mouse", "2,500", "1 week" },
				{ "10002", "Razer Keyboard", "4,000", "2 weeks" },
				{ "10003", "Acer Aspire Laptop", "27,000", "1 week" },
				{ "10004", "Google Pixel Phone", "10,500", "1 month" },
				{ "10005", "1TB Flash Drive", "3000", "1 week" }, { "10006", "2TB Flash Drive", "4000", "1 week" },
				{ "10007", "4TB Flash Drive", "6000", "1 week" }, { "10008", "8TB Flash Drive", "10000", "1 week" },
				{ "10009", "16TB Flash Drive", "14000", "1 week" }, { "10010", "Wireless Mouse", "1000", "3 weeks" },
				{ "10011", "Acer Charger", "1500", "2 weeks" }, { "10012", "Iphone X", "90000", "1 year" } };
		String column[] = { "Product ID", "Product Name", "Price", "Warranty" };
		final DefaultTableModel model = new DefaultTableModel(data, column);

		jt = new JTable(model);
		JTableHeader header = jt.getTableHeader();
		header.setBackground(Color.DARK_GRAY);
		header.setForeground(Color.white);
		jt.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jt.setBounds(55, 11, 450, 200);

		sp = new JScrollPane(jt);
		sp.setBounds(50, 11, 571, 166);
		getContentPane().add(sp);
		jt.setSize(450, 200);

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
		btnBack.setBounds(382, 277, 117, 26);
		getContentPane().add(btnBack);

		JButton btnDel = new JButton("Delete");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (jt.getSelectedRow() != -1) {
					// remove selected row from the model
					model.removeRow(jt.getSelectedRow());
				}
			}
		});
		btnDel.setForeground(Color.WHITE);
		btnDel.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDel.setBackground(Color.DARK_GRAY);
		btnDel.setUI(new StyledButtonUI());
		btnDel.setBounds(266, 277, 106, 26);
		getContentPane().add(btnDel);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prodNo = JOptionPane.showInputDialog(getContentPane(), "Product Number:");
				String prodName = JOptionPane.showInputDialog(getContentPane(), "Product Name:");
				String prodPrice = JOptionPane.showInputDialog(getContentPane(), "Product Price:");
				String prodWarrant = JOptionPane.showInputDialog(getContentPane(), "Product Warranty:");

				model.addRow(new Object[] { prodNo, prodName, prodPrice, prodWarrant });

			}
		});
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAdd.setBackground(Color.DARK_GRAY);
		btnAdd.setUI(new StyledButtonUI());
		btnAdd.setBounds(150, 277, 106, 26);
		getContentPane().add(btnAdd);

		getContentPane().add(background);
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
}
