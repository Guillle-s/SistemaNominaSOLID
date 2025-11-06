public abstract class Empleado {
    protected String nombre;
    protected double salarioBase;
    protected int aniosServicio;

    public Empleado(String nombre, double salarioBase, int aniosServicio) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.aniosServicio = aniosServicio;
    }

    public abstract double calcularSalario();

    public String getNombre() {
        return nombre;
    }
}
