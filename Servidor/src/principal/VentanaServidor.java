package principal;

import gestorServidor.HiloServidor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Esta parte del programa arranca el servidor a la espere de que
 * se conecten nuevos clientes
 */
public class VentanaServidor extends javax.swing.JFrame {
    
	private static final long serialVersionUID = 1L;
	private HiloServidor servidor = null;
	private JButton btnButton1;
    private JLabel lblLabel1;
    private JLabel lblLabel2;
    private JTextField jTextField1;
	
    public VentanaServidor() {
    	setTitle("Servidor");
    	lblLabel1 = new JLabel();
    	lblLabel1.setToolTipText("<html>Para detener el servidor<P><html>basta con cerrar la ventana<P>");
    	lblLabel1.setForeground(new Color(0, 128, 0));
        lblLabel2 = new JLabel();
        jTextField1 = new JTextField();
        btnButton1 = new JButton();
        btnButton1.setToolTipText("<html>abre el puerto<P><html>e inicia el servidor<P>");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mnArchivo.add(mntmSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca del Programa");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Servidor creado por:\nWilliam Paez\nSyra Lacruz");
			}
		});
		mnAyuda.add(mntmAcercaDe);
		
        lblLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        lblLabel1.setText("Servidor");

        lblLabel2.setText("Puerto");

        jTextField1.setText("4040");

        btnButton1.setText("Abrir Puerto");
        btnButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setLocation(500,250);
        
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblLabel1)
                    .add(layout.createSequentialGroup()
                        .add(lblLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(btnButton1))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblLabel2)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnButton1)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (servidor==null){
            int puerto = Integer.parseInt(jTextField1.getText());
            servidor = new HiloServidor(this, puerto);
            servidor.start();
            JOptionPane.showMessageDialog(null, "Se ha establecido la conexion");
        }
    }                                        
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaServidor().setVisible(true);
            }
        });
    }
}
