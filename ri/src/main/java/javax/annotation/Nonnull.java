package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@TypeQualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, 
	ElementType.METHOD, 
	ElementType.PARAMETER, 
	ElementType.LOCAL_VARIABLE,
	ElementType.TYPE_USE})
public @interface Nonnull {
    When when() default When.ALWAYS;

    static class Checker implements TypeQualifierValidator<Nonnull> {

        public @Nonnull When forConstantValue(@Nonnull Nonnull qualifierqualifierArgument,
                Object value) {
            if (value == null)
                return When.NEVER;
            return When.ALWAYS;
        }
    }
}

