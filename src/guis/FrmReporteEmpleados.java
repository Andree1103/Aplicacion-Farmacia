package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import entidades.Empleado;
import model.EmpleadoModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class FrmReporteEmpleados extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblReporteDeEmpleados;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JButton btnFiltrar;
	private JPanel pnlEmpleado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteEmpleados frame = new FrmReporteEmpleados();
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
	public FrmReporteEmpleados() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Reporte de Empleados");
		setBounds(100, 100, 942, 537);
		getContentPane().setLayout(null);
		
		lblReporteDeEmpleados = new JLabel("Reporte de Empleados");
		lblReporteDeEmpleados.setBounds(303, 11, 341, 60);
		lblReporteDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 25));
		getContentPane().add(lblReporteDeEmpleados);
		
		lblNombre = new JLabel("Nombre de empleado: ");
		lblNombre.setBounds(129, 102, 154, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(303, 99, 240, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(691, 99, 100, 33);
		btnFiltrar.addActionListener(this);
		btnFiltrar.setIcon(new ImageIcon(FrmReporteEmpleados.class.getResource("/img/Zoom out.gif")));
		getContentPane().add(btnFiltrar);
		
		pnlEmpleado = new JPanel();
		pnlEmpleado.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlEmpleado.setBounds(10, 142, 906, 354);
		getContentPane().add(pnlEmpleado);
		pnlEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(e);
		}
	}
	protected void actionPerformedBtnFiltrar(ActionEvent e) {
		//REPORTE
		
		String nombres = txtNombre.getText();
		
		EmpleadoModel model = new EmpleadoModel();
		List<Empleado> lstEmpleado = model.consultaPorNombre(nombres);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstEmpleado);
		String reporte = "ReporteEmpleado.jasper";
		
		JasperPrint print = GeneradorReporte.genera(reporte, dataSource, null);
		JRViewer jRViewer = new JRViewer(print);
		
		pnlEmpleado.removeAll();
		pnlEmpleado.add(jRViewer);
		pnlEmpleado.repaint();
		pnlEmpleado.revalidate();
		
		
	}
}
