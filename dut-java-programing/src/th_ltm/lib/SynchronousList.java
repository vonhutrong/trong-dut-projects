package th_ltm.lib;

import java.util.ArrayList;
import java.util.List;

public class SynchronousList {
	private List<IItem> mList = null;
	
	public SynchronousList() {
		mList = new ArrayList<>();
	}
	
	public synchronized boolean addItem(IItem item) {
		for (IItem i : mList) {
			if (item.equal(i))
				return false;
		}
		mList.add(item);
		return false;
	}

	public synchronized void removeItem(IItem item) {
		mList.remove(item);
	}

	public synchronized IItem getItem(Object obj) {
		for (IItem i : mList)
			if (i.equal(obj))
				return i;
		return null;
	}
}
