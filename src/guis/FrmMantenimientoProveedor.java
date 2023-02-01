package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Distribuidora;
import model.DistribuidoraModel;
import util.Validaciones;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class FrmMantenimientoProveedor extends JInternalFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblMantenimientoDeProductos;
	private JLabel lblRazonSocial;
	private JLabel lblRuc;
	private JLabel lblTipo;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblDireccion;
	private JTextField txtRazon;
	private JTextField txtRuc;
	private JTextField txtTipo;
	private JTextField txtFono;
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	
	/*------------------------------------------------------------------------*/
	private int idSeleccionado = -1; 
	/*------------------------------------------------------------------------*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoProveedor frame = new FrmMantenimientoProveedor();
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
	public FrmMantenimientoProveedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Mantenimiento de Proveedor");
		setBounds(100, 100, 947, 465);
		getContentPane().setLayout(null);
		
		lblMantenimientoDeProductos = new JLabel("Mantenimiento de Distribuidoras");
		lblMantenimientoDeProductos.setOpaque(true);
		lblMantenimientoDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeProductos.setForeground(Color.WHITE);
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoDeProductos.setBackground(Color.BLACK);
		lblMantenimientoDeProductos.setBounds(0, 0, 948, 59);
		getContentPane().add(lblMantenimientoDeProductos);
		
		lblRazonSocial = new JLabel("Raz\u00F3n Social: ");
		lblRazonSocial.setBounds(28, 70, 97, 14);
		getContentPane().add(lblRazonSocial);
		
		lblRuc = new JLabel("RUC");
		lblRuc.setBounds(28, 95, 46, 14);
		getContentPane().add(lblRuc);
		
		lblTipo = new JLabel("Tipo ");
		lblTipo.setBounds(28, 129, 46, 14);
		getContentPane().add(lblTipo);
		
		lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(353, 70, 69, 14);
		getContentPane().add(lblTelefono);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(353, 95, 69, 14);
		getContentPane().add(lblEmail);
		
		lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(353, 129, 69, 14);
		getContentPane().add(lblDireccion);
		
		txtRazon = new JTextField();
		txtRazon.setOpaque(false);
		txtRazon.setColumns(10);
		txtRazon.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtRazon.setBounds(112, 67, 200, 20);
		getContentPane().add(txtRazon);
		
		txtRuc = new JTextField();
		txtRuc.setOpaque(false);
		txtRuc.setColumns(10);
		txtRuc.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtRuc.setBounds(112, 95, 200, 20);
		getContentPane().add(txtRuc);
		
		txtTipo = new JTextField();
		txtTipo.setOpaque(false);
		txtTipo.setColumns(10);
		txtTipo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtTipo.setBounds(112, 127, 200, 20);
		getContentPane().add(txtTipo);
		
		txtFono = new JTextField();
		txtFono.setOpaque(false);
		txtFono.setColumns(10);
		txtFono.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtFono.setBounds(440, 70, 222, 20);
		getContentPane().add(txtFono);
		
		txtEmail = new JTextField();
		txtEmail.setOpaque(false);
		txtEmail.setColumns(10);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEmail.setBounds(440, 95, 222, 20);
		getContentPane().add(txtEmail);
		
		txtDireccion = new JTextField();
		txtDireccion.setOpaque(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtDireccion.setBounds(440, 126, 222, 20);
		getContentPane().add(txtDireccion);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 921, 259);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CÓDIGO", "RAZÓN SOCIAL", "RUC", "TIPO", "TELÉFONO", "EMAIL", "DIRECCIÓN"
			}
		));
		
		//TRAER DATOS DE LA BD
		lista();
		
		scrollPane.setViewportView(table);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/img/Add.gif")));
		btnRegistrar.setBounds(715, 70, 121, 29);
		getContentPane().add(btnRegistrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/img/Edit.gif")));
		btnActualizar.setBounds(715, 103, 121, 29);
		getContentPane().add(btnActualizar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoProveedor.class.getResource("/img/Delete.gif")));
		btnEliminar.setBounds(715, 140, 121, 20);
		getContentPane().add(btnEliminar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		inserta();
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualiza();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		elimina();
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}
	
	void limpiarCajaTexto() {
		txtRazon.setText("");
		txtRuc.setText("");
		txtTipo.setText("");
		txtFono.setText("");
		txtEmail.setText("");
		txtDireccion.setText("");
		txtRazon.requestFocus();
	}
	
	
	/*---------------------------LISTAR--------------------------*/
	
	private void lista() {
		DistribuidoraModel model = new DistribuidoraModel();
		List<Distribuidora> lista = model.listaTodos();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		for(Distribuidora x : lista) {
			fila = new Object[] {x.getIdDistribuidora(),x.getRaSocial(),x.getRuc(),x.getTipo(),x.getTelefono(),x.getEmail(),x.getDireccion()};
			dtm.addRow(fila);
		}
	}
	
	/*---------------------------INSERTA--------------------------*/
	
	private void inserta() {
		String razon = txtRazon.getText().trim();
		String ruc = txtRuc.getText().trim();
		String tipo = txtTipo.getText().trim();
		String fono = txtFono.getText().trim();
		String email = txtEmail.getText().trim();
		String direccion = txtDireccion.getText().trim();
		
		
		//Validación 
		
		if(!razon.matches(Validaciones.TEXTO)) {
			mensaje("La razón Social es de 3 a 30 carácteres");
		} else if(!ruc.matches(Validaciones.RUC)) {
			mensaje("El RUC solo permite ingreso de 11 dígitos numéricos");
		} else if(!tipo.matches(Validaciones.TEXTO)) {
			 mensaje("El Tipo solo es de 3 a 30 carácteres");
		} else if(!fono.matches(Validaciones.TELEFONO_PROVEEDOR)) {
			mensaje("El teléfono solo permite ingreso de 9 dígitos numéricos");
		} else if(!email.matches(Validaciones.CORREO)) {
			mensaje("Esos valores no están permitidos en correo, por favor inténtelo nuevamente");
		} 
		else {
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
				lista();
				idSeleccionado=-1;
				limpiarCajaTexto();
				mensaje("Se insertó correctamente");
			} else {
				mensaje("Error en el registro, inténtelo nuevamente");
			}
		}
	}
	
	
	/*---------------------------BUSCA--------------------------*/
	
	private void busca() {
		int fila = table.getSelectedRow();
		
		idSeleccionado = (Integer)table.getValueAt(fila, 0);
		String razon = (String)table.getValueAt(fila, 1);
		String ruc = (String) table.getValueAt(fila, 2);
		String tipo = (String)table.getValueAt(fila, 3);
		String fono = (String)table.getValueAt(fila, 4);
		String email = (String)table.getValueAt(fila, 5);
		String direccion = (String)table.getValueAt(fila, 6);
		
		System.out.println(idSeleccionado + " - " + razon + " - " + ruc + " - " + tipo + " - " + fono + " - " + email + " - " + direccion);
		
		txtRazon.setText(razon);
		txtRuc.setText(ruc);
		txtTipo.setText(tipo);
		txtFono.setText(fono);
		txtEmail.setText(email);
		txtDireccion.setText(direccion);
	}
	
	
	/*---------------------------ACTUALIZA--------------------------*/
	
	private void actualiza() {
			String razon = txtRazon.getText().trim();
			String ruc = txtRuc.getText().trim();
			String tipo = txtTipo.getText().trim();
			String fono = txtFono.getText().trim();
			String email = txtEmail.getText().trim();
			String direccion = txtDireccion.getText().trim();
			
			//VALIDACIONES
			
			if(idSeleccionado == -1) {
				mensaje("Seleccione una fila");
			} else if(!razon.matches(Validaciones.TEXTO)) {
				mensaje("La razón Social es de 3 a 30 carácteres");
			} else if(!ruc.matches(Validaciones.RUC)) {
				mensaje("El ruc solo permite ingreso de 11 dígitos numéricos");
			} else if(!tipo.matches(Validaciones.TEXTO)) {
				mensaje("El Tipo es de 3 a 30 carácteres");
			} else if(!fono.matches(Validaciones.TELEFONO_PROVEEDOR)) {
				mensaje("El teléfono solo permite ingreso de 9 dígitos numéricos");
			}
			else {
				Distribuidora obj = new Distribuidora();
				obj.setIdDistribuidora(idSeleccionado);
				obj.setRaSocial(razon);
				obj.setRuc(ruc);
				obj.setTipo(tipo);
				obj.setTelefono(fono);
				obj.setEmail(email);
				obj.setDireccion(direccion);
				
				DistribuidoraModel model = new DistribuidoraModel();
				int salida = model.actualizarDistribuidora(obj);
				
				if(salida>0) {
					lista();
					idSeleccionado = -1; 
					limpiarCajaTexto();
					mensaje("Se actualizó correctamente");
				} else {
					mensaje("Error en la actualización, inténtelo nuevamente");
				}
			}
	}
	
	
	/*---------------------------ELIMINA--------------------------*/
	
	private void elimina() {
		if(idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		} else {
			DistribuidoraModel model = new DistribuidoraModel();
			int salida = model.eliminarDistribuidora(idSeleccionado);
			if(salida>0) {
				lista();
				idSeleccionado=1;
				limpiarCajaTexto();
				mensaje("Se eliminó correctamente");
			} else {
				mensaje("Error en la eliminación");
			}
		}
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
}
