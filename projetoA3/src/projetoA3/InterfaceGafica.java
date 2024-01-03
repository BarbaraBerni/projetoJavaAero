package projetoA3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class InterfaceGafica {

	private JFrame frame;
	private JTextField idVoo;
	private JLabel lblNewLabel_1;
	private JTextField horaVoo;
	private JLabel lblNewLabel_2;
	private JTextField emprAerea;
	private JLabel lblNewLabel_3;
	private JTextField destVoo;
	private JLabel lblNewLabel_4;
	private JTextField portVoo;
	private JTextField statusVoo;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGafica window = new InterfaceGafica();
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
	public InterfaceGafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 685, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 27, 406, 296);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Voo", "Horario do Voo", "Empresa aerea", "Destino", "Port\u00E3o", "Status do Voo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(91);
		table.getColumnModel().getColumn(5).setPreferredWidth(146);
		
		JLabel lblNewLabel = new JLabel("Id do Voo");
		lblNewLabel.setBounds(30, 27, 104, 14);
		frame.getContentPane().add(lblNewLabel);
		
		idVoo = new JTextField();
		idVoo.setBounds(29, 47, 169, 20);
		frame.getContentPane().add(idVoo);
		idVoo.setColumns(10);
		
		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "Informações do voo\n" + idVoo.getText() + "\n Horario: \n" + horaVoo.getText() + "\n Empresa: \n" + emprAerea.getText() + "\n Destino: \n" + destVoo.getText() + "\n Portão: \n" + portVoo.getText() + "\n Status do Voo: \n" + statusVoo.getText());
				
			}
		});
		btnNewButton.setBounds(30, 358, 114, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Horario do voo");
		lblNewLabel_1.setBounds(30, 78, 168, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		horaVoo = new JTextField();
		horaVoo.setBounds(30, 96, 168, 20);
		frame.getContentPane().add(horaVoo);
		horaVoo.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Empresa aerea");
		lblNewLabel_2.setBounds(30, 127, 168, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		emprAerea = new JTextField();
		emprAerea.setBounds(30, 151, 168, 20);
		frame.getContentPane().add(emprAerea);
		emprAerea.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Destino");
		lblNewLabel_3.setBounds(30, 182, 168, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		destVoo = new JTextField();
		destVoo.setBounds(30, 207, 168, 20);
		frame.getContentPane().add(destVoo);
		destVoo.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Portão");
		lblNewLabel_4.setBounds(30, 238, 168, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		portVoo = new JTextField();
		portVoo.setBounds(30, 260, 168, 20);
		frame.getContentPane().add(portVoo);
		portVoo.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Avançar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.addRow(new Object [] {Integer.parseInt(idVoo.getText()), horaVoo.getText(), emprAerea.getText(), destVoo.getText(), portVoo.getText(), statusVoo.getText()});
			}
		});
		btnNewButton_1.setBounds(30, 420, 114, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remover");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int i = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				if (i>=0) {
					model.removeRow(i);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Erro ao excluir");
				}
			}
		});
		btnNewButton_2.setBounds(30, 388, 114, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_5 = new JLabel("Status do voo");
		lblNewLabel_5.setBounds(30, 291, 97, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		statusVoo = new JTextField();
		statusVoo.setBounds(30, 316, 168, 20);
		frame.getContentPane().add(statusVoo);
		statusVoo.setColumns(10);
	}
}
