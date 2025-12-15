package com.duoc.SalmonttApp.ui;

import com.duoc.SalmonttApp.Data.GestorEntidades;
import com.duoc.SalmonttApp.model.*;

import javax.swing.*;
import java.awt.*;

public class MainUI extends JFrame {

    private JComboBox<String> comboTipo;
    private JTextField txtNombre;
    private JTextField txtExtra;
    private JTextArea areaResultado;
    private GestorEntidades gestor;

    public MainUI() {
        gestor = new GestorEntidades();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Sistema Salmontt Spa - Gestión de Entidades");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //  Panel superior
        JLabel titulo = new JLabel("Gestión de Entidades Salmontt", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titulo, BorderLayout.NORTH);

        //  Panel central (formulario)
        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));

        form.setBackground(new Color(187, 222, 251)); // #BBDEFB


        form.add(new JLabel("Tipo de entidad:"));
        comboTipo = new JComboBox<>(new String[]{"Proveedor", "Empleado"});
        form.add(comboTipo);

        form.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        form.add(txtNombre);

        form.add(new JLabel("Rubro / Cargo:"));
        txtExtra = new JTextField();
        form.add(txtExtra);

        JButton btnAgregar = new JButton("Agregar Entidad");
        JButton btnMostrar = new JButton("Mostrar Entidades");

        form.add(btnAgregar);
        form.add(btnMostrar);

        panel.add(form, BorderLayout.CENTER);

        // Panel inferior

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        panel.add(form, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        add(panel);

        // Eventos
        btnAgregar.addActionListener(e -> agregarEntidad());
        btnMostrar.addActionListener(e -> mostrarEntidades());

        panel.setBackground(new Color(227, 242, 253)); // #E3F2FD
        titulo.setForeground(new Color(21, 101, 192)); // #1565C0


    }

    private void agregarEntidad() {
        String tipo = (String) comboTipo.getSelectedItem();
        String nombre = txtNombre.getText();
        String extra = txtExtra.getText();

        if (nombre.isEmpty() || extra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return;
        }

        if (tipo.equals("Proveedor")) {
            gestor.agregarEntidad(new Proveedor(nombre, extra));
        } else {
            gestor.agregarEntidad(new Empleado(nombre, extra));
        }

        txtNombre.setText("");
        txtExtra.setText("");
        JOptionPane.showMessageDialog(this, "Entidad agregada correctamente");
    }

    private void mostrarEntidades() {
        areaResultado.setText(gestor.mostrarTodas());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainUI().setVisible(true);
        });
    }
}
