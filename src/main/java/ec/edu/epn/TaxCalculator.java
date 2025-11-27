package ec.edu.epn;


/**
 * Clase para calcular impuestos sobre un monto.
 */
public class TaxCalculator{

/**
 * Calcula el total a pagar incluyendo el impuesto.
 * @param amount monto base
 * @param taxRate tasa de impuesto en porcentaje (0-100)
 * @return monto total incluyendo impuesto
 * @throws IllegalArgumentException si amount < 0 o taxRate < 0 o taxRate > 100
 */
    public double calculateTax(double amount, double taxRate){
        //validacion: si la tasa de impuesto es negativa, lanzar una excepcion
        if(taxRate < 0){
            throw new IllegalArgumentException("La tasa de impuesto no puede ser negativa.");
        }
        //validar que el monto no sea negativo
        if(amount < 0){
            throw new IllegalArgumentException("El monto no puede ser negativo.");
        }
        //calculo del impuesto
        double taxAmount = amount * taxRate / 100;
        return amount + taxAmount;

    }

}