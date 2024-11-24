package cep;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Sobre dialog = new Sobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/171452_map_location_pin_icon.png")));
		setBackground(new Color(255, 255, 255));
		setBounds(150, 150, 450, 300);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Buscar CEP v- 1.0");
			lblNewLabel.setBounds(10, 41, 133, 13);
			getContentPane().add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("@Author: Nicolas França Castro Rosa");
			lblNewLabel_1.setBounds(10, 75, 221, 13);
			getContentPane().add(lblNewLabel_1);
		}
		{
			JButton btnGithub = new JButton("");
			btnGithub.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					link("https://github.com/Nicolas-rosa");
				}
			});
			btnGithub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnGithub.setIcon(new ImageIcon(Sobre.class.getResource("/img/github.png")));
			btnGithub.setToolTipText("Github");
			btnGithub.setBorder(null);
			btnGithub.setBackground(new Color(255, 255, 255));
			btnGithub.setBounds(119, 183, 64, 64);
			getContentPane().add(btnGithub);
		}
		{
			JButton btnLinkedin = new JButton("");
			btnLinkedin.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					link("https://www.linkedin.com/in/nicolas-rosa-775378308/");
				}
			});
			btnLinkedin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnLinkedin.setToolTipText("Linkedin");
			btnLinkedin.setIcon(new ImageIcon(Sobre.class.getResource("/img/linkedin.png")));
			btnLinkedin.setBorder(null);
			btnLinkedin.setBackground(Color.WHITE);
			btnLinkedin.setBounds(262, 183, 64, 64);
			getContentPane().add(btnLinkedin);
		}
		}
		private void link(String site) {
		Desktop desktop = Desktop.getDesktop();
		try{
			URI uri = new URI(site);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
