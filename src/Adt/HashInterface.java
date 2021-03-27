/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adt;

/**
 *
 * @author brandon choong
 */
public interface HashInterface <K, V> {
  
    public V add(K key, V value);

    public V remove(K key);

    public V getValue(K key);

    public boolean contains(K key);

    public boolean isEmpty();

    public boolean isFull();

    public int getSize();

    public void clear();
}
