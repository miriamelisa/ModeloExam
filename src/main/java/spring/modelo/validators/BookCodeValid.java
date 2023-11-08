package spring.modelo.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
@Slf4j
//para usar los ConstrainValidator necesito colocar en el pomx las propieties
public class BookCodeValid implements ConstraintValidator<BookCodevalidator,String>{
	// es strign es el tipo de dato q yo voy a bvalidar como voy a validar un string pues coloco String
	private static final Pattern CODE_PATTERN = Pattern.compile("^[A-Za-z]{3}\\d{3}$");
	
	@Override
	public void initialize(BookCodevalidator constraintAnnotation) {}
	//logica de validacion 
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
		if (value==null) {
			return false;
		}
		Matcher master= CODE_PATTERN.matcher(value);
		
		// TODO Auto-generated method stub
		return Pattern.compile("^[A-Za-z]{3}\\d{3}$").matcher(value).matches();
	}
	

}
 