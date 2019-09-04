package com.wudan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class MyFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame window = new MyFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8868\u683C");
		frame.setBounds(100, 100, 520, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 580);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("宋体", Font.PLAIN, 20));
		lblUrl.setBounds(10, 10, 50, 25);
		panel.add(lblUrl);
		
		textField = new JTextField();
		textField.setBounds(65, 10, 200, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u5173\u952E\u5B57");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(10, 60, 60, 25);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 60, 60, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u9875\u6570");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(180, 60, 40, 25);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_2.setBounds(240, 60, 60, 25);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		//模型
		String[] columns = {"书名", "价格", "作者"};
		DefaultTableModel tm = new DefaultTableModel(columns,0);
//		table.getColumnModel().getColumn(0).setMinWidth(50);

		JButton button = new JButton("\u5F00\u59CB");

		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(350, 60, 100, 25);
		panel.add(button);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				String url = textField.getText() + "/" + "?key=" + textField_1.getText() + "&act=input&page_index=" + textField_2.getText();
//				new Spider().start(url);
				tm.setRowCount(0);
				new InsertData().insertmodel(tm);
			}
		});
		
		table = new JTable(tm);
		table.setFont(new Font("宋体", Font.PLAIN, 14));
		table.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setBounds(10, 100, 470, 450);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 110, 480, 460);
		panel.add(scrollPane);
		
	}
}
