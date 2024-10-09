/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Contado;
import Vista.Productocontado;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author HILTER
 */
public class Controladorcontado {

    Contado modelo;
    Productocontado vista;

    public Controladorcontado(Contado modelo, Productocontado vista) {
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
        modelo = new Contado(cliente, ruc, producto, cantidadComprada, cantidadComprada);
        double precioUnitario = modelo.getPrecio();
        double subtotal = modelo.calcularSubtotal();
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.TablaProductos().getModel();
        int numeroFila = modeloTabla.getRowCount() + 1;

        modeloTabla.addRow(new Object[]{
        numeroFila,
        modelo.getProducto(),
        modelo.getCantidad(),
        precioUnitario,
        subtotal
     });
      limpiar();
      Resumen();
    }

    public void Resumen() {
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.TablaProductos().getModel();
        int rowCount = modeloTabla.getRowCount();
        double sumaSubtotal = 0;
        for (int i = 0; i < rowCount; i++) {
        sumaSubtotal += (double) modeloTabla.getValueAt(i, 4);
    }
        String cliente = modelo.getCliente();
        String ruc = modelo.getRUC();
        String fechaActual = java.time.LocalDate.now().toString();
        String horaActual = java.time.LocalTime.now().toString();
        double descuento = modelo.calculaDescuento(sumaSubtotal);
        double neto = sumaSubtotal - descuento;
        String resumen = "RESUMEN DE VENTA\n"
                + "---------------------------------------------\n"
                + "CLIENTE : " + cliente + "\n"
                + "RUC : " + ruc + "\n"
                + "FECHA : " + fechaActual + "\n"
                + "HORA : " + horaActual + "\n"
                + "----------------------------------------------\n"
                + "SUBTOTAL : " + sumaSubtotal + "\n"
                + "DESCUENTO : " + descuento + "\n"
                + "NETO : " + neto;

        vista.Resumen(resumen);
        vista.PagoNeto().setText(String.valueOf(neto));
    }

    private void limpiar() {
        vista.TxtCantidad("");
        vista.Productos().setSelectedIndex(0);
    }
}
