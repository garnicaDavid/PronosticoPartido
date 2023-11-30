package interfazGrafica;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import principal.Logica;
import principal.Persona;

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
	private JTextField txtPuesto;

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
				String titulos[] = {"Puesto","Participante", "Puntaje"};
				modeloTabla.setColumnIdentifiers(titulos);
				
				
				Logica logica = new Logica();
				ArrayList<Persona> listaPersona = new ArrayList<Persona>(logica.leerDesdeSql());
				logica.ordenarPorPuntos(listaPersona);
				int puesto =1;
				for (Persona persona : listaPersona) {
					Object[] objeto = {"         "+puesto,"  "+persona.getNombre(),"       "+persona.getPuntaje()};
					modeloTabla.addRow(objeto);
					puesto++;
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
		
		txtPuesto = new JTextField();
		txtPuesto.setText("Puesto");
		txtPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuesto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPuesto.setEditable(false);
		txtPuesto.setColumns(10);
		txtPuesto.setBounds(20, 154, 100, 30);
		contentPane.add(txtPuesto);
		
		textPuntaje = new JTextField();
		textPuntaje.setEditable(false);
		textPuntaje.setText("Puntaje");
		textPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		textPuntaje.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textPuntaje.setColumns(10);
		textPuntaje.setBounds(220, 154, 100, 30);
		contentPane.add(textPuntaje);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textNombre.setText("Nombre");
		textNombre.setBounds(119, 154, 100, 30);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255,0));
		panel.setBounds(20, 185, 300, 188);
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
		tablaPuntajes.setBounds(0, 0, 300, 90);
		panel.add(tablaPuntajes);
		
		lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon("img\\puntajes.jpg"));
		lblImagen.setBounds(0, 0, 624, 461);
		contentPane.add(lblImagen);
	}
}
