package tpFinal.Services;
import tpFinal.Models.Empleado.PersonalLimpieza;
import tpFinal.Models.Usuario;
import tpFinal.Repositorios.EmpleadosRepository.PersonalLimpiezaRepository;

public class PersonalLimpiezaService implements IPersonalLimpiezaService{

    PersonalLimpiezaRepository personalLimpiezaRepository = new PersonalLimpiezaRepository();

    @Override
    public void listar() {
        personalLimpiezaRepository.listar().forEach(System.out::println);
    }

    @Override
    public void agregar(PersonalLimpieza objeto) {
        if(validateFields(objeto)){
            if((personalLimpiezaRepository.buscarPersonal(objeto.getDni())) == null){
                personalLimpiezaRepository.agregar(objeto);
            } else {
                System.out.println("El Usuario con dni " + objeto.getDni() + " ya existe");
            }
        }
    }

    @Override
    public void modificar(String dni) {
        personalLimpiezaRepository.modificar(dni);
    }

    @Override
    public void eliminar(String dni) {
        try{
            personalLimpiezaRepository.eliminar(dni);
        }catch (Exception e){
            System.out.println("No se encuentra el Personal en el archivo.");
        }
    }

    private boolean validateFields(Usuario personal){
        boolean validFields = true;
        if(!validateDni(personal.getDni())){
            //System.out.println("El formato para el dni es invalido");
            validFields = false;
        }
        if(!validateNombre(personal.getNombre())){
            //System.out.println("El formato para el nombre es invalido");
            validFields = false;
        }
        if(!validateApellido(personal.getApellido())){
            //System.out.println("El formato para el nombre es invalido");
            validFields = false;
        }
        if(!validateTelefono(personal.getTelefono())){
            //System.out.println("El formato para el teléfono es invalido");
            validFields = false;
        }
        return validFields;
    }

    private boolean validateDni(String dni){
        return dni.matches("[0-9]+");
    }

    private boolean validateTelefono(String telefono){
        return telefono.matches("[0-9]+");
    }

    private boolean validateNombre(String nombre){
        return nombre.matches("[a-zA-Z]+");
    }

    private boolean validateApellido(String apellido){
        return apellido.matches("[a-zA-Z]+");
    }
}