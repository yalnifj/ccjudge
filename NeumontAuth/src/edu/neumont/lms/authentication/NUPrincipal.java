package edu.neumont.lms.authentication;

import java.io.Serializable;
import java.security.Principal;

public class NUPrincipal implements Principal, Serializable {
	private static final long serialVersionUID = 1L;
	private final String name;

	public NUPrincipal(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public boolean equals(Object o) {
		if (name != null && o != null)
			return name.equals(o);
		if (name == null && o == null)
			return true;
		return false;
	}
}
