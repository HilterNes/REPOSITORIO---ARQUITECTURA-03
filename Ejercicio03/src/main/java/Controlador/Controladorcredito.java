/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Credito;
import Vista.Productocredito;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HILTER
 */
public class Controladorcredito {

    Credito modelo;
    Productocredito vista;

    public Controladorcredito(Credito modelo, Productocredito vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void Producto() {

        String cantidad = vista.Cantidad().getText().trim();
        String cliente = vista.Cliente().getText().trim();
        String ruc = vista.Ruc().getText().trim();
        String producto = vista.SelectedProducto();
        if (cantidad.isEmpty() || cliente.isEmpty() || ruc.isEmpty() || producto == null) {
            JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.");
        return;
    }
        int cantidadComprada;
        try {
             cantidadComprada = Integer.parseInt(cantidad);
        } catch (NumberFormatException e) {
              JOptionPane.showMessageDialog(vista, "La cantidad debe ser un número entero.");
        return;
    }
        modelo = new Credito(cliente, ruc, producto, cantidadComprada, 0, 0);
        double precio = modelo.getPrecio();
        double subtotal = modelo.calcularSubtotal();
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.TablaProductos().getModel();
        int numeroFila = modeloTabla.getRowCount() + 1;
        modeloTabla.addRow(new Object[]{
        numeroFila,
        modelo.getProducto(),
        modelo.getCantidad(),
        precio,
        subtotal
    });
       limpiar();
    }

    public void Resumen() {
        try {
            int partes = Integer.parseInt(vista.Letras().getSelectedItem().toString());
            double subtotal = 0.0;
            DefaultTableModel modeloTabla = (DefaultTableModel) vista.TablaProductos().getModel();
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            subtotal += Double.parseDouble(modeloTabla.getValueAt(i, 4).toString());
    }
            Credito credito = new Credito("", "", "", 0, 0, partes);
            double montoMensual = credito.calculaMontoMensual(subtotal);
            DefaultTableModel modeloResumen = (DefaultTableModel) vista.TablaResumen().getModel();
            modeloResumen.setRowCount(0);
            modeloResumen.addRow(new Object[]{"Subtotal", String.format("%.2f", subtotal)});
            modeloResumen.addRow(new Object[]{"Letras", partes});
            modeloResumen.addRow(new Object[]{"Monto mensual", String.format("%.2f", montoMensual)});
            double descuento = modelo.calculaDescuento(subtotal);
            double netoAPagar = subtotal - descuento;
            vista.PagoNeto().setText(String.format("%.2f", netoAPagar));

        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(vista, "Ocurrió un error al calcular el resumen: " + e.getMessage());
        }
    }
    private void limpiar() {
        vista.TxtCantidad("");
        vista.Productos().setSelectedIndex(0);
    }
}
