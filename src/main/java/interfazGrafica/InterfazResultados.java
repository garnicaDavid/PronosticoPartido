package interfazGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import principal.Logica;

import javax.swing.JList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazResultados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void IniciarResultados() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazResultados frame = new InterfazResultados();
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
	public InterfazResultados() {
		//metodo de cuando se abre le ventana.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarTabla();
			}

			private void cargarTabla() {
				//definir la tabla
				DefaultTableModel tabla = new DefaultTableModel(){
					public boolean isCellEditable(int row, int column){
						//este metodo hace que todas las filas y columnas no sean editables
						return false;
					}
				};
				//nombre de las columnas
				String titulos[] = {"Equipo 1", "Goles 1", "Goles 2", "Equipo 2"};
				tabla.setColumnIdentifiers(titulos);
				Logica logica = new Logica();
				logica.leerDesdeSql();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 22, 254, 348);
		contentPane.add(panel);
		panel.setLayout(null);
		//cree la tabla
		table = new JTable();
		table.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		table.setBounds(41, 22, 187, 279);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\David\\eclipse-workspace\\JsonProyect\\resultados.jpg"));
		lblNewLabel.setBounds(0, 0, 640, 500);
		contentPane.add(lblNewLabel);
	}
}
