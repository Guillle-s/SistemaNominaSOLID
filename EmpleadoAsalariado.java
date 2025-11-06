public class EmpleadoAsalariado extends Empleado {

    public EmpleadoAsalariado(String nombre, double salarioBase, int aniosServicio) {
        super(nombre, salarioBase, aniosServicio);
    }

    @Override
    public double calcularSalario() {
        double bono = (aniosServicio > 5) ? salarioBase * 0.10 : 0;
        double total = salarioBase + bono;
        return total - total * 0.08; // Salud + pensión (4% + 4%)
    }
}
