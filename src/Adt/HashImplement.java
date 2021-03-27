package Adt;

import java.io.Serializable;

public class HashImplement <K, V> implements HashInterface <K, V>, Serializable {

  private Node<K, V>[] hashTable;
  private int numberOfEntries;
  private static final int DEFAULT_SIZE = 101; // default size of hash table - must be prime 
  private static final double MAX_LOAD_FACTOR = 0.9; // fraction of hash table that can be filled

  public HashImplement() {
    this(DEFAULT_SIZE);
  } 

  public HashImplement(int tableSize) {
    int primeSize = getNextPrime(tableSize);
    hashTable = new Node[primeSize];
    numberOfEntries = 0;
  } 

  public String toString() {
    String outputStr = "";
    for (int index = 0; index < hashTable.length; index++) {
      if (hashTable[index] == null) {
//        outputStr += "null\n";
      } else {
        Node<K, V> currentNode = hashTable[index];
        while (currentNode != null) {
          outputStr += currentNode.key + " " + currentNode.value + " ";
          currentNode = currentNode.next;
        } 

        outputStr += "\n";
      } 
    } 

    outputStr += "\n";
    return outputStr;
  } 

  public V add(K key, V value) {
    V oldValue = null;
    if(key != null && value != null){
        if (isHashTableTooFull()) {
          rehash();
        }

        int index = getHashIndex(key);

        if (hashTable[index] == null) {
          hashTable[index] = new Node<K, V>(key, value);
          numberOfEntries++;
        } 
        else { 
          Node<K, V> currentNode = hashTable[index];
          Node<K, V> nodeBefore = null;

          while ((currentNode != null) && !key.equals(currentNode.key)) {
            nodeBefore = currentNode;
            currentNode = currentNode.next;
          } 

          if (currentNode == null) {
            Node<K, V> newNode = new Node<K, V>(key, value);
            nodeBefore.next = newNode;
            numberOfEntries++;
          } 
          else {
            oldValue = currentNode.value;
            currentNode.value = value;
          }
        }
    }

    return oldValue;
  }

  public V remove(K key) {
    V removedValue = null;
    
    if(key != null){
        int index = getHashIndex(key);

        // search chain beginning at hashTable[index] for a node that contains key
        Node<K, V> nodeBefore = null;
        Node<K, V> currentNode = hashTable[index];

        while ((currentNode != null) && !key.equals(currentNode.key)) {
          nodeBefore = currentNode;
          currentNode = currentNode.next;
        }

        if (currentNode != null) {
          // key found; get value for return and then remove entry
          removedValue = currentNode.value;

          if (nodeBefore == null) {
            // remove first node
            hashTable[index] = currentNode.next;
          } else {
            nodeBefore.next = currentNode.next;
          }

          numberOfEntries--;
        }
        // else removedValue is null if key not found
    }
    return removedValue;
  }

  public V getValue(K key) {
    V result = null;

    int index = getHashIndex(key);

    // search chain beginning at hashTable[index] for a node that contains key
    Node<K, V> currentNode = hashTable[index];

    while ((currentNode != null) && !key.equals(currentNode.key)) {
      currentNode = currentNode.next;
    } 

    if (currentNode != null) {
      result = currentNode.value;
    } 

    return result;
  }

  private void rehash() {
    Node<K, V>[] oldTable = hashTable;
    int oldSize = oldTable.length;
    int newSize = getNextPrime(oldSize + oldSize);

    hashTable = new Node[newSize];

    numberOfEntries = 0;
    for (int index = 0; index < oldSize; ++index) {
      Node<K, V> currentNode = oldTable[index];

      while (currentNode != null) { 

        add(currentNode.key, currentNode.value);
        currentNode = currentNode.next;
      }
    } 
  } 

  public final void clear() {
    if(!isEmpty()){
        for (int index = 0; index < hashTable.length; index++) {
          hashTable[index] = null;
        }
    }

    numberOfEntries = 0;
  }

  private boolean isHashTableTooFull() {
    return numberOfEntries > MAX_LOAD_FACTOR * hashTable.length;
  }

  public boolean contains(K key) {
    return getValue(key) != null;
  } 

  public boolean isEmpty() {
    return numberOfEntries == 0;
  } 

  public boolean isFull() {
    if(isHashTableTooFull())
        return true;
    else
        return false;
  } 

  public int getSize() {
    return numberOfEntries;
  } 

  private int getHashIndex(K key) {
    int hashIndex = key.hashCode() % hashTable.length;

    if (hashIndex < 0) {
      hashIndex = hashIndex + hashTable.length;
    }

    return hashIndex;
  } 

  private int getNextPrime(int integer) {
    if (integer % 2 == 0) {
      integer++;
    } 

    while (!isPrime(integer)) {
      integer = integer + 2;
    } 

    return integer;
  }

  private boolean isPrime(int integer) {
    boolean result;
    boolean done = false;

    // 1 and even numbers are not prime
    if ((integer == 1) || (integer % 2 == 0)) {
      result = false;
    } // 2 and 3 are prime
    else if ((integer == 2) || (integer == 3)) {
      result = true;
    } else { // integer is odd and >= 5
      // a prime is odd and not divisible by every odd integer up to its square root
      result = true; // assume prime
      for (int divisor = 3; !done && (divisor * divisor <= integer); divisor = divisor + 2) {
        if (integer % divisor == 0) {
          result = false; // divisible; not prime
          done = true;
        } 
      } 
    } 

    return result;
  } 
// ----------------------------------------------------------

  private class Node<S, T> implements java.io.Serializable {

    private S key;
    private T value;
    private Node<S, T> next;

    private Node(S searchKey, T dataValue) {
      key = searchKey;
      value = dataValue;
      next = null;
    } 

    private Node(S searchKey, T dataValue, Node<S, T> nextNode) {
      key = searchKey;
      value = dataValue;
      next = nextNode;
    }

  } 
}

