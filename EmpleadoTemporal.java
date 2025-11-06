public class EmpleadoTemporal extends Empleado {

    public EmpleadoTemporal(String nombre, double salarioBase) {
        super(nombre, salarioBase, 0);
    }

    @Override
    public double calcularSalario() {
        return salarioBase - salarioBase * 0.08;
    }
}
