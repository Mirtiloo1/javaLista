package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.edu.fatecpg.lista.model.Aluno;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrame2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txt_nome;
    private JTextField txt_telefone;
    private JComboBox<Aluno> comboBox;
    private JButton btnAtualizar;
    private JButton btnExcluir;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame2 frame = new JFrame2();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrame2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        comboBox = new JComboBox<>(JFrame1.getListaAlunos().toArray(new Aluno[0]));
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
                if (alunoSelecionado != null) {
                    txt_nome.setText(alunoSelecionado.getNome());
                    txt_telefone.setText(alunoSelecionado.getTelefone());
                    btnAtualizar.setEnabled(true);
                    btnExcluir.setEnabled(true);
                }
            }
        });
        comboBox.setBounds(130, 50, 166, 22);
        contentPane.add(comboBox);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(130, 90, 100, 14);
        contentPane.add(lblNome);

        txt_nome = new JTextField();
        txt_nome.setBounds(130, 110, 166, 20);
        contentPane.add(txt_nome);
        txt_nome.setColumns(10);

        JLabel lblTelefone = new JLabel("Telefone");
        lblTelefone.setBounds(130, 140, 100, 14);
        contentPane.add(lblTelefone);

        txt_telefone = new JTextField();
        txt_telefone.setBounds(130, 160, 166, 20);
        contentPane.add(txt_telefone);
        txt_telefone.setColumns(10);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setEnabled(false);
        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
                if (alunoSelecionado != null) {
                    alunoSelecionado.setNome(txt_nome.getText());
                    alunoSelecionado.setTelefone(txt_telefone.getText());
                    JOptionPane.showMessageDialog(btnAtualizar, "Aluno atualizado com sucesso!");
                    atualizarComboBox();
                    limparCampos();
                }
            }
        });
        btnAtualizar.setBounds(124, 201, 88, 23);
        contentPane.add(btnAtualizar);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
                if (alunoSelecionado != null) {
                    int confirm = JOptionPane.showConfirmDialog(btnExcluir, "Deseja realmente excluir o aluno?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                        JFrame1.getListaAlunos().remove(alunoSelecionado);
                        JOptionPane.showMessageDialog(btnExcluir, "Aluno excluído com sucesso!");
                        atualizarComboBox();
                        limparCampos();
                    }
                }
            }
        });
        btnExcluir.setBounds(227, 201, 80, 23);
        contentPane.add(btnExcluir);
    }

    private void atualizarComboBox() {
        comboBox.removeAllItems();
        for (Aluno aluno : JFrame1.getListaAlunos()) {
            comboBox.addItem(aluno);
        }
    }

    private void limparCampos() {
        txt_nome.setText("");
        txt_telefone.setText("");
        btnAtualizar.setEnabled(false);
        btnExcluir.setEnabled(false);
    }
}
