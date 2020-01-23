package BEU;

import Pachacama.Persona;
import Pachacama.Unidades;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Matricula {

    //Datos
    private final String numero;
    private final Calendar fecha;
    private Estado estado;
    private Persona estudiante;
    private Curso curso;
    private float promedio;//Información
    private final List<Calificacion> calificaciones = new ArrayList<>();

    public Matricula() {
        fecha = Calendar.getInstance();
        estado = Estado.Registrada;
        UUID numeroAleatorio = UUID.randomUUID();
        this.numero = numeroAleatorio.toString();
    }

    public String getNumero() {
        return numero;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Persona getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Persona estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public float getPromedio() {
        return promedio;
    }

    public void calcularPromedio() {
        if (this.calificaciones.isEmpty()) {
            return;
        }
        float suma = 0;
        for (Calificacion c : calificaciones) {
            suma += c.valor;//Se puede acceder al atributo porque es una clase interna
        }
        int divisor = this.calificaciones.size();
        promedio = (float) suma / (float) divisor;
        if (divisor == 3) {
            if (promedio > 14) {
                this.estado = Estado.Aprobada;
            } else {
                this.estado = Estado.Reprobada;
            }
        }
    }

    //este metodo agrega una calificaion y un numero dependiendo de la unidad 
    //1,2,3 y 0 si posee todas las notas
    public int addCalificacion(float v) {
        Calificacion cal = new Calificacion();
        int cuentaNotas = this.calificaciones.size();
        switch (cuentaNotas) {
            case 0:
                cal.setUnidad(Unidades.I);
                break;
            case 1:
                cal.setUnidad(Unidades.II);
                break;
            case 2:
                cal.setUnidad(Unidades.III);
                break;
            default:
                return 0;
        }
        cal.setValor(v);
        cal.setFecha(Calendar.getInstance());
        this.calificaciones.add(cal);
        this.calcularPromedio();
        return this.calificaciones.size();
    }

    @Override
    public String toString() {
        return estudiante.toString() + " # " + numero;
    }

    public String imprimirDetalle() {
        String str = "Número: " + this.numero + "\nEstudiante: " + this.estudiante.getNombre() + " " + this.estudiante.getApellido()
                + "\nCurso: " + this.curso.getTitulo() + "\nCalificaciones: ";
        for (Calificacion c : calificaciones) {
            str += " " + c.getValor() + " ";
        }
        str += "\nPromedio: " + this.promedio + "\n";
        return str;
    }

    class Calificacion {

        private Calendar fecha;
        private float valor;
        private Unidades unidad;

        public Calificacion() {
        }

        public Calendar getFecha() {
            return fecha;
        }

        public void setFecha(Calendar fecha) {
            this.fecha = fecha;
        }

        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public Unidades getUnidad() {
            return unidad;
        }

        public void setUnidad(Unidades unidad) {
            this.unidad = unidad;
        }

    }

}
