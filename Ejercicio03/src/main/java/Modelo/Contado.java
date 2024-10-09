/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author HILTER
 */
public class Contado extends Venta {

    private int n;

    public Contado(String Cliente, String RUC, String Producto, int cantidad, int N) {
        super(Cliente, RUC, Producto, cantidad); 
        this.n = N;
    }

    public int getN() {
        return n;
    }

    public void setN(int N) {
        this.n = N;
    }

    public double calculaDescuento(double subtotal) {
        double descuento = 0.0;
        if (subtotal < 1000) {
            descuento = subtotal * 0.05; 
        } else if (subtotal >= 1000 && subtotal <= 3000) {
            descuento = subtotal * 0.08;
        } else if (subtotal > 3000) {
            descuento = subtotal * 0.12;
        }
        return descuento;
    }
    
    public double calcularNeto() {
        double subtotal = calcularSubtotal();
        double descuento = calculaDescuento(subtotal);
        return subtotal - descuento;
    }

}
