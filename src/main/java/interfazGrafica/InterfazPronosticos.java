package interfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import lectorSql.LeerDesdeBaseDeDatos;
import principal.Lectura;

import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class InterfazPronosticos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaPronostico;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public void iniciarPronosticos() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazPronosticos frame = new InterfazPronosticos();
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
	public InterfazPronosticos() {
			//metodo de cuando se abre le ventana.
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowOpened(WindowEvent e) {
					cargarTabla();
				}

				private void cargarTabla() {
						//definir la tabla
						DefaultTableModel modeloTabla = new DefaultTableModel(){
							
							/**
							 * 
							 */
							private static final long serialVersionUID = 1L;

							@Override
							public boolean isCellEditable(int row, int column){
								//este metodo hace que todas las filas y columnas no sean editables
								return false;
							}
						};
						//nombre de las columnas
						String titulos[] = {"Participante","Equipo 1", "Gana 1", "Empata", "Gana 2", "Equipo 2","Ronda","Fase"};
						modeloTabla.setColumnIdentifiers(titulos);
						
						LeerDesdeBaseDeDatos lectura = new LeerDesdeBaseDeDatos ();
						ArrayList<String> pronostico = new ArrayList<>(lectura.getPronosticosSql());
						
						//para leer desde txt descomentar lineas 79/80 y comentar lineas 75/76
						//Lectura lectura = new Lectura();
						//ArrayList<String> pronostico = new ArrayList<>(lectura.getLecturaPronostico());
						String vector[];
						int num1, num2;
						for(String linea : pronostico) {
							vector= linea.split(" ");
							num1 = Integer.valueOf(vector[1]);
							num2 = Integer.valueOf(vector[2]);
							if(num1 == 1) {
								vector[1] ="          X";
								vector[2] ="";
								vector[3] ="";
							} else if(num2 == 1) {
								vector[1] ="";
								vector[2] ="          X";
								vector[3] ="";
							} else {
								vector[1] ="";
								vector[2] ="";
								vector[3] ="          X";
							}
							Object[] objeto = {vector[5],vector[0],vector[1],vector[2],vector[3],vector[4],"         "+vector[6],"         "+vector[7]};
							modeloTabla.addRow(objeto);
						}
						tablaPronostico.setModel(modeloTabla);

				}
			});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 654, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(27, 65, 590, 286);
		contentPane.add(scrollPane);
		
		tablaPronostico = new JTable();
		tablaPronostico.setRowHeight(22);
		tablaPronostico.setEnabled(false);
		scrollPane.setViewportView(tablaPronostico);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\pronosticos.jpg"));
		lblNewLabel.setBounds(0, 0, 638, 499);
		contentPane.add(lblNewLabel);
		
	}
}
