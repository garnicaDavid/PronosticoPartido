package interfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import principal.Lectura;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

public class InterfazResultados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaResultado;
	private JTextField textEquipo1;
	private JTextField textGol1;
	private JTextField textGol2;
	private JTextField textEquipo2;

	/**
	 * Launch the application.
	 */
	public void IniciarResultados() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazResultados frame = new InterfazResultados();
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
	public InterfazResultados() {
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
				String titulos[] = {"Equipo 1", "Goles 1", "Goles 2", "Equipo 2"};
				modeloTabla.setColumnIdentifiers(titulos);
				Lectura lectura = new Lectura();
				ArrayList<String> resultado = new ArrayList<>(lectura.getLecturaResultado());
				String vector[];
				for(String linea : resultado) {
					vector= linea.split(" ");
					Object[] objeto = {vector[0],"             "+vector[1],"             "+vector[2],vector[3]};
					modeloTabla.addRow(objeto);
				}
				tablaResultado.setModel(modeloTabla);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 654, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192,0));
		panel.setBounds(29, 31, 574, 437);
		contentPane.add(panel);
		panel.setLayout(null);
		//cree la tabla
		tablaResultado = new JTable();
		tablaResultado.setEnabled(false);
		tablaResultado.setRowMargin(2);
		tablaResultado.setRowHeight(25);
		tablaResultado.setAutoCreateRowSorter(true);
		tablaResultado.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		tablaResultado.setEditingRow(0);
		tablaResultado.setEditingColumn(0);
		tablaResultado.setIntercellSpacing(new Dimension(0, 0));
		tablaResultado.setFocusable(false);
		tablaResultado.setFocusTraversalKeysEnabled(false);
		tablaResultado.setGridColor(new Color(192, 192, 192));
		tablaResultado.setUpdateSelectionOnSort(false);
		tablaResultado.setVerifyInputWhenFocusTarget(false);
		tablaResultado.setColumnSelectionAllowed(true);
		tablaResultado.setRequestFocusEnabled(false);
		tablaResultado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaResultado.setForeground(new Color(0, 0, 0));
		tablaResultado.setBounds(56, 82, 468, 250);
		tablaResultado.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		tablaResultado.setBackground(new Color(255, 255, 255,150));
		tablaResultado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		tablaResultado.setFont(new Font("Calibri", Font.PLAIN, 18));
		tablaResultado.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		panel.add(tablaResultado);
		
		textEquipo1 = new JTextField();
		textEquipo1.setEditable(false);
		textEquipo1.setHorizontalAlignment(SwingConstants.CENTER);
		textEquipo1.setText("Equipo 1");
		textEquipo1.setBounds(56, 55, 117, 26);
		panel.add(textEquipo1);
		textEquipo1.setColumns(10);
		
		textGol1 = new JTextField();
		textGol1.setEditable(false);
		textGol1.setText("Gol 1");
		textGol1.setHorizontalAlignment(SwingConstants.CENTER);
		textGol1.setColumns(10);
		textGol1.setBounds(172, 55, 117, 26);
		panel.add(textGol1);
		
		textGol2 = new JTextField();
		textGol2.setEditable(false);
		textGol2.setText("Gol 2");
		textGol2.setHorizontalAlignment(SwingConstants.CENTER);
		textGol2.setColumns(10);
		textGol2.setBounds(289, 55, 117, 26);
		panel.add(textGol2);
		
		textEquipo2 = new JTextField();
		textEquipo2.setEditable(false);
		textEquipo2.setText("Equipo 2");
		textEquipo2.setHorizontalAlignment(SwingConstants.CENTER);
		textEquipo2.setColumns(10);
		textEquipo2.setBounds(407, 55, 117, 26);
		panel.add(textEquipo2);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBackground(new Color(0, 128, 192));
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\ProyectoPronostico\\img\\resultados.jpg"));
		lblImagen.setBounds(0, 0, 640, 500);
		contentPane.add(lblImagen);
	}
}
