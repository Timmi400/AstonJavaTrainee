public class MyLinkedList <T> {
        private static class Node<T> {
            T element;
            Node<T> next;

            Node(T element) {
                this.element = element;
                next = null;
            }
        }

        private Node<T> head;
        private int size;

        public MyLinkedList() {
            head = null;
            size = 0;
        }

        /**
         * Добавляет элемент в конец списка
         */
        public void add(T element) {
            Node<T> newNode = new Node<>(element);
            if (head == null) {
                head = newNode;
            } else {
                Node<T> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
        }

        /**
         * Удаляет элемент по указанному индексу
         */
        public void remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            if (index == 0) {
                head = head.next;
            } else {
                Node<T> current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                current.next = current.next.next;
            }
            size--;
        }

        /**
         * Возвращает элемент по указанному индексу
         */
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            return current.element;
        }

        /**
         * Заменяет элемент по указанному индексу новым элементом
         */
        public void set(int index, T element) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.element = element;
        }

    }

