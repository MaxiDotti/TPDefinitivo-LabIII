package tpFinal.Services;

import tpFinal.Exceptions.BeneficioNuloException;
import tpFinal.Models.Beneficio;
import tpFinal.Repositorios.BeneficioRepository;
import tpFinal.Utilities.Validations;

import java.util.List;

public class BeneficioService implements IBeneficioService{

    BeneficioRepository beneficioRepository = new BeneficioRepository();
    Validations validations = new Validations();

    @Override
    public List<Beneficio> listar() {
        beneficioRepository.cargar();
        return beneficioRepository.listar();
    }

    @Override
    public void agregar(Beneficio beneficio) {
        try{
            if(validations.validarBeneficio(beneficio)){
                beneficioRepository.cargar();
                beneficioRepository.agregar(beneficio);
            }
            beneficioRepository.guardar();
        }catch(BeneficioNuloException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void modificar(Beneficio beneficio) {
        try {
            beneficioRepository.cargar();
            if(validations.validarBeneficio(beneficio)){
                beneficioRepository.modificar(beneficio);
            }
            beneficioRepository.guardar();
        }catch (BeneficioNuloException e){
            System.out.println(e.getMensaje());
        }
    }

    @Override
    public void eliminar(Beneficio beneficio) {
        try{
            beneficioRepository.cargar();
            if(validations.validarBeneficio(beneficio)){
                beneficioRepository.eliminar(beneficio.getId());
            }
            beneficioRepository.guardar();
        }catch (BeneficioNuloException e) {
            System.out.println(e.getMensaje());
        }
    }
}
