package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import entidades.Distribuidora;
import model.DistribuidoraModel;
import util.Validaciones;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegistrarProveedor extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblRegistroDeDistribuidora;
	private JLabel lblRazonSocial;
	private JLabel lblRuc;
	private JLabel lblTipo;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblDireccion;
	private JTextField txtRazonSocial;
	private JTextField txtRUC;
	private JTextField txtTipo;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JButton btnRegistrar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistrarProveedor frame = new FrmRegistrarProveedor();
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
	public FrmRegistrarProveedor() {
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Proveedor");
		setBounds(100, 100, 467, 420);
		getContentPane().setLayout(null);
		
		lblRegistroDeDistribuidora = new JLabel("REGISTRO DE DISTRIBUIDORAS");
		lblRegistroDeDistribuidora.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblRegistroDeDistribuidora.setBounds(37, 11, 409, 39);
		getContentPane().add(lblRegistroDeDistribuidora);
		
		lblRazonSocial = new JLabel("Raz\u00F3n Social: ");
		lblRazonSocial.setBounds(57, 74, 100, 14);
		getContentPane().add(lblRazonSocial);
		
		lblRuc = new JLabel("RUC");
		lblRuc.setBounds(57, 104, 46, 14);
		getContentPane().add(lblRuc);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(57, 138, 78, 14);
		getContentPane().add(lblTipo);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(56, 174, 79, 14);
		getContentPane().add(lblTelefono);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(57, 203, 78, 14);
		getContentPane().add(lblEmail);
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(57, 237, 100, 14);
		getContentPane().add(lblDireccion);
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setOpaque(false);
		txtRazonSocial.setColumns(10);
		txtRazonSocial.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtRazonSocial.setBounds(173, 71, 213, 20);
		getContentPane().add(txtRazonSocial);
		
		txtRUC = new JTextField();
		txtRUC.setOpaque(false);
		txtRUC.setColumns(10);
		txtRUC.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtRUC.setBounds(173, 104, 213, 20);
		getContentPane().add(txtRUC);
		
		txtTipo = new JTextField();
		txtTipo.setOpaque(false);
		txtTipo.setColumns(10);
		txtTipo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtTipo.setBounds(173, 135, 213, 20);
		getContentPane().add(txtTipo);
		
		txtTelefono = new JTextField();
		txtTelefono.setOpaque(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtTelefono.setBounds(173, 171, 213, 20);
		getContentPane().add(txtTelefono);
		
		txtEmail = new JTextField();
		txtEmail.setOpaque(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEmail.setBounds(173, 200, 213, 20);
		getContentPane().add(txtEmail);
		
		txtDireccion = new JTextField();
		txtDireccion.setOpaque(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDireccion.setBounds(173, 234, 213, 20);
		getContentPane().add(txtDireccion);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon(FrmRegistrarProveedor.class.getResource("/img/Accept.gif")));
		btnRegistrar.setBounds(151, 284, 131, 31);
		getContentPane().add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(FrmRegistrarProveedor.class.getResource("/img/Delete.gif")));
		btnCancelar.setBounds(151, 329, 131, 31);
		getContentPane().add(btnCancelar);

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
		String razon = txtRazonSocial.getText().trim();
		String ruc = txtRUC.getText().trim();
		String tipo = txtTipo.getText().trim();
		String fono = txtTelefono.getText().trim();
		String email = txtEmail.getText().trim();
		String direccion = txtDireccion.getText().trim();
		
		//VALIDACIONES
		if(!razon.matches(Validaciones.TEXTO)) {
			mensaje("La Razón Social es de 3 a 30 carácteres");
		} else if(!ruc.matches(Validaciones.RUC)) {
			mensaje("RUC es de 11 carácteres numéricos");
		} else if(!tipo.matches(Validaciones.TEXTO)) {
			mensaje("El tipo es de 3 a 30 carácteres");
		} else if(!fono.matches(Validaciones.TELEFONO_PROVEEDOR)) {
			mensaje("El teléfono es de 9 dígitos numéricos");
		} else if(!email.matches(Validaciones.CORREO)) {
			mensaje("El correo ....");
		} else {
			Distribuidora obj = new Distribuidora();
			obj.setRaSocial(razon);
			obj.setRuc(ruc);
			obj.setTipo(tipo);
			obj.setTelefono(fono);
			obj.setEmail(email);
			obj.setDireccion(direccion);
			
			DistribuidoraModel model = new DistribuidoraModel();
			int salida = model.insertarDistribuidora(obj);
			
			if(salida>0) {
				limpiarCajarTexto();
				mensaje("Se insertó correctamente");
			} else {
				mensaje("Error en el registro, inténtelo nuevamente");
			}
		}
	}
	private void mensaje(String men) {
		JOptionPane.showMessageDialog(this,  men);
		
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		System.exit(0);
	}
	
	void limpiarCajarTexto() {
		txtRazonSocial.setText("");
		txtRUC.setText("");
		txtTipo.setText("");
		txtTelefono.setText("");
		txtEmail.setText("");
		txtDireccion.setText("");
		txtRazonSocial.requestFocus();
	}
}
