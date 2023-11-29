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
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTitulo = new JLabel("Bienvenido al sistema de puntos del Grupo 8");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setBounds(62, 27, 353, 26);
		contentPane.add(labelTitulo);
		
		//Boton para mostrar por consola
		JButton btnMostrarConsola = new JButton("Mostrar por consola");
		btnMostrarConsola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IniciarPrograma inicio = new IniciarPrograma();
				inicio.incioDelPrograma();
			}
		});
		btnMostrarConsola.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMostrarConsola.setBounds(94, 64, 276, 58);
		contentPane.add(btnMostrarConsola);
		
		
		//Boton para mostrar por ventana
		JButton btnMostrarVentana = new JButton("Mostrar por ventana");
		btnMostrarVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					InterfazMenu menu = new InterfazMenu();
					menu.iniciarMenu();
			}
		});
		btnMostrarVentana.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMostrarVentana.setBounds(94, 145, 276, 58);
		contentPane.add(btnMostrarVentana);
		
		
	}
}
