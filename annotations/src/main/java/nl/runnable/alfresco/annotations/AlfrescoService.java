package nl.runnable.alfresco.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Qualifier for distinguishing between different types of Alfresco services when autowiring dependencies by type.
 * <p>
 * This annotation should be used in conjunction with the {@link javax.inject.Inject} annotation.
 * <p>
 * Example:
 * 
 * <pre>
 * &#064;Inject
 * &#064;AlfrescoService(ServiceType.LOW_LEVEL)
 * // Wires in the low-level the &quot;categoryService&quot;
 * // (As opposed to the default, high-level &quot;CategoryService&quot;.)
 * private CategoryService categoryService;
 * </pre>
 * 
 * @author Laurens Fridael
 * 
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface AlfrescoService {

	ServiceType value() default ServiceType.DEFAULT;

}
