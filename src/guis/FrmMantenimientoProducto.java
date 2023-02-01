package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import entidades.Producto;
import model.ProductoModel;
import util.Conversiones;
import util.Validaciones;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JFrame;

public class FrmMantenimientoProducto extends JInternalFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblMantenimientoDeProductos;
	private JLabel lblNombre;
	private JLabel lblPrecio;
	private JLabel lblFechaVencimiento;
	private JLabel lblStock;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JTable table;
	
	/*---------------------------------------------------------*/
	private int idSeleccionado = -1; 
	private JScrollPane scrollPane;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtFechaVencimiento;
	private JTextField txtStock;
	/*---------------------------------------------------------*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoProducto frame = new FrmMantenimientoProducto();
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
	public FrmMantenimientoProducto() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Mantenimiento de Productos");
		setBounds(100, 100, 897, 406);
		getContentPane().setLayout(null);
		
		lblMantenimientoDeProductos = new JLabel("Mantenimiento de Productos");
		lblMantenimientoDeProductos.setOpaque(true);
		lblMantenimientoDeProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeProductos.setForeground(Color.WHITE);
		lblMantenimientoDeProductos.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoDeProductos.setBackground(Color.BLACK);
		lblMantenimientoDeProductos.setBounds(0, 0, 881, 59);
		getContentPane().add(lblMantenimientoDeProductos);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(21, 82, 68, 14);
		getContentPane().add(lblNombre);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(21, 116, 46, 14);
		getContentPane().add(lblPrecio);
		
		lblFechaVencimiento = new JLabel("Fecha de Vencimiento:");
		lblFechaVencimiento.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaVencimiento.setBounds(21, 156, 139, 14);
		getContentPane().add(lblFechaVencimiento);
		
		lblStock = new JLabel("Stock:");
		lblStock.setBounds(21, 194, 46, 14);
		getContentPane().add(lblStock);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmMantenimientoProducto.class.getResource("/img/Accept.gif")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(30, 257, 117, 33);
		getContentPane().add(btnRegistrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoProducto.class.getResource("/img/Delete.gif")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(157, 257, 113, 33);
		getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmMantenimientoProducto.class.getResource("/img/Edit.gif")));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(100, 313, 109, 33);
		getContentPane().add(btnActualizar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(285, 70, 586, 282);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Precio", "Fecha Vencimiento", "Stock"
			}
		));
		
		//TRAER DATOS DE LA BD
				lista();
		
		table.getColumnModel().getColumn(0).setPreferredWidth(3);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(5);
		table.getColumnModel().getColumn(3).setPreferredWidth(5);
		table.getColumnModel().getColumn(4).setPreferredWidth(5);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		scrollPane.setViewportView(table);
		
		txtNombre = new JTextField();
		txtNombre.setOpaque(false);
		txtNombre.setColumns(10);
		txtNombre.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNombre.setBounds(99, 80, 175, 20);
		getContentPane().add(txtNombre);
		
		txtPrecio = new JTextField();
		txtPrecio.setOpaque(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPrecio.setBounds(100, 114, 175, 20);
		getContentPane().add(txtPrecio);
		
		txtFechaVencimiento = new JTextField();
		txtFechaVencimiento.setOpaque(false);
		txtFechaVencimiento.setColumns(10);
		txtFechaVencimiento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtFechaVencimiento.setBounds(149, 154, 126, 20);
		getContentPane().add(txtFechaVencimiento);
		
		txtStock = new JTextField();
		txtStock.setOpaque(false);
		txtStock.setColumns(10);
		txtStock.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtStock.setBounds(100, 192, 175, 20);
		getContentPane().add(txtStock);
		
		

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
		txtNombre.setText("");
		txtPrecio.setText("");
		txtFechaVencimiento.setText("");
		txtStock.setText("");
		txtNombre.requestFocus();
	}
	
	/*-----------------------------LISTAR-----------------------------*/

	private void lista() {
		ProductoModel model = new ProductoModel();
		List<Producto> lista = model.listaTodos();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null; 
		for(Producto x : lista) {
			fila = new Object[] {x.getIdProducto(),x.getNombre(),x.getPrecio(),x.getFechaVencimiento(),x.getStock()};
			dtm.addRow(fila);
		}
	}
	
	/*-----------------------------INSERTAR-----------------------------*/
	
	private void inserta() {
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
		double precio = (Double)table.getValueAt(fila, 2);
		Date fechaVencimiento=(Date)table.getValueAt(fila, 3);
		int stock = (Integer)table.getValueAt(fila, 4);
		
		System.out.println(idSeleccionado + " - " + nombre + " - " + precio + " - " + fechaVencimiento + " - " + stock);
		
		txtNombre.setText(nombre);
		txtPrecio.setText(String.valueOf(precio));
		txtFechaVencimiento.setText(String.valueOf(fechaVencimiento));
		txtStock.setText(String.valueOf(stock));
	}
	
	
	/*-----------------------------ACTUALIZA-----------------------------*/
	
	private void actualiza() {
		String nombre = txtNombre.getText().trim();
		double precio = Double.parseDouble(txtPrecio.getText());
		String fec = txtFechaVencimiento.getText().trim();
		int stock = Integer.parseInt(txtStock.getText());
		
		//VALIDAR
		if(idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		} else if(!nombre.matches(Validaciones.TEXTO)) {
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
			obj.setIdProducto(idSeleccionado);
			obj.setNombre(nombre);
			obj.setPrecio(precio);
			obj.setFechaVencimiento(Conversiones.toFecha(fec));
			obj.setStock(stock);
			
			ProductoModel model = new ProductoModel();
			int salida = model.actualizarProducto(obj);
			
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
		if(idSeleccionado == -1) {
			mensaje("Seleccione una fila");
		} else {
			ProductoModel model = new ProductoModel();
			int salida = model.eliminarProducto(idSeleccionado);
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
