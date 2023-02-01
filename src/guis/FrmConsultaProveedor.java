package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Distribuidora;
import model.DistribuidoraModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class FrmConsultaProveedor extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblRazonSocial;
	private JLabel lblConsultaDeDistribuidoras;
	private JTextField txtRazon;
	private JButton btnFiltrar;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaProveedor frame = new FrmConsultaProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmConsultaProveedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Proveedores");
		setBounds(100, 100, 833, 457);
		getContentPane().setLayout(null);
		
		lblRazonSocial = new JLabel("Raz\u00F3n Social: ");
		lblRazonSocial.setBounds(51, 78, 97, 14);
		getContentPane().add(lblRazonSocial);
		
		lblConsultaDeDistribuidoras = new JLabel("Consulta de Distribuidoras");
		lblConsultaDeDistribuidoras.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblConsultaDeDistribuidoras.setBounds(237, 11, 341, 60);
		getContentPane().add(lblConsultaDeDistribuidoras);
		
		txtRazon = new JTextField();
		txtRazon.setBounds(164, 75, 184, 20);
		getContentPane().add(txtRazon);
		txtRazon.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setIcon(new ImageIcon(FrmConsultaProveedor.class.getResource("/img/Zoom out.gif")));
		btnFiltrar.setBounds(631, 64, 112, 33);
		getContentPane().add(btnFiltrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 797, 301);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CÓDIGO", "RAZÓN SOCIAL", "RUC", "TIPO", "TELÉFONO", "EMAIL", "DIRECCIÓN"
			}
		));
		scrollPane.setViewportView(table);

	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(e);
		}
	}
	protected void actionPerformedBtnFiltrar(ActionEvent e) {
		String razon = txtRazon.getText();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		DistribuidoraModel model = new DistribuidoraModel();
		List<Distribuidora> lstDistribuidora = model.listaDistribuidoraPorRazonSocialLike(razon);
		
		Object[] fila = null; 
		for(Distribuidora d : lstDistribuidora) {
			fila = new Object[] {d.getIdDistribuidora(), d.getRaSocial(),d.getRuc(),d.getTipo(),d.getTelefono(),d.getEmail(),d.getDireccion()};
			dtm.addRow(fila);
		}
		
		
	}
}
