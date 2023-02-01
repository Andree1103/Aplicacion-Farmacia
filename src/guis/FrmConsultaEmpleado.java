package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Empleado;
import model.EmpleadoModel;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class FrmConsultaEmpleado extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblConsultaDeEmpleados;
	private JLabel lblNombre;
	private JTextField txtNombre;
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
					FrmConsultaEmpleado frame = new FrmConsultaEmpleado();
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
	public FrmConsultaEmpleado() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Empleados");
		setBounds(100, 100, 780, 450);
		getContentPane().setLayout(null);
		
		lblConsultaDeEmpleados = new JLabel("Consulta de Empleados");
		lblConsultaDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblConsultaDeEmpleados.setBounds(219, 11, 341, 60);
		getContentPane().add(lblConsultaDeEmpleados);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(32, 83, 73, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(115, 80, 190, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setIcon(new ImageIcon(FrmConsultaEmpleado.class.getResource("/img/Zoom out.gif")));
		btnFiltrar.setBounds(554, 80, 100, 25);
		getContentPane().add(btnFiltrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 145, 754, 264);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CÓDIGO", "NOMBRES", "APELLIDOS", "DNI", "TELÉFONO", "EMAIL", "DIRECCIÓN"
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
		String nombre = txtNombre.getText();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		EmpleadoModel model = new EmpleadoModel();
		List<Empleado> lstEmpleado = model.listaEmpleadoPorNombreLike(nombre);
		
		Object[] fila = null; 
		for(Empleado e1 : lstEmpleado) {
			fila = new Object[] {e1.getCodEmpleado(),e1.getNombres(),e1.getApellidos(),e1.getdNI(),e1.getTelefono(),e1.getEmail(),e1.getDireccion()};
			dtm.addRow(fila);
		}
	}
}
