package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import entidades.Empleado;
import model.EmpleadoModel;
import util.Validaciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class FrmRegistrarEmpleado extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblRegistroDeEmpleados;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblDireccion;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistrarEmpleado frame = new FrmRegistrarEmpleado();
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
	public FrmRegistrarEmpleado() {
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Empleados");
		setBounds(100, 100, 435, 437);
		getContentPane().setLayout(null);
		
		lblRegistroDeEmpleados = new JLabel("REGISTRO DE EMPLEADOS");
		lblRegistroDeEmpleados.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblRegistroDeEmpleados.setBounds(41, 37, 340, 39);
		getContentPane().add(lblRegistroDeEmpleados);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(66, 104, 87, 14);
		getContentPane().add(lblNombre);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(66, 142, 87, 14);
		getContentPane().add(lblApellido);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(66, 182, 87, 14);
		getContentPane().add(lblDni);
		
		lblTelefono = new JLabel("Tel\u00E9fono: ");
		lblTelefono.setBounds(66, 219, 82, 14);
		getContentPane().add(lblTelefono);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(66, 259, 46, 14);
		getContentPane().add(lblEmail);
		
		lblDireccion = new JLabel("Direcci\u00F3n: ");
		lblDireccion.setBounds(66, 299, 82, 14);
		getContentPane().add(lblDireccion);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmRegistrarEmpleado.class.getResource("/img/Accept.gif")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(111, 324, 187, 33);
		getContentPane().add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(FrmRegistrarEmpleado.class.getResource("/img/Delete.gif")));
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(142, 363, 127, 33);
		getContentPane().add(btnCancelar);
		
		txtNombre = new JTextField();
		txtNombre.setOpaque(false);
		txtNombre.setColumns(10);
		txtNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNombre.setBounds(163, 101, 175, 20);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setOpaque(false);
		txtApellido.setColumns(10);
		txtApellido.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtApellido.setBounds(166, 139, 175, 20);
		getContentPane().add(txtApellido);
		
		txtDni = new JTextField();
		txtDni.setOpaque(false);
		txtDni.setColumns(10);
		txtDni.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDni.setBounds(163, 179, 175, 20);
		getContentPane().add(txtDni);
		
		txtTelefono = new JTextField();
		txtTelefono.setOpaque(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtTelefono.setBounds(163, 216, 175, 20);
		getContentPane().add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setOpaque(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEmail.setBounds(163, 256, 175, 20);
		getContentPane().add(txtEmail);
		
		txtDireccion = new JTextField();
		txtDireccion.setOpaque(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDireccion.setBounds(163, 296, 175, 20);
		getContentPane().add(txtDireccion);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		String nombre = txtNombre.getText().trim();
		String apellido = txtApellido.getText().trim();
		int dni = Integer.parseInt(txtDni.getText());
		String fono = txtTelefono.getText().trim();
		String email = txtEmail.getText().trim();
		String direccion = txtDireccion.getText().trim();
		
		if(txtDni.getText().isBlank() || !txtDni.getText().matches(Validaciones.DNI)) {
			mensaje("El ingreso de DNI es numérico");
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
				limpiarCajarTexto();
				mensaje("Registro exitoso");
				
			} else {
				mensaje("Error en el registro");
			}	
		}	
	}
	
	public void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		System.exit(0);
	}
	
	void limpiarCajarTexto() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtDireccion.setText("");
		txtNombre.requestFocus();
	}
}
