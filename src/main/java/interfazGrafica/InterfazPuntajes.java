package interfazGrafica;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import principal.Lectura;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InterfazPuntajes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaPuntajes;
	private JLabel lblImagen;
	private JTextField textNombre;
	private JTextField textPuntaje;

	/**
	 * Launch the application.
	 */
	public void iniciarPuntajes() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPuntajes frame = new InterfazPuntajes();
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
	public InterfazPuntajes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarTabla();
			}

			private void cargarTabla(){
				//definir la tabla
				DefaultTableModel modeloTabla = new DefaultTableModel(){
					private static final long serialVersionUID = 1L;
					@Override
					public boolean isCellEditable(int row, int column){
						//este metodo hace que todas las filas y columnas no sean editables
						return false;
					}
				};
				//nombre de las columnas
				String titulos[] = {"Participante", "Puntaje"};
				modeloTabla.setColumnIdentifiers(titulos);
				Lectura lectura = new Lectura();
				ArrayList<String> puntajes = new ArrayList<>(lectura.getLecturaPuntaje());
				String vector[];
				for(String linea : puntajes) {
					vector = linea.split(" ");
					Object[] objeto = {"   "+vector[0], "       "+vector[1]};
					modeloTabla.addRow(objeto);
				}
				tablaPuntajes.setModel(modeloTabla);
			}
			
			
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPuntaje = new JTextField();
		textPuntaje.setEditable(false);
		textPuntaje.setText("Puntaje");
		textPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		textPuntaje.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPuntaje.setColumns(10);
		textPuntaje.setBounds(167, 155, 100, 30);
		contentPane.add(textPuntaje);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setText("Nombre");
		textNombre.setBounds(66, 155, 100, 30);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255,0));
		panel.setBounds(66, 185, 254, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tablaPuntajes = new JTable();
		tablaPuntajes.setForeground(new Color(0, 0, 0));
		tablaPuntajes.setEnabled(false);
		tablaPuntajes.setGridColor(new Color(0, 0, 0));
		tablaPuntajes.setRowMargin(0);
		tablaPuntajes.setRowHeight(30);
		tablaPuntajes.setFont(new Font("Calibri", Font.PLAIN, 20));
		tablaPuntajes.setBackground(new Color(255, 215, 0, 100));
		tablaPuntajes.setBounds(0, 0, 200, 90);
		panel.add(tablaPuntajes);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\ProyectoPronostico\\img\\puntajes.jpg"));
		lblImagen.setBounds(0, 0, 624, 461);
		contentPane.add(lblImagen);
	}

}
