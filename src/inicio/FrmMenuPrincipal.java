package inicio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import guis.FrmConsultaEmpleado;
import guis.FrmConsultaProducto;
import guis.FrmConsultaProveedor;
import guis.FrmMantenimientoEmpleado;
import guis.FrmMantenimientoProducto;
import guis.FrmMantenimientoProveedor;
import guis.FrmRegistrarEmpleado;
import guis.FrmRegistrarProducto;
import guis.FrmRegistrarProveedor;
import guis.FrmReporteEmpleados;
import guis.FrmReporteProducto;
import guis.FrmReporteProveedor;

import java.awt.Frame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmMenuPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAdministracion;
	private JMenu mnRegistrar;
	private JMenu mnMantenimiento;
	private JMenu mnConsulta;
	private JMenu mnReporte;
	private JMenuItem mntmSalir;
	private JMenuItem mntmRegistrarProducto;
	private JMenuItem mntmRegistrarEmpleado;
	private JMenuItem mntmRegistrarProveedor;
	private JMenuItem mntmMantenimientoProducto;
	private JMenuItem mntmMantenimientoEmpleado;
	private JMenuItem mntmMantenimientoProveedor;
	private JMenuItem mntmConsultaProducto;
	private JMenuItem mntmConsultaEmpleado;
	private JMenuItem mntmConsultaProveedor;
	private JMenuItem mntmReporteProducto;
	private JMenuItem mntmReporteEmpleado;
	private JMenuItem mntmReporteProveedor;
	private JDesktopPane desktopPane;

	
	/*------------------------------------------------------------------------------------------------------------------*/
	
	private FrmRegistrarProducto frmRegistrarProducto = new FrmRegistrarProducto();
	private FrmRegistrarEmpleado frmRegistrarEmpleado = new FrmRegistrarEmpleado();
	private FrmRegistrarProveedor frmRegistrarProveedor = new FrmRegistrarProveedor();
	
	private FrmMantenimientoProducto frmMantenimientoProducto = new FrmMantenimientoProducto();
	private FrmMantenimientoEmpleado frmMantenimientoEmpleado = new FrmMantenimientoEmpleado();
	private FrmMantenimientoProveedor frmMantenimientoProveedor = new FrmMantenimientoProveedor();
	
	private FrmConsultaProducto frmConsultaProducto = new FrmConsultaProducto();
	private FrmConsultaEmpleado frmConsultaEmpleado = new FrmConsultaEmpleado();
	private FrmConsultaProveedor frmConsultaProveedor = new FrmConsultaProveedor();
	
	private FrmReporteProducto frmReporteProducto = new FrmReporteProducto();
	private FrmReporteEmpleados frmReporteEmpleados = new FrmReporteEmpleados();
	private FrmReporteProveedor frmReporteProveedor = new FrmReporteProveedor();
	
	/*------------------------------------------------------------------------------------------------------------------*/
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					FrmMenuPrincipal frame = new FrmMenuPrincipal();
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
	public FrmMenuPrincipal() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Sistema de Gesti\u00F3n Farmacia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 435);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAdministracion = new JMenu("Administraci\u00F3n ");
		mnAdministracion.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Letter.gif")));
		menuBar.add(mnAdministracion);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mntmSalir.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Left.gif")));
		mnAdministracion.add(mntmSalir);
		
		mnRegistrar = new JMenu("Registrar");
		mnRegistrar.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Add.gif")));
		menuBar.add(mnRegistrar);
		
		mntmRegistrarProducto = new JMenuItem("Registrar Producto");
		mntmRegistrarProducto.addActionListener(this);
		mntmRegistrarProducto.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Bricks.gif")));
		mnRegistrar.add(mntmRegistrarProducto);
		
		mntmRegistrarEmpleado = new JMenuItem("Registrar Empleado");
		mntmRegistrarEmpleado.addActionListener(this);
		mntmRegistrarEmpleado.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Boy.gif")));
		mnRegistrar.add(mntmRegistrarEmpleado);
		
		mntmRegistrarProveedor = new JMenuItem("Registrar Proveedor");
		mntmRegistrarProveedor.addActionListener(this);
		mntmRegistrarProveedor.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Conference.gif")));
		mnRegistrar.add(mntmRegistrarProveedor);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Edit.gif")));
		menuBar.add(mnMantenimiento);
		
		mntmMantenimientoProducto = new JMenuItem("Producto");
		mntmMantenimientoProducto.addActionListener(this);
		mntmMantenimientoProducto.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Bricks.gif")));
		mnMantenimiento.add(mntmMantenimientoProducto);
		
		mntmMantenimientoEmpleado = new JMenuItem("Empleado");
		mntmMantenimientoEmpleado.addActionListener(this);
		mntmMantenimientoEmpleado.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Boy.gif")));
		mnMantenimiento.add(mntmMantenimientoEmpleado);
		
		mntmMantenimientoProveedor = new JMenuItem("Proveedor");
		mntmMantenimientoProveedor.addActionListener(this);
		mntmMantenimientoProveedor.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Conference.gif")));
		mnMantenimiento.add(mntmMantenimientoProveedor);
		
		mnConsulta = new JMenu("Consulta");
		mnConsulta.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Zoom out.gif")));
		menuBar.add(mnConsulta);
		
		mntmConsultaProducto = new JMenuItem("Producto");
		mntmConsultaProducto.addActionListener(this);
		mntmConsultaProducto.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Bricks.gif")));
		mnConsulta.add(mntmConsultaProducto);
		
		mntmConsultaEmpleado = new JMenuItem("Empleado");
		mntmConsultaEmpleado.addActionListener(this);
		mntmConsultaEmpleado.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Boy.gif")));
		mnConsulta.add(mntmConsultaEmpleado);
		
		mntmConsultaProveedor = new JMenuItem("Proveedor");
		mntmConsultaProveedor.addActionListener(this);
		mntmConsultaProveedor.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Conference.gif")));
		mnConsulta.add(mntmConsultaProveedor);
		
		mnReporte = new JMenu("Reporte");
		mnReporte.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Lists.gif")));
		menuBar.add(mnReporte);
		
		mntmReporteProducto = new JMenuItem("Producto");
		mntmReporteProducto.addActionListener(this);
		mntmReporteProducto.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Bricks.gif")));
		mnReporte.add(mntmReporteProducto);
		
		mntmReporteEmpleado = new JMenuItem("Empleado");
		mntmReporteEmpleado.addActionListener(this);
		mntmReporteEmpleado.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Boy.gif")));
		mnReporte.add(mntmReporteEmpleado);
		
		mntmReporteProveedor = new JMenuItem("Proveedor");
		mntmReporteProveedor.addActionListener(this);
		mntmReporteProveedor.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/Conference.gif")));
		mnReporte.add(mntmReporteProveedor);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		frmRegistrarEmpleado.setLocation(25, 100);
		
		/*--------------------------------------------------------------------------------------------*/
		
		//REGISTROS
		desktopPane.add(frmRegistrarProducto);
		desktopPane.add(frmRegistrarEmpleado);
		desktopPane.add(frmRegistrarProveedor);
		
		//CRUD
		desktopPane.add(frmMantenimientoProducto);
		desktopPane.add(frmMantenimientoEmpleado);
		desktopPane.add(frmMantenimientoProveedor);
		
		//CONSULTAS
		desktopPane.add(frmConsultaProducto);
		desktopPane.add(frmConsultaEmpleado);
		desktopPane.add(frmConsultaProveedor);
		
		//REPORTES
		desktopPane.add(frmReporteProducto);
		desktopPane.add(frmReporteEmpleados);
		desktopPane.add(frmReporteProveedor);
		
		/*--------------------------------------------------------------------------------------------*/
		
		contentPane.add(desktopPane, BorderLayout.CENTER);
		frmRegistrarProducto.setBounds(110, 11, 425, 428);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == mntmReporteProveedor) {
			actionPerformedMntmReporteProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmReporteEmpleado) {
			actionPerformedMntmReporteEmpleadoJMenuItem(e);
		}
		if (e.getSource() == mntmReporteProducto) {
			actionPerformedMntmReporteProductoJMenuItem(e);
		}
		if (e.getSource() == mntmConsultaProveedor) {
			actionPerformedMntmConsultaProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmConsultaEmpleado) {
			actionPerformedMntmConsultaEmpleadoJMenuItem(e);
		}
		if (e.getSource() == mntmConsultaProducto) {
			actionPerformedMntmConsultaProductoJMenuItem(e);
		}
		if (e.getSource() == mntmMantenimientoProveedor) {
			actionPerformedMntmMantenimientoProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmMantenimientoEmpleado) {
			actionPerformedMntmMantenimientoEmpleadoJMenuItem(e);
		}
		if (e.getSource() == mntmMantenimientoProducto) {
			actionPerformedMntmMantenimientoProductoJMenuItem(e);
		}
		if (e.getSource() == mntmRegistrarProveedor) {
			actionPerformedMntmRegistrarProveedorJMenuItem(e);
		}
		if (e.getSource() == mntmRegistrarEmpleado) {
			actionPerformedMntmRegistrarEmpleadoJMenuItem(e);
		}
		if (e.getSource() == mntmRegistrarProducto) {
			actionPerformedMntmRegistrarProductoJMenuItem(e);
		}
	}
	protected void actionPerformedMntmRegistrarProductoJMenuItem(ActionEvent e) {
		//3° 
		frmRegistrarProducto.setVisible(true);
	}
	protected void actionPerformedMntmRegistrarEmpleadoJMenuItem(ActionEvent e) {
		frmRegistrarEmpleado.setVisible(true);
	}
	protected void actionPerformedMntmRegistrarProveedorJMenuItem(ActionEvent e) {
		frmRegistrarProveedor.setVisible(true);
	}
	protected void actionPerformedMntmMantenimientoProductoJMenuItem(ActionEvent e) {
		frmMantenimientoProducto.setVisible(true);
	}
	protected void actionPerformedMntmMantenimientoEmpleadoJMenuItem(ActionEvent e) {
		frmMantenimientoEmpleado.setVisible(true);
	}
	protected void actionPerformedMntmMantenimientoProveedorJMenuItem(ActionEvent e) {
		frmMantenimientoProveedor.setVisible(true);
	}
	protected void actionPerformedMntmConsultaProductoJMenuItem(ActionEvent e) {
		frmConsultaProducto.setVisible(true);
	}
	protected void actionPerformedMntmConsultaEmpleadoJMenuItem(ActionEvent e) {
		frmConsultaEmpleado.setVisible(true);
	}
	protected void actionPerformedMntmConsultaProveedorJMenuItem(ActionEvent e) {
		frmConsultaProveedor.setVisible(true);
	}
	protected void actionPerformedMntmReporteProductoJMenuItem(ActionEvent e) {
		frmReporteProducto.setVisible(true);
	}
	protected void actionPerformedMntmReporteEmpleadoJMenuItem(ActionEvent e) {
		frmReporteEmpleados.setVisible(true);
	}
	protected void actionPerformedMntmReporteProveedorJMenuItem(ActionEvent e) {
		frmReporteProveedor.setVisible(true);
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e) {
				 confirmarSalida();
				 }
			});
			this.setVisible(true);
			 } catch(Exception e2) {
				 e2.printStackTrace();
		}
	}
	
	public void confirmarSalida() {
		int valor = JOptionPane.showConfirmDialog(this, "Estás seguro de cerrar la aplicación?","Advertencia", JOptionPane.YES_NO_OPTION);
		if(valor==JOptionPane.YES_NO_OPTION) {
			JOptionPane.showMessageDialog(null, "ESTÁ CERRANDO SESIÓN...",":)",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
}