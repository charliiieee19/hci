package view;

import javax.swing.*;

public class TableExample {
	JFrame f;

	TableExample() {
		f = new JFrame();
		String data[][] = { { "10001", "Razer Mouse", "2,500", "1 week" },
				{ "10002", "Razer Keyboard", "4,000", "2 weeks" }, { "10003", "Acer Aspire Laptop", "27,000", "1 week" },
				{ "10004", "Google Pixel Phone", "10,500", "1 month" }};
		String column[] = { "Product ID", "Product Name", "Price", "Warranty" };
		JTable jt = new JTable(data, column);
		jt.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(jt);
		f.add(sp);
		f.setSize(300, 400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new TableExample();
	}
}