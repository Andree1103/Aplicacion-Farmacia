package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import entidades.Producto;
import model.ProductoModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class FrmReporteProducto extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNombre;
	private JLabel lblReporteDeProductos;
	private JTextField txtNombre;
	private JButton btnFiltrar;
	private JPanel pnlProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteProducto frame = new FrmReporteProducto();
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
	public FrmReporteProducto() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Reporte de Productos");
		setBounds(100, 100, 917, 534);
		getContentPane().setLayout(null);
		
		lblNombre = new JLabel("Nombre del Producto");
		lblNombre.setBounds(69, 94, 224, 14);
		getContentPane().add(lblNombre);
		
		lblReporteDeProductos = new JLabel("Reporte de Productos");
		lblReporteDeProductos.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblReporteDeProductos.setBounds(311, 11, 341, 60);
		getContentPane().add(lblReporteDeProductos);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(220, 91, 162, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setIcon(new ImageIcon(FrmReporteProducto.class.getResource("/img/Zoom out.gif")));
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(739, 86, 120, 31);
		getContentPane().add(btnFiltrar);
		
		pnlProducto = new JPanel();
		pnlProducto.setBounds(10, 144, 881, 349);
		getContentPane().add(pnlProducto);
		pnlProducto.setLayout(new BorderLayout(0, 0));

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		String nombre = txtNombre.getText();
		
		ProductoModel model = new ProductoModel();
		List<Producto> lstProducto = model.consultaPorNombre(nombre);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstProducto);
		String jasper = "ReporteProducto.jasper";
		
		JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);
		
		JRViewer jRViewer = new JRViewer(print);
		
		pnlProducto.removeAll();
		pnlProducto.add(jRViewer);
		pnlProducto.repaint();
		pnlProducto.revalidate();
	}
}
