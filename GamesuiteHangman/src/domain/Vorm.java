package domain;

import domain.interfaces.Drawable;

public abstract class Vorm implements Drawable {

	public abstract boolean equals(Object object);

	public abstract Omhullende getOmhullende();

}
