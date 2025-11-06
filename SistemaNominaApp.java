import java.util.*;
import javax.swing.JOptionPane;

public class SistemaNominaApp {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        NominaCalculator calculadora = new NominaCalculator();

        while (true) {
            String menu = "🏢 SISTEMA DE NÓMINA\n\n"
                    + "1️⃣ Registrar Empleado Asalariado\n"
                    + "2️⃣ Registrar Empleado por Horas\n"
                    + "3️⃣ Registrar Empleado por Comisión\n"
                    + "4️⃣ Registrar Empleado Temporal\n"
                    + "5️⃣ Mostrar Nómina Total\n"
                    + "6️⃣ Salir\n\n"
                    + "Seleccione una opción:";
            String opcionStr = JOptionPane.showInputDialog(menu);
            if (opcionStr == null) return; // Cancelar

            int opcion;
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1: // Asalariado
                    String n1 = JOptionPane.showInputDialog("Nombre del empleado:");
                    double s1 = Double.parseDouble(JOptionPane.showInputDialog("Salario base:"));
                    int a1 = Integer.parseInt(JOptionPane.showInputDialog("Años de servicio:"));
                    empleados.add(new EmpleadoAsalariado(n1, s1, a1));
                    JOptionPane.showMessageDialog(null, "Empleado asalariado agregado correctamente.");
                    break;

                case 2: // Por horas
                    String n2 = JOptionPane.showInputDialog("Nombre del empleado:");
                    double t2 = Double.parseDouble(JOptionPane.showInputDialog("Tarifa por hora:"));
                    int h2 = Integer.parseInt(JOptionPane.showInputDialog("Horas trabajadas:"));
                    empleados.add(new EmpleadoPorHoras(n2, t2, h2));
                    JOptionPane.showMessageDialog(null, "Empleado por horas agregado correctamente.");
                    break;

                case 3: // Por comisión
                    String n3 = JOptionPane.showInputDialog("Nombre del empleado:");
                    double s3 = Double.parseDouble(JOptionPane.showInputDialog("Salario base:"));
                    double v3 = Double.parseDouble(JOptionPane.showInputDialog("Ventas realizadas:"));
                    double p3 = Double.parseDouble(JOptionPane.showInputDialog("Porcentaje de comisión (ej: 0.05 para 5%):"));
                    empleados.add(new EmpleadoComision(n3, s3, v3, p3));
                    JOptionPane.showMessageDialog(null, "Empleado por comisión agregado correctamente.");
                    break;

                case 4: // Temporal
                    String n4 = JOptionPane.showInputDialog("Nombre del empleado:");
                    double s4 = Double.parseDouble(JOptionPane.showInputDialog("Salario mensual:"));
                    empleados.add(new EmpleadoTemporal(n4, s4));
                    JOptionPane.showMessageDialog(null, "Empleado temporal agregado correctamente.");
                    break;

                case 5: // Mostrar nómina
                    if (empleados.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay empleados registrados.");
                        break;
                    }
                    StringBuilder sb = new StringBuilder("📋 Nómina actual:\n\n");
                    for (Empleado e : empleados) {
                        sb.append(e.getNombre())
                          .append(" → $")
                          .append(String.format("%,.2f", e.calcularSalario()))
                          .append("\n");
                    }
                    sb.append("\n💰 Total Nómina: $")
                      .append(String.format("%,.2f", calculadora.calcularTotalNomina(empleados)));
                    JOptionPane.showMessageDialog(null, sb.toString());
                    break;

                case 6: // Salir
                    JOptionPane.showMessageDialog(null, "Gracias por usar el Sistema de Nómina SOLID.\nDesarrollado por el grupo CIPA.");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}
