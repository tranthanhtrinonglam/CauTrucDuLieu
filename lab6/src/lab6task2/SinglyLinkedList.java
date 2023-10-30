package lab6task2;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.getData();
	}

	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getData();
	}

	public void addFirst(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}

	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size++;
	}

	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		E removedData = head.getData();
		head = head.getNext();
		size--;

		if (isEmpty()) {
			tail = null;
		}

		return removedData;
	}

	public E removeLast() {
		if (isEmpty()) {
			return null;
		}

		E removedData = tail.getData();

		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node<E> current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			tail = current;
			tail.setNext(null);
		}

		size--;

		return removedData;
	}
}