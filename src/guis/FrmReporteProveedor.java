package guis;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import entidades.Distribuidora;
import model.DistribuidoraModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmReporteProveedor extends JInternalFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblReporteDeProveedores;
	private JLabel lblRazonSocial;
	private JTextField txtRazon;
	private JButton btnFiltrar;
	private JPanel pnlDistribuidora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReporteProveedor frame = new FrmReporteProveedor();
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
	public FrmReporteProveedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Reporte de Proveedores");
		setBounds(100, 100, 936, 576);
		getContentPane().setLayout(null);
		
		lblReporteDeProveedores = new JLabel("Reporte de Distribuidores");
		lblReporteDeProveedores.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblReporteDeProveedores.setBounds(345, 11, 341, 60);
		getContentPane().add(lblReporteDeProveedores);
		
		lblRazonSocial = new JLabel("RAZ\u00D3N SOCIAL: ");
		lblRazonSocial.setBounds(124, 87, 140, 14);
		getContentPane().add(lblRazonSocial);
		
		txtRazon = new JTextField();
		txtRazon.setBounds(294, 84, 176, 20);
		getContentPane().add(txtRazon);
		txtRazon.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setIcon(new ImageIcon(FrmReporteProveedor.class.getResource("/img/Zoom out.gif")));
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(771, 73, 99, 33);
		getContentPane().add(btnFiltrar);
		
		pnlDistribuidora = new JPanel();
		pnlDistribuidora.setBounds(10, 126, 900, 409);
		getContentPane().add(pnlDistribuidora);
		pnlDistribuidora.setLayout(new BorderLayout(0, 0));

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(e);
		}
	}
	protected void actionPerformedBtnFiltrar(ActionEvent e) {
		
		String razon = txtRazon.getText();
		
		DistribuidoraModel model = new DistribuidoraModel();
		List<Distribuidora> lstDistribuidora = model.consultaProRazonSocial(razon);
		
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstDistribuidora);
		String reporte = "ReporteDistribuidora.jasper";
		
		JasperPrint print = GeneradorReporte.genera(reporte, dataSource, null);
		JRViewer jRViewer = new JRViewer(print);
		
		pnlDistribuidora.removeAll();
		pnlDistribuidora.add(jRViewer);
		pnlDistribuidora.repaint();
		pnlDistribuidora.revalidate();
	}
}
