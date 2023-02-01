package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Empleado;
import model.EmpleadoModel;
import util.Validaciones;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class FrmMantenimientoEmpleado extends JInternalFrame implements MouseListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMantenimientoDeEmpleados;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lbldni;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblDireccion;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	
	private int idSeleccionado = -1; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoEmpleado frame = new FrmMantenimientoEmpleado();
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
	public FrmMantenimientoEmpleado() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Mantenimiento de Empleados");
		setBounds(100, 100, 798, 458);
		getContentPane().setLayout(null);
		
		lblMantenimientoDeEmpleados = new JLabel("Mantenimiento de Empleados");
		lblMantenimientoDeEmpleados.setOpaque(true);
		lblMantenimientoDeEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeEmpleados.setForeground(Color.WHITE);
		lblMantenimientoDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoDeEmpleados.setBackground(Color.BLACK);
		lblMantenimientoDeEmpleados.setBounds(0, 0, 858, 59);
		getContentPane().add(lblMantenimientoDeEmpleados);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 762, 234);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CÓDIGO", "NOMBRES", "APELLIDOS", "DNI", "TELÉFONO", "EMAIL", "DIRECCIÓN"
			}
		));
		scrollPane.setViewportView(table);
		
		lista();
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPane.setViewportView(table);
		
		lblNombre = new JLabel("Nombres: ");
		lblNombre.setBounds(20, 78, 74, 14);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellidos:");
		lblApellido.setBounds(20, 115, 89, 14);
		getContentPane().add(lblApellido);
		
		lbldni = new JLabel("DNI:");
		lbldni.setBounds(20, 148, 46, 14);
		getContentPane().add(lbldni);
		
		lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(287, 78, 62, 14);
		getContentPane().add(lblTelefono);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(287, 115, 46, 14);
		getContentPane().add(lblEmail);
		
		lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(287, 148, 89, 14);
		getContentPane().add(lblDireccion);
		
		txtNombres = new JTextField();
		txtNombres.setOpaque(false);
		txtNombres.setColumns(10);
		txtNombres.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNombres.setBounds(79, 75, 175, 20);
		getContentPane().add(txtNombres);
		
		txtApellidos = new JTextField();
		txtApellidos.setOpaque(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtApellidos.setBounds(79, 112, 175, 20);
		getContentPane().add(txtApellidos);
		
		txtDni = new JTextField();
		txtDni.setOpaque(false);
		txtDni.setColumns(10);
		txtDni.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDni.setBounds(79, 145, 175, 20);
		getContentPane().add(txtDni);
		
		txtTelefono = new JTextField();
		txtTelefono.setOpaque(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtTelefono.setBounds(357, 75, 175, 20);
		getContentPane().add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setOpaque(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEmail.setBounds(357, 112, 175, 20);
		getContentPane().add(txtEmail);
		
		txtDireccion = new JTextField();
		txtDireccion.setOpaque(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDireccion.setBounds(357, 145, 175, 20);
		getContentPane().add(txtDireccion);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon(FrmMantenimientoEmpleado.class.getResource("/img/Accept.gif")));
		btnRegistrar.setBounds(614, 70, 121, 30);
		getContentPane().add(btnRegistrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoEmpleado.class.getResource("/img/Delete.gif")));
		btnEliminar.setBounds(614, 111, 121, 27);
		getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(FrmMantenimientoEmpleado.class.getResource("/img/Edit.gif")));
		btnActualizar.setBounds(614, 149, 121, 23);
		getContentPane().add(btnActualizar);

	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTable(MouseEvent e) {
		busca();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		inserta();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		elimina();
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualiza();
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}
	
	void limpiarCajarTexto() {
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtDireccion.setText("");
		txtNombres.requestFocus();
	}
	
	/*-----------------------------LISTAR-----------------------------*/

	private void lista() {
		EmpleadoModel model = new EmpleadoModel();
		List<Empleado> lista = model.listaTodos();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		for(Empleado x : lista) {
			fila = new Object[] {x.getCodEmpleado(),x.getNombres(),x.getApellidos(),x.getdNI(),x.getTelefono(),x.getEmail(),x.getDireccion()};
			dtm.addRow(fila);
		}
	}
	
/*-----------------------------INSERTAR-----------------------------*/
	
	private void inserta() {
		String nombre = txtNombres.getText().trim();
		String apellido = txtApellidos.getText().trim();
		int dni = Integer.parseInt(txtDni.getText());
		String fono = txtTelefono.getText().trim();
		String email = txtEmail.getText().trim();
		String direccion = txtDireccion.getText().trim();
		
		//VALIDAR
		if(!nombre.matches(Validaciones.TEXTO)) {
			mensaje("El nombre del Empleado es de 3 a 30 carácteres");
		} else if(!apellido.matches(Validaciones.TEXTO)) {
			mensaje("El Apellido del Empleado es de 3 a 30 carácteres");
		} else if(txtDni.getText().isBlank() || !txtDni.getText().matches(Validaciones.DNI)) {
			mensaje("El DNI solo permite ingresar 8 dígitos");
		} else if(!fono.matches(Validaciones.TELEFONO_PROVEEDOR)) {
			mensaje("El teléfono solo permite ingresar 9 dígitos numéricos");
		}else if(!email.matches(Validaciones.CORREO)) {
			mensaje("Por favor, ingrese correctamente el email");
		} 
		else {
			Empleado obj = new Empleado();
			obj.setNombres(nombre);
			obj.setApellidos(apellido);
			obj.setdNI(dni);
			obj.setTelefono(fono);
			obj.setEmail(email);
			obj.setDireccion(direccion);
			
			EmpleadoModel model = new EmpleadoModel();
			int salida = model.RegistrarEmpleado(obj);
			
			if(salida>0) {
				lista();
				idSeleccionado=-1; 
				limpiarCajarTexto();
				mensaje("Se insertó correctamente");
			} else {
				mensaje("Error en el registro, inténtelo nuevamente");
			}
		}
}
	
	/*-----------------------------BUSCA-----------------------------*/
	
	private void busca() {
		int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String nombre = (String)table.getValueAt(fila, 1);
		String apellido = (String)table.getValueAt(fila, 2);
		int dni = (Integer)table.getValueAt(fila, 3);
		String fono = (String)table.getValueAt(fila, 4);
		String email = (String)table.getValueAt(fila, 5);
		String direccion = (String)table.getValueAt(fila, 6);
		
		System.out.println(idSeleccionado + " - " + nombre + " - " + apellido + " - " + dni + " - " + fono + " - " + email + " - " + direccion);
		
		txtNombres.setText(nombre);
		txtApellidos.setText(apellido);
		txtDni.setText(String.valueOf(dni));
		txtTelefono.setText(fono);
		txtEmail.setText(email);
		txtDireccion.setText(direccion);
	}
	
/*-----------------------------ACTUALIZA-----------------------------*/
	
	private void actualiza() {
		String nombre = txtNombres.getText().trim();
		String apellido = txtApellidos.getText().trim();
		int dni = Integer.parseInt(txtDni.getText());
		String fono = txtTelefono.getText().trim();
		String email = txtEmail.getText().trim();
		String direccion = txtDireccion.getText().trim();
		
		//VALIDAR
		if(idSeleccionado==-1) {
			mensaje("Selecione una fila por favor");
		} else if(!nombre.matches(Validaciones.TEXTO)) {
			mensaje("El nombre del Empleado es de 3 a 30 carácteres");
		} else if(!apellido.matches(Validaciones.TEXTO)) {
			mensaje("El Apellido del Empleado es de 3 a 30 carácteres");
		} else if(txtDni.getText().isBlank() || !txtDni.getText().matches(Validaciones.DNI)) {
			mensaje("El DNI solo permite ingresar 8 dígitos");
		} else if(!fono.matches(Validaciones.TELEFONO_PROVEEDOR)) {
			mensaje("El teléfono solo permite ingresar 9 dígitos numéricos");
		}else if(!email.matches(Validaciones.CORREO)) {
			mensaje("Por favor, ingrese correctamente el email");
		}
		else {
			Empleado obj = new Empleado();
			obj.setCodEmpleado(idSeleccionado);
			obj.setNombres(nombre);
			obj.setApellidos(apellido);
			obj.setdNI(dni);
			obj.setTelefono(fono);
			obj.setEmail(email);
			obj.setDireccion(direccion);
			
			EmpleadoModel model = new EmpleadoModel();
			int salida = model.actualizarEmpleado(obj);
			
			if(salida>0) {
				lista();
				idSeleccionado = -1; 
				limpiarCajarTexto();
				mensaje("Se actualizó correctamente");
			} else {
				mensaje("Error en la actualización, intentelo nuevamente");
			}
		}
		}
	
/*-----------------------------ELIMINAR-----------------------------*/
	
	private void elimina() {
		if(idSeleccionado == - 1) {
			mensaje("Seleccione una fila");
		} else {
			EmpleadoModel model = new EmpleadoModel();
			int salida = model.eliminarEmpleado(idSeleccionado);
			if(salida>0) {
				lista();
				idSeleccionado = -1;
				limpiarCajarTexto();
				mensaje("Se eliminó correctamente");
			} else {
				mensaje("Error en la eliminación");
			}
		}
	}
	
}

