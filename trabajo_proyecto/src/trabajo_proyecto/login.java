package trabajo_proyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setBounds(10, 78, 121, 33);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(127, 84, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setBounds(10, 136, 129, 18);
		contentPane.add(lblContrasea);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 135, 86, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String consulta = "select * from Clientes where NombreCliente="+ lblUsuario.getText() + "and PasswordCliente=" + lblContrasea.getText();
					PreparedStatement pst=connection.prepareStatement(consulta);
		
				ResultSet rs=  executeQuery();
				int count=0;
				while(rs.next()) {
					count=count+1;
				}// cierre del while
				if(count== 1) {
					
				JOptionPane.showMessageDialog(null, "El nombre y  la contraseña son correctos");
				frame.dispose();
				
				
			}// cierre del if
				
				
		});// fin de public void actionPerformed
		btnNewButton.setBounds(124, 184, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblFONDO = new JLabel("New label");
		lblFONDO.setIcon(new ImageIcon("C:\\Users\\aula2\\workspace\\trabajo_proyecto\\src\\trabajo_proyecto\\maxresdefault.jpg"));
		lblFONDO.setBounds(-156, 0, 580, 333);
		contentPane.add(lblFONDO);
		
			}catch (Exception e)
			
		
	}// fin del boton ENTRAR
}// fin de public login()
}// final finalisimo
