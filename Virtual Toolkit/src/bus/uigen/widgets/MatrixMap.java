package bus.uigen.widgets;

import java.util.Collection;
import java.util.Set;

public interface MatrixMap<ElementType> {

	public ElementType get(int aRow, int aColumn);

	public ElementType put(int aRow, int aColumn, ElementType anElement);

	public Collection<ElementType> values();

	public Set<String> keySet();

}