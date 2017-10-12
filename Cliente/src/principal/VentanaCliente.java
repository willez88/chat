package principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gestorCliente.HiloCliente;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;

/*
 * Esta parte del programa crea a los nuevos clientes para luego que
 * luego se conecten al servidor, el servidor debe estar corriendo
 */

public class VentanaCliente extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private HiloCliente cliente=null;
	private JButton btnButton1;
    private JButton btnButton2;
    private JLabel lblLabel1;
    private JLabel lblLabel2;
    private JLabel lblLabel3;
    private JList<String> jList1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    
    public VentanaCliente() {
    	setTitle("Chat");
    	lblLabel1 = new JLabel();
    	lblLabel1.setToolTipText("<html>Para salir del cliente,<P><html> desconectarse y luego cerrar la ventana<P>");
    	lblLabel1.setForeground(new Color(0, 128, 0));
        lblLabel2 = new JLabel();
        jTextField1 = new JTextField();
        lblLabel3 = new JLabel();
        jTextField2 = new JTextField();
        btnButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jScrollPane2 = new JScrollPane();
        jList1 = new JList<String>();
        btnButton2 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        lblLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        
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
				JOptionPane.showMessageDialog(null, "Programa Cliente creado por:\nWilliam Paez\nSyra Lacruz");
			}
		});
		mnAyuda.add(mntmAcercaDe);
        
        lblLabel1.setText("Cliente");

        lblLabel2.setText("Puerto");

        jTextField1.setText("4040");

        lblLabel3.setText("URL");

        jTextField2.setText("Introduzca IP");

        btnButton1.setText("Conectar");
        btnButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jTextField4.setText("Usuario");

        jScrollPane2.setViewportView(jList1);

        btnButton2.setText("Desconectar");
        btnButton2.setEnabled(false);
        btnButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        setLocation(400,250);
        
        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblLabel1)
                    .add(layout.createSequentialGroup()
                        .add(btnButton1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnButton2))
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTextField4)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                        .add(lblLabel2)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(lblLabel3)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(lblLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblLabel2)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lblLabel3)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnButton1)
                    .add(btnButton2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jScrollPane2)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (cliente!=null){
            cliente.enviarTrama(3, "");
            cliente.interrupt();
        }
        cliente = null;
        btnButton1.setEnabled(true);
        btnButton2.setEnabled(false);
        lista.removeAllElements();
        jTextArea1.setText("");
    }                                        

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode()==10){
            cliente.enviarMensaje(jTextField3.getText());
            jTextField3.setText("");
        }
    }                                      

    DefaultListModel<String> lista=new DefaultListModel<String>();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        jList1.setModel(lista);
        try{
            int puerto = Integer.parseInt(jTextField1.getText());
            String ip = jTextField2.getText();
            String usuario = jTextField4.getText();
            if (cliente==null){
                cliente = new HiloCliente(puerto, ip, usuario, this);
                cliente.start();
            }
            btnButton1.setEnabled(false);
            btnButton2.setEnabled(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Error en la entrada de datos");
            cliente=null;
        }
    }                                        
    
    public void mensajeRecibido(String sMensaje){
        jTextArea1.append(sMensaje + "\n");
    }
    
    public void nuevaPersona(String usuario){
        lista.addElement(usuario);
    }
    
    public void borrarPersona(int nPos){
        lista.remove(nPos);
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCliente().setVisible(true);
            }
        });
    }
}
