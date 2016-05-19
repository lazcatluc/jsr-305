package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@TypeQualifier(applicableTo = String.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, 
	ElementType.METHOD, 
	ElementType.PARAMETER, 
	ElementType.LOCAL_VARIABLE,
	ElementType.TYPE_USE})
public @interface MatchesPattern {
    @RegEx
    String value();

    int flags() default 0;

    static class Checker implements TypeQualifierValidator<MatchesPattern> {
        public @Nonnull When forConstantValue(@Nonnull MatchesPattern annotation, Object value) {
            Pattern p = Pattern.compile(annotation.value(), annotation.flags());
            if (p.matcher(((String) value)).matches())
                return When.ALWAYS;
            return When.NEVER;
        }

    }
}
