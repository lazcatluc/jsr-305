package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

@Documented
@TypeQualifierNickname
@Untainted(when = When.ALWAYS)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, 
	ElementType.METHOD, 
	ElementType.PARAMETER, 
	ElementType.LOCAL_VARIABLE,
	ElementType.TYPE_USE})
public @interface Detainted {

}
