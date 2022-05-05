package com.company;

import com.company.Exceptions.NotFoubdElement;
import com.company.Exceptions.PassingNullToParameterException;
import com.company.Exceptions.StringOutOfBoundException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] arrayString;

    @Override
    public String[] getArrayString() {
        return arrayString;
    }

    public StringListImpl(int size) {
        this.arrayString = new String[size];
    }

    private void checkParametrs(String str) {
        if (str == null) {
            throw new PassingNullToParameterException("в качестве параметра передан null");
        }
    }

    private void checkParametrs(int number) {
        if (number < 0 || number >= arrayString.length) {
            throw new PassingNullToParameterException("в качестве параметра передано отрицательное " +
                    "число или индекс за пределами массива");
        }
    }

    private void createNewArrayWithDoubleLenght() {
        String[] newArrayString = new String[size() * 2];
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] != null) {
                newArrayString[i] = arrayString[i];
            }
        }
        arrayString = newArrayString;
    }


    @Override
    public String add(String item) {
        checkParametrs(item);
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] == null) {
                arrayString[i] = item;
                return item;
            } else if (size() == arrayString.length) {
                createNewArrayWithDoubleLenght();
            }
        }
        return null;
    }

    @Override
    public String add(int index, String item) {
        checkParametrs(index);
        checkParametrs(item);
        if (size() == arrayString.length) {
            createNewArrayWithDoubleLenght();
        }
        if (arrayString[index] == null) {
            arrayString[index] = item;
            return item;
        } else if (arrayString[index] != null) {
            for (int i = arrayString.length - 1; i > index; i--) {
                if (arrayString[i - 1] == null) {
                    continue;
                } else {
                    arrayString[i] = arrayString[i - 1];
                }
            }
            arrayString[index] = item;
            return item;
        }
        return null;
    }

    @Override
    public String set(int index, String item) {
        checkParametrs(index);
        checkParametrs(item);
        arrayString[index] = item;
        return arrayString[index];
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        if (index < 0) {
            throw new NotFoubdElement("такого элемента не существует");
        }
        return remove(index);
    }

    @Override
    public String remove(int index) {
        checkParametrs(index);
        if (arrayString[index] != null) {
            String result = arrayString[index];
            arrayString[index] = null;
            for (int i = index; i < arrayString.length - 1; i++) {
                arrayString[i] = arrayString[i + 1];
            }
            arrayString[arrayString.length-1]=null;
            String[]newArray=new String[size()];
            for (int j = 0; j < arrayString.length; j++) {
                if (arrayString[j] != null) {
                    newArray[j]=arrayString[j];
                }
            }
            arrayString=newArray;
            return result;
        }
        throw new StringOutOfBoundException("элемент по индексу " + index + " пуст");
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] != null && arrayString[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] != null && arrayString[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = arrayString.length - 1; i >= 0; i--) {
            if (arrayString[i] != null && arrayString[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkParametrs(index);
        if (arrayString[index] != null) {
            return arrayString[index];
        }
        throw new StringOutOfBoundException("элемент по индексу " + index + " пуст");
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new PassingNullToParameterException("в качестве параметра передан null");
        }
        if (size() == otherList.size()) {
            for (int i = 0; i < size(); i++) {
                if (!arrayString[i].equals(otherList.getArrayString()[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[size()];
        for (int i = 0; i < size(); i++) {
            newArray[i] = arrayString[i];
        }
        return newArray;
    }


    @Override
    public String toString() {
        return "StringListImpl " +
                Arrays.toString(arrayString);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringListImpl that = (StringListImpl) o;
        return Arrays.equals(arrayString, that.arrayString);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arrayString);
    }
}
