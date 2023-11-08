package spring.modelo.validators;
//PARA CREAR UNA VALIDACION NEW/@ANNOTATION/V-RUNTIME/V-FIELD
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
//esta anotacion va a ser validada con la logica q exista en la clase BOOKCODEVALID 
@Constraint(validatedBy = BookCodeValid.class)
public @interface BookCodevalidator {
//mensaje q aparece en la validacion

	String message() default "Codigo inválido."
			+ "Debe contener exactamwnte 3 letras seguidas de 3 números.";
	
	
	Class<?>[] froups() default{};
	
	Class<? extends Payload>[] payload() default{};
//AGREGO LA VALIDACION AL DATO Q QUIERO VALIDAR EN ESTE CASO ES EL CODIGO DE LIBRO 
	//ME VOY A LibroDTO y coloco la valdiacion encima
}
