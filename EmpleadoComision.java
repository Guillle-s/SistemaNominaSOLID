public class EmpleadoComision extends Empleado {
    private double ventas;
    private double porcentajeComision;

    public EmpleadoComision(String nombre, double salarioBase, double ventas, double porcentajeComision) {
        super(nombre, salarioBase, 0);
        this.ventas = ventas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalario() {
        double total = salarioBase + (ventas * porcentajeComision);
        if (ventas > 20000000) {
            total += total * 0.03; // bono del 3%
        }
        return total - total * 0.08;
    }
}
