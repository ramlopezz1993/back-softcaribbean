package co.com.softcaribbean.pruebasoftcaribbean.utilidades.common;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.beans.FeatureDescriptor;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;
import java.util.stream.Stream;

@Component
public class AplicacionUtility {

    private AplicacionUtility(){

    }

    public static String[] obtenerListapropiedadesNulas(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null).toArray(String[]::new);
    }

    public static LocalDateTime convertirLongToLocalDateTime(Long fechaLong) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(fechaLong),
                TimeZone.getDefault().toZoneId());
    }
}
