package lab6task1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// tạo ra một mảng có kích thước gấp đôi nếu mảng của các phần tử đã đầy đủ
	public void growSize() {
		int newCapacity = elements.length * 2;
		E[] newElements = (E[]) new Object[newCapacity];
		System.arraycopy(elements, 0, newElements, 0, size);
		elements = newElements;
	}

	// Trả về số phần tử trong danh sách này
	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return false;
	}

	// Trả về (nhưng không loại bỏ) phần tử tại chỉ mục i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		return elements[i];
	}

	// Thay thế phần tử tại chỉ mục i bằng e và trả về phần tử được thay thế
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		E replacedElement = elements[i];
		elements[i] = e;
		return replacedElement;
	}

	// Nó được sử dụng để nối phần tử được chỉ định vào cuối một danh sách.

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size] = e;
		size++;
		return true;
	}

	// Chèn phần tử e vào chỉ mục i, dịch chuyển tất cả các phần tử tiếp theo sau
	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		if (size == elements.length) {
			growSize();
		}

		// dich chuyen cac phan tu tiep theo
		for (int j = size; j > i; j--) {
			elements[j] = elements[j - 1];
		}

		elements[i] = e;
		size++;
	}

	// Loại bỏ và trả về phần tử tại chỉ mục i,dịch chuyển các phần tử tiếp theo
	// trước đó.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}

		E removedElement = elements[i];

		// dich chuyen cac phan tu tiep theo
		for (int j = i; j < size - 1; j++) {
			elements[j] = elements[j + 1];
		}

		elements[size - 1] = null;
		size--;

		return removedElement;
	}

// Nó được sử dụng để xóa tất cả các phần tử trong danh sách
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	// Nó được sử dụng để trả về chỉ mục trong danh sách này lần xuất hiện cuối cùng
	// của phần tử được chỉ định hoặc -1 nếu danh sách không chứa phần tử này.
	public int lastIndexOf(E e) {
		int re = -1;
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(e)) {

			}
		}
		return re;
	}
	 public E[] toArray() {
	        // Create a new array and copy elements
	        E[] newArray = (E[]) new Object[size];
	        System.arraycopy(elements, 0, newArray, 0, size);
	        return newArray;
	    }
	  public MyArrayList<E> clone() {
	        MyArrayList<E> cloneList = new MyArrayList<>(size);
	        System.arraycopy(elements, 0, cloneList.elements, 0, size);
	        cloneList.size = size;
	        return cloneList;
	    }
	  public boolean contains(E o) {
	        return indexOf(o) >= 0;
	    }
	  public int indexOf(E o) {
	        for (int i = 0; i < size; i++) {
	            if (o == null ? elements[i] == null : o.equals(elements[i])) {
	                return i;
	            }
	        }
	        return -1;
	    }
	  public boolean remove(E e) {
	        int index = indexOf(e);
	        if (index >= 0) {
	            remove(index);
	            return true;
	        }
	        return false;
	    }
	  public void sort(Comparator<E> c) {
	        Arrays.sort(elements, 0, size, c);
	    }
	  
}
