import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


    public class MyArrayList<T> {
        private Object[] array;
        private int size;

        public MyArrayList() {
            array = new Object[10];
            size = 0;
        }

        /**
         * Добавляет элемент в конец списка
         */
        public void add(T element) {
            if (size == array.length) {
                Object[] newArray = new Object[array.length * 2];
                System.arraycopy(array, 0, newArray, 0, array.length);
                array = newArray;
            }

            array[size++] = element;
        }

        /**
         * Удаляет элемент по указанному индексу
         */
        public void remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }

            array[size - 1] = null;
            size--;
        }

        /**
         * Возвращает элемент по указанному индексу
         */
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            return (T) array[index];
        }

        /**
         * Заменяет элемент по указанному индексу новым элементом
         */
        public void set(int index, T element) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }

            array[index] = element;
        }

        /**
         * Возвращает подсписок списка в указанных пределах
         */
        public MyArrayList<T> subList(int fromIndex, int toIndex) {
            if (fromIndex < 0 || fromIndex >= size || toIndex < 0 || toIndex > size || fromIndex > toIndex) {
                throw new IndexOutOfBoundsException();
            }

            MyArrayList<T> subList = new MyArrayList<>();
            for (int i = fromIndex; i < toIndex; i++) {
                subList.add((T) array[i]);
            }

            return subList;
        }

        /**
         * Возвращает размер списка
         */
        public int size() {
            return size;
        }
    }

