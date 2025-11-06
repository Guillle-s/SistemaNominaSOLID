import java.util.List;

public class NominaCalculator {

    public double calcularTotalNomina(List<Empleado> empleados) {
        double total = 0;
        for (Empleado e : empleados) {
            total += e.calcularSalario();
        }
        return total;
    }
}
