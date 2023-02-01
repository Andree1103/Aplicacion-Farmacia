package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidades.Producto;
import model.ProductoModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FrmConsultaProducto extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblConsultaProducto;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnFiltrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaProducto frame = new FrmConsultaProducto();
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
	public FrmConsultaProducto() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Consulta de Productos");
		setBounds(100, 100, 778, 458);
		getContentPane().setLayout(null);
		
		lblConsultaProducto = new JLabel("Consulta de Productos");
		lblConsultaProducto.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblConsultaProducto.setBounds(227, 11, 341, 60);
		getContentPane().add(lblConsultaProducto);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(81, 103, 56, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(176, 100, 190, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 742, 278);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Precio", "Fecha Vencimiento", "Stock"
			}
		));
		scrollPane.setViewportView(table);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setIcon(new ImageIcon(FrmConsultaProducto.class.getResource("/img/Zoom out.gif")));
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(616, 84, 101, 33);
		getContentPane().add(btnFiltrar);

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
		
		ProductoModel model = new ProductoModel();
		List<Producto> lstProducto = model.listaProductoPorNombreLike(nombre);
		
		Object[] fila = null; 
		for(Producto p : lstProducto) {
			fila = new Object[] {p.getIdProducto(),p.getNombre(),p.getPrecio(),p.getFechaVencimiento(),p.getStock()};
			dtm.addRow(fila);
		}
	}
}
