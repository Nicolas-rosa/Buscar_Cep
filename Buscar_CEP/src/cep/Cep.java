package cep;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Cep extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel btnCEP;
	private JTextField textCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtcidade;
	private JComboBox cboUf;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep frame = new Cep();
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
	public Cep() {
		setTitle("Buscar CEP");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cep.class.getResource("/img/171452_map_location_pin_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		btnCEP = new JPanel();
		btnCEP.setBackground(new Color(255, 255, 255));
		btnCEP.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(btnCEP);
		btnCEP.setLayout(null);

		JLabel lblNewLabel = new JLabel("CEP");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 38, 34, 19);
		btnCEP.add(lblNewLabel);

		textCep = new JTextField();
		textCep.setBounds(76, 39, 96, 19);
		btnCEP.add(textCep);
		textCep.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setBounds(20, 86, 66, 13);
		btnCEP.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Bairro");
		lblNewLabel_2.setBounds(20, 127, 48, 19);
		btnCEP.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Cidade");
		lblNewLabel_3.setBounds(20, 180, 45, 13);
		btnCEP.add(lblNewLabel_3);

		JLabel labeluf = new JLabel("UF");
		labeluf.setBounds(265, 130, 45, 13);
		btnCEP.add(labeluf);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(96, 83, 151, 19);
		btnCEP.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(98, 127, 138, 19);
		btnCEP.add(txtBairro);
		txtBairro.setColumns(10);

		txtcidade = new JTextField();
		txtcidade.setBounds(97, 177, 96, 19);
		btnCEP.add(txtcidade);
		txtcidade.setColumns(10);

		JButton btnCep = new JButton("Pesquisar");
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textCep.getText().equals("")) {
					JOptionPane.showInternalMessageDialog(null, "Informe o CEP");
					textCep.requestFocus();

				} else {
					buscarCep();
				}
			}
		});
		btnCep.setBounds(213, 40, 96, 19);
		btnCEP.add(btnCep);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(329, 38, 85, 21);
		btnCEP.add(btnLimpar);

		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Cep.class.getResource("/img/372922_description_info_information_linecon_read_icon.png")));
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(new Color(255, 255, 255));
		btnSobre.setBounds(365, 205, 48, 48);
		btnCEP.add(btnSobre);

		RestrictedTextField validar = new RestrictedTextField(textCep);
		
		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboUf.setEditable(true);
		cboUf.setBounds(286, 126, 46, 21);
		btnCEP.add(cboUf);
		
		lblStatus = new JLabel("");
		
		lblStatus.setBounds(182, 37, 22, 22);
		btnCEP.add(lblStatus);
		validar.setLimit(8);
		validar.setOnlyNums(true);

	}/* Uso da Biblioteca Atxy2k para validação do campo textCep */

	private void buscarCep() {
		String logradouro = "";
		String tipologradouro = "";
		String resultado = null;
		String cep = textCep.getText();
		 try {
		        URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
		        SAXReader xml = new SAXReader(); // Cria a instância corretamente
		        org.dom4j.Document documento = xml.read(url);
		        Element root = documento.getRootElement(); // Obtém o elemento raiz
		        for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
		            Element element = it.next();
		            if (element.getQualifiedName().equals("cidade")) {
						txtcidade.setText(element.getText());
					}
					if (element.getQualifiedName().equals("bairro")) {
						txtBairro.setText(element.getText());
					}
					if (element.getQualifiedName().equals("uf")) {
						cboUf.setSelectedItem(element.getText());
					}
					if (element.getQualifiedName().equals("tipo_logradouro")) {
						tipologradouro = element.getText();
					}
					if (element.getQualifiedName().equals("logradouro")) {
						logradouro = element.getText();
					} 
					if(element.getQualifiedName().equals("resultado")) {
		        	resultado = element.getText();
		        	if (resultado.equals("1")) {
		        		lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png")));
		        	} else {
		        	JOptionPane.showMessageDialog(null, "Cep não encontrado");
		        	
		        	}
		       
					}
		        }
		        //setar o campo endereço
		        txtEndereco.setText(tipologradouro + " " + logradouro);
		     
		       
		}catch (Exception e){
			System.out.println(e);
		}
	}
	private void limpar() {
		textCep.setText(null);
		txtEndereco.setText(null);
		txtBairro.setText(null);
		txtcidade.setText(null);
		cboUf.setSelectedItem(null);
		textCep.requestFocus();
		lblStatus.setIcon(null);
	}
}// fim do construtor
