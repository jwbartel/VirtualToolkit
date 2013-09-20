package bus.uigen.widgets;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AMatrixMap<ElementType> implements MatrixMap<ElementType> {
	Map<String, ElementType> map = new HashMap();
	String toString(int aRow, int aCol) {
		return aRow + "," + aCol;
	}
	/* (non-Javadoc)
	 * @see util.models.TableMap#get(int, int)
	 */
	@Override
	public ElementType get(int aRow, int aColumn) {
		return map.get(toString(aRow, aColumn));
	}
	
	/* (non-Javadoc)
	 * @see util.models.TableMap#put(int, int, ElementType)
	 */
	@Override
	public ElementType put(int aRow, int aColumn, ElementType anElement) {
		return map.put(toString(aRow, aColumn), anElement);
	}
	
	/* (non-Javadoc)
	 * @see util.models.TableMap#values()
	 */
	@Override
	public Collection<ElementType> values() {
		return map.values();
	}
	
	/* (non-Javadoc)
	 * @see util.models.TableMap#keySet()
	 */
	@Override
	public Set<String> keySet() {
		return map.keySet();
	}
	

}
