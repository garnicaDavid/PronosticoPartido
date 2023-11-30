package interfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class InterfazMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void iniciarMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazMenu frame = new InterfazMenu();
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
	public InterfazMenu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 640, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255,50));
		panel.setBounds(69, 92, 198, 253);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnPuntajes = new JButton("Puntajes");
		btnPuntajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					InterfazPuntajes puntajes = new InterfazPuntajes();
					puntajes.iniciarPuntajes();
					
			}
		});
		btnPuntajes.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		btnPuntajes.setBounds(10, 191, 178, 51);
		panel.add(btnPuntajes);
		
		JButton btnPronosticos = new JButton("Pronosticos");
		btnPronosticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					InterfazPronosticos pronosticos = new InterfazPronosticos();
					pronosticos.iniciarPronosticos();
			}
		});
		btnPronosticos.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		btnPronosticos.setBounds(10, 103, 178, 51);
		panel.add(btnPronosticos);
		
		JButton btnResultados = new JButton("Resultados");
		btnResultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					InterfazResultados resultados = new InterfazResultados();
					resultados.IniciarResultados();
			}
		});
		btnResultados.setFont(new Font("Leelawadee UI", Font.PLAIN, 18));
		btnResultados.setBounds(10, 11, 178, 51);
		panel.add(btnResultados);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\menu.jpg"));
		lblNewLabel.setBounds(0, 0, 624, 461);
		contentPane.add(lblNewLabel);
	}
}
