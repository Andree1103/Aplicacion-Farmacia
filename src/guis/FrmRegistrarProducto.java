package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import entidades.Producto;
import model.ProductoModel;
import util.Conversiones;
import util.Validaciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class FrmRegistrarProducto extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblFechaNacimiento;
	private JLabel lblStock;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtFechaVencimiento;
	private JTextField txtStock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistrarProducto frame = new FrmRegistrarProducto();
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
	public FrmRegistrarProducto() {
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Productos");
		setBounds(100, 100, 391, 468);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("REGISTRO DE PRODUCTOS");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(37, 34, 340, 39);
		getContentPane().add(lblNewLabel);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(86, 122, 91, 14);
		getContentPane().add(lblNombre);
		
		lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(86, 161, 46, 14);
		getContentPane().add(lblPrecio);
		
		lblFechaNacimiento = new JLabel("Fecha de Vencimiento:");
		lblFechaNacimiento.setBounds(37, 201, 149, 14);
		getContentPane().add(lblFechaNacimiento);
		
		lblStock = new JLabel("Stock:");
		lblStock.setBounds(86, 250, 46, 14);
		getContentPane().add(lblStock);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmRegistrarProducto.class.getResource("/img/Accept.gif")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(119, 303, 175, 30);
		getContentPane().add(btnRegistrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setIcon(new ImageIcon(FrmRegistrarProducto.class.getResource("/img/Delete.gif")));
		btnCancelar.setBounds(146, 344, 115, 30);
		getContentPane().add(btnCancelar);
		
		txtNombre = new JTextField();
		txtNombre.setOpaque(false);
		txtNombre.setColumns(10);
		txtNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNombre.setBounds(175, 119, 175, 20);
		getContentPane().add(txtNombre);
		
		txtPrecio = new JTextField();
		txtPrecio.setOpaque(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPrecio.setBounds(175, 158, 175, 20);
		getContentPane().add(txtPrecio);
		
		txtFechaVencimiento = new JTextField();
		txtFechaVencimiento.setOpaque(false);
		txtFechaVencimiento.setColumns(10);
		txtFechaVencimiento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtFechaVencimiento.setBounds(175, 198, 175, 20);
		getContentPane().add(txtFechaVencimiento);
		
		txtStock = new JTextField();
		txtStock.setOpaque(false);
		txtStock.setColumns(10);
		txtStock.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtStock.setBounds(175, 247, 175, 20);
		getContentPane().add(txtStock);

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
		double precio = Double.parseDouble(txtPrecio.getText());
		String fec = txtFechaVencimiento.getText().trim();
		int stock = Integer.parseInt(txtStock.getText());
		
		//VALIDAR
		if(!nombre.matches(Validaciones.TEXTO)) {
			mensaje("El nombre del producto es de 3 a 30 carácteres");
		} else if(txtPrecio.getText().isBlank() || !txtPrecio.getText().matches(Validaciones.PRECIO)) {
			mensaje("El precio solo acepta dígitos numéricos");
		} else if(!fec.matches(Validaciones.FECHA)) {
			mensaje("La fecha de vencimiento tiene formato yyyy-MM-dd");
		} else if(txtStock.getText().isBlank() || !txtStock.getText().matches(Validaciones.STOCK)) {
			mensaje("El Sotck solo acepta dígitos numéricos");
		}
		else {
			Producto obj = new Producto();
			obj.setNombre(nombre);
			obj.setPrecio(precio);
			obj.setFechaVencimiento(Conversiones.toFecha(fec));
			obj.setStock(stock);
			
			ProductoModel model = new ProductoModel();
			int salida = model.insertarProducto(obj);
			
			if(salida>0) {
				limpiarCajarTexto();
				mensaje("Se insertó correctamente");
				
			} else {
				mensaje("Error en el registro, inténtelo nuevamente");
			}
		}
	}
	void mensaje(String men) {
		JOptionPane.showMessageDialog(this, men);
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		System.exit(0);
	}
	
	void limpiarCajarTexto() {
		txtNombre.setText("");
		txtPrecio.setText("");
		txtFechaVencimiento.setText("");
		txtStock.setText("");
		txtNombre.requestFocus();
	}
}
