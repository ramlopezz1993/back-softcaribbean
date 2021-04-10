package co.com.softcaribbean.pruebasoftcaribbean.utilidades;

import javax.persistence.AttributeConverter;

public class GeneroConverter implements AttributeConverter<GeneroEnum, String> {
    @Override
    public String convertToDatabaseColumn(GeneroEnum generoEnum) {
        return generoEnum != null ? generoEnum.getCodigo() : null;
    }

    @Override
    public GeneroEnum convertToEntityAttribute(String codigo) {
        return codigo !=null ? GeneroEnum.obtenerGeneroPorCodigo(codigo) : null;
    }
}
