package robot;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import javax.swing.JTable;
import java.awt.Font;

import java.awt.Toolkit;

public class prostaKin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	String[] columnNames = { "", "", "", "" };
	public JTable table;

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("serial")
	public prostaKin(final kontrolerDialog k) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(prostaKin.class.getResource("/robot/ikony/licz.png")));
		

		setTitle("Kinematyka prosta (Denavit-Hartenberg)");
		setBounds(1000, 500, 360, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		//table = new JTable(out(tab), columnNames);
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setBorder(null);
		table.setFont(new Font("Arial", Font.PLAIN, 18));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"", "", "", ""
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Double.class, Double.class, Double.class, Double.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(35);
		table.setAlignmentX(JTable.CENTER_ALIGNMENT);
		table.setAlignmentY(JTable.CENTER_ALIGNMENT);
		contentPanel.add(table, BorderLayout.CENTER);
		table.setDragEnabled(false);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

	}

}
