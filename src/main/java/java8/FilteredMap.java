package java8;

import java.util.*;
import java.util.function.Predicate;

public class FilteredMap extends AbstractMap<String, String> {

	public static void main(String[] args) {
		Map<String, String> delegate = new HashMap<>();
		delegate.put("dd", "c");
		delegate.put("dd1", "2c");
		FilteredMap filteredMap = new FilteredMap(delegate, (k) -> k.startsWith("pre"), "pre");
		System.out.println(filteredMap);
	}

	private final Map<String, String> delegate;
	private final Predicate<String> filter;
	private final String prefix;
	// we cache that size since we have to iterate the entire set
	// this is safe to do since this map is only used with unmodifiable maps
	private int size = -1;
	@Override
	public Set<Entry<String, String>> entrySet() {
		Set<Entry<String, String>> delegateSet = delegate.entrySet();
		AbstractSet<Entry<String, String>> filterSet = new AbstractSet<Entry<String, String>>() {

			@Override
			public Iterator<Entry<String, String>> iterator() {
				Iterator<Entry<String, String>> iter = delegateSet.iterator();

				return new Iterator<Entry<String, String>>() {
					private int numIterated;
					private Entry<String, String> currentElement;
					@Override
					public boolean hasNext() {
						if (currentElement != null) {
							return true; // protect against calling hasNext twice
						} else {
							if (numIterated == size) { // early terminate
								assert size != -1 : "size was never set: " + numIterated + " vs. " + size;
								return false;
							}
							while (iter.hasNext()) {
								if (filter.test((currentElement = iter.next()).getKey())) {
									numIterated++;
									return true;
								}
							}
							// we didn't find anything
							currentElement = null;
							return false;
						}
					}

					@Override
					public Entry<String, String> next() {
						if (currentElement == null && hasNext() == false) { // protect against no #hasNext call or not respecting it

							throw new NoSuchElementException("make sure to call hasNext first");
						}
						final Entry<String, String> current = this.currentElement;
						this.currentElement = null;
						if (prefix == null) {
							return current;
						}
						return new Entry<String, String>() {
							@Override
							public String getKey() {
								return current.getKey().substring(prefix.length());
							}

							@Override
							public String getValue() {
								return current.getValue();
							}

							@Override
							public String setValue(String value) {
								throw new UnsupportedOperationException();
							}
						};
					}
				};
			}

			@Override
			public int size() {
				return FilteredMap.this.size();
			}
		};
		return filterSet;
	}

	private FilteredMap(Map<String, String> delegate, Predicate<String> filter, String prefix) {
		this.delegate = delegate;
		this.filter = filter;
		this.prefix = prefix;
	}

	@Override
	public String get(Object key) {
		if (key instanceof String) {
			final String theKey = prefix == null ? (String)key : prefix + key;
			if (filter.test(theKey)) {
				return delegate.get(theKey);
			}
		}
		return null;
	}

	@Override
	public boolean containsKey(Object key) {
		if (key instanceof String) {
			final String theKey = prefix == null ? (String) key : prefix + key;
			if (filter.test(theKey)) {
				return delegate.containsKey(theKey);
			}
		}
		return false;
	}

	@Override
	public int size() {
		if (size == -1) {
			size = Math.toIntExact(delegate.keySet().stream().filter((e) -> filter.test(e)).count());
		}
		return size;
	}
}
