public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double tarifaHora;

    public EmpleadoPorHoras(String nombre, double tarifaHora, int horasTrabajadas) {
        super(nombre, 0, 0);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaHora = tarifaHora;
    }

    @Override
    public double calcularSalario() {
        double salario = 0;
        if (horasTrabajadas <= 160) {
            salario = horasTrabajadas * tarifaHora;
        } else {
            int extras = horasTrabajadas - 160;
            salario = (160 * tarifaHora) + (extras * tarifaHora * 1.5);
        }
        return salario - salario * 0.08;
    }
}
