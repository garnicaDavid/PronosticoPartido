package interfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import principal.IniciarPrograma;
import javax.swing.ImageIcon;
import java.awt.Color;
public class PantallaDeInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public void iniciarInterfazGrafica() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDeInicio frame = new PantallaDeInicio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaDeInicio() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDelGrupoN = new JLabel("del Grupo N°8");
		lblDelGrupoN.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelGrupoN.setForeground(Color.WHITE);
		lblDelGrupoN.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblDelGrupoN.setBounds(10, 53, 604, 58);
		contentPane.add(lblDelGrupoN);
		
		JLabel labelTitulo = new JLabel("Bienvenido al sistema de puntos");
		labelTitulo.setForeground(new Color(255, 255, 255));
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 33));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(10, 11, 604, 58);
		contentPane.add(labelTitulo);
		
		//Boton para mostrar por consola
		JButton btnMostrarConsola = new JButton("Mostrar por consola");
		btnMostrarConsola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarPrograma logica = new IniciarPrograma();
				logica.incioDelPrograma();
			}
		});
		btnMostrarConsola.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMostrarConsola.setBounds(160, 142, 300, 80);
		contentPane.add(btnMostrarConsola);
		
		
		//Boton para mostrar por ventana
		JButton btnMostrarVentana = new JButton("Mostrar por ventana");
		btnMostrarVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					InterfazMenu menu = new InterfazMenu();
					menu.iniciarMenu();
			}
		});
		btnMostrarVentana.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMostrarVentana.setBounds(160, 274, 300, 80);
		contentPane.add(btnMostrarVentana);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\inicio.jpg"));
		lblNewLabel.setBounds(0, 0, 624, 461);
		contentPane.add(lblNewLabel);
		
		
	}
}
