/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
/**
 *
 * @author HILTER
 */
public class Venta {
    String Cliente;
    String RUC;
    String Producto;
    int cantidad;
    double precio;
    LocalDateTime fechaHora;

    public Venta(String nombreCliente, String numeroRUC, String Producto, int cantidad) {
        this.Cliente = nombreCliente;
        this.RUC = numeroRUC;
        this.fechaHora = LocalDateTime.now();
        this.Producto = Producto;
        this.cantidad = cantidad;
        this.precio = Precio(Producto);
    }

    public String getCliente() {
        return Cliente;
    }

    public String getRUC() {
        return RUC;
    }

    public String getProducto() {
        return Producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    
    public double Precio(String nombreProducto) {
        switch (nombreProducto) {
            case "Lavadora":
                return 1500.00;
            case "Refrigeradora":
                return 3500.00;
            case "Licuadora":
                return 500.00;
            case "Extractor":
                return 150.00;
            case "Radiograbadora":
                return 750.00;
            case "DVD":
                return 100.00;
            case "Blue Ray":
                return 250.00;
            default:
                return 0.00;
        }
    }
    
    // Método para calcular el subtotal
    public double calcularSubtotal() {
        return precio * cantidad;
    }
}
