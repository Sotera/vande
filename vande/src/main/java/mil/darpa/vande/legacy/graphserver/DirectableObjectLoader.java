package mil.darpa.vande.legacy.graphserver;

import java.util.List;

import mil.darpa.vande.DirectableObject;


@Deprecated
public interface DirectableObjectLoader<T extends DirectableObject, Q> {
	// setting in q where applicable
	List<T> pairQuery(Q q) throws Exception;

	List<T> getDestFor(String nbr, Q originalQuery) throws Exception;

	List<T> getSrcFor(String nbr, Q originalQuery) throws Exception;

}
