package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.fatecpg.lista.model.Aluno;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private JTextField txt_nome;
    private JTextField txt_telefone;

    public static ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame1 frame = new JFrame1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrame1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btn_listar = new JButton("Listar");
        btn_listar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame2 frame2 = new JFrame2();
                frame2.setVisible(true);
            }
        });
        btn_listar.setBounds(335, 227, 89, 23);
        contentPane.add(btn_listar);

        JLabel lblNewLabel = new JLabel("CADASTRO");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(138, 26, 162, 14);
        contentPane.add(lblNewLabel);

        txt_nome = new JTextField();
        txt_nome.setBounds(149, 87, 138, 20);
        contentPane.add(txt_nome);
        txt_nome.setColumns(10);

        txt_telefone = new JTextField();
        txt_telefone.setBounds(149, 143, 138, 20);
        contentPane.add(txt_telefone);
        txt_telefone.setColumns(10);

        JButton btn_cadastrar = new JButton("Cadastrar");
        btn_cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txt_nome.getText();
                String telefone = txt_telefone.getText();
                if (!nome.isEmpty() && !telefone.isEmpty()) {
                    listaAlunos.add(new Aluno(nome, telefone));
                    JOptionPane.showMessageDialog(btn_cadastrar, "Cadastrado com Sucesso!");
                    txt_nome.setText("");
                    txt_telefone.setText("");
                } else {
                    JOptionPane.showMessageDialog(btn_cadastrar, "Campos Vazios!");
                }
            }
        });
        btn_cadastrar.setBounds(170, 186, 101, 23);
        contentPane.add(btn_cadastrar);
        
        JLabel lblNewLabel_1 = new JLabel("Nome do Aluno");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(174, 67, 89, 14);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Telefone do Aluno");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(162, 123, 113, 14);
        contentPane.add(lblNewLabel_1_1);
    }
}
