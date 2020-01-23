package BLL;

import BEU.Curso;
import BEU.Estado;
import BEU.Estudiante;
import BEU.Matricula;
import Pachacama.BaseBllCrud;
import Pachacama.BasePersistencia;
import Pachacama.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionMatricula
        extends BasePersistencia<Matricula>
        implements BaseBllCrud<Matricula> {
    
    private Matricula matricula;
    private final String directorio = "matriculas";
    
    public GestionMatricula() {
    }
    
    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
    
    public String imrpimir() {
        return this.matricula.imprimirDetalle();
    }
    
    public String calificar(float valor) {
        String mensaje = "";
        int numero = this.matricula.addCalificacion(valor);
        switch (numero) {
            case 0:
                mensaje = "\t Todas las notas an sido registradas\n";
                break;
            case 1:
                mensaje = "\t Calificacion de la unidad I ingresada correctamente\n";
                break;
            case 2:
                mensaje = "\t Calificacion de la unidad II ingresada correctamente\n";
                break;
            case 3:
                mensaje = "\t Calificacion de la unidad III ingresada correctamente\n";
                break;
            default:
                mensaje = "\t Error. No se registro la calificacion \n";
                break;
        }
        return mensaje;
    }
    
    public void prmediar() {
        this.matricula.calcularPromedio();
    }
    
    public void anular(boolean op) {
        if (op == true) {
            matricula.setEstado(Estado.Anulada);
            Util.imprimir("\n\t Su matricula a sido anulada ");
            float valor = matricula.getCurso().getCosto() * 0.10f;
            Util.imprimir("\n\t Debe Pagar el 10 % del Rubro : $ " + valor);
        }
    }
    
    public void archivar() throws IOException {
        this.escribir(directorio, this.matricula.getNumero(), matricula);
    }
    
    public void configurar(Curso cr, Estudiante est) {
        this.matricula.setCurso(cr);
        this.matricula.setEstudiante(est);
        
    }
    
    public List<Matricula> reportar(String titulo) throws IOException {
        List<Matricula> resultado = new ArrayList<>();
        List<String> contenidos = this.leerDirectorio(directorio, titulo);
        for (String texto : contenidos) {
            GsonBuilder gb = new GsonBuilder();
            gb.setPrettyPrinting();
            Gson gson = gb.create();
            try {
                Matricula m = gson.fromJson(texto, Matricula.class);
                resultado.add(m);
            } catch (JsonSyntaxException e) {
                Util.imprimir("ERROR. No se pudo convertir en matricula" + e.toString());
            }
        }
        return resultado;
    }
    
    @Override
    public void crear() {
        matricula = new Matricula();
    }
    
    @Override
    public void consultar(String id) throws IOException {
        String archivo = id + ".json";
        String contenido = this.leer(directorio, archivo);
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        matricula = gson.fromJson(contenido, Matricula.class);
    }
    
    @Override
    public void actualizar(Matricula objeto) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void eliminiar(Matricula objeto) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
