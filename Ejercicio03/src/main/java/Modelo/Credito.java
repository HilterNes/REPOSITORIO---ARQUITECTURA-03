/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author HILTER
 */
public class Credito extends Venta {

    private int x;
    private int letras;

    public Credito(String Cliente, String RUC, String Producto, int cantidad, int Total, int letras) {
        super(Cliente, RUC, Producto, cantidad);
        this.x = Total;
        this.letras = letras;
    }

    public int getCantidadTotal() {
        return x;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.x = cantidadTotal;
    }

    public int getLetras() {
        return letras;
    }

    public void setLetras(int letras) {
        this.letras = letras;
    }

    public double calculaMontoInteres(double subtotal) {
        double interes = 0.0;
        if (letras <= 6) {
            interes = subtotal * 0.05; // 5% de interés
        } else if (letras <= 12) {
            interes = subtotal * 0.10; // 10% de interés
        } else {
            interes = subtotal * 0.15; // 15% de interés
        }
        return interes;
    }

    public double calculaMontoMensual(double subtotal) {
        double totalConInteres = subtotal + calculaMontoInteres(subtotal);
        return totalConInteres / letras;
    }

    public double calculaDescuento(double subtotal) {
        double descuento = 0.0;
        if (subtotal < 1000) {
            descuento = subtotal * 0.03; // 3% de descuento
        } else if (subtotal >= 1000 && subtotal < 3000) {
            descuento = subtotal * 0.05; // 5% de descuento
        } else {
            descuento = subtotal * 0.08; // 8% de descuento
        }
        return descuento;
    }

    public double calcularNeto() {
        double subtotal = calcularSubtotal();
        double descuento = calculaDescuento(subtotal);
        return subtotal - descuento;
    }
}
