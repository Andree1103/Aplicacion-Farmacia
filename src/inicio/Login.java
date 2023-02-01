package inicio;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import entidades.usuario;
import model.GestionUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JButton btnIniciarSesion;
	private JButton btnCancelar;
	private JPasswordField jPassword;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
					Login frame = new Login();
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
	public Login() {
		setTitle("INICIAR SESI\u00D3N ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setIcon(new ImageIcon(Login.class.getResource("/img/Users.gif")));
		lblUsuario.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblUsuario.setBounds(131, 112, 110, 32);
		contentPane.add(lblUsuario);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setIcon(new ImageIcon(Login.class.getResource("/img/Lock.gif")));
		lblPassword.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblPassword.setBounds(131, 155, 110, 32);
		contentPane.add(lblPassword);
		
		btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n ");
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setBounds(222, 222, 157, 32);
		contentPane.add(btnIniciarSesion);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(222, 268, 157, 32);
		contentPane.add(btnCancelar);
		
		jPassword = new JPasswordField();
		jPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		jPassword.setBounds(251, 159, 171, 20);
		contentPane.add(jPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setOpaque(false);
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtUsuario.setBounds(251, 116, 175, 20);
		contentPane.add(txtUsuario);
		setLocationRelativeTo(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnIniciarSesion) {
			actionPerformedBtnIniciarSesion(e);
		}
	}
	protected void actionPerformedBtnIniciarSesion(ActionEvent e) {
		ingresa();
		
		/*USUARIOS: 
		 1. 'admin','12345'
		 2. 'val','12345'
		 3. 'abel','12345'
		 4. 'andree','12345'*/
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		System.exit(0);
	}
	
	protected void ingresa() {
		String user = txtUsuario.getText();
		String clave = new String(jPassword.getPassword());
		
		GestionUsuario gestion = new GestionUsuario();
		
		usuario usuario2 = new usuario();
		usuario2.setUser(user);
		usuario2.setPass(clave);
		
		usuario usu = gestion.obtenerUsuario(usuario2);
		
		if(usu!=null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			
			this.dispose();
			FrmMenuPrincipal menu = new FrmMenuPrincipal();
			menu.setVisible(true);
			
		} else {
			JOptionPane.showMessageDialog(contentPane, "Datos invalidos","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
}
