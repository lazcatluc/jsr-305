package javax.tools;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Require {
	public static <T> @Nonnull T nonnull(@Nullable T t) {
		if (t == null) {
			throw new NullPointerException();
		}
		return t;
	}
}
