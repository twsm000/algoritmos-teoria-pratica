package com.twsm.sort.selection;

import java.util.function.ToIntBiFunction;

/**
 * Ex: 2.2-2 - pg. 20
 * Considere a ordenação de 'n' números no arranjo 'A', localizando primeiro
 * o menor elemento de 'A' e permutando esse elemento com o elemento contido em 'A[1]'.
 * Em seguida, determine o segundo menor elemento de 'A' e permute-o com 'A[2]'.
 * Continue dessa maneira para os primeiros 'n - 1' elementos de 'A'. Escreva o pseudocódigo
 * para esse algoritmo, conhecido como 'ordenação por seleção. Qual invariante de laço
 * esse algoritmo mantém? Por que ele só precisa ser executado para os primeiros 'n - 1'
 * elementos, e não para todos os 'n' elementos? Forneça os tempos de execução do melhor
 * caso e do pior caso de ordenação por seleção em notação O
 */
public class SelectionSort {
    public static <T extends Comparable<? super T>> void sort(T[] array, ToIntBiFunction<T, T> conditionalOrder) {
        for (int i = 0; i < array.length - 1; i++) {
            int lowest = i;
            for (int j = i + 1; j < array.length; j++) {
                if (conditionalOrder.applyAsInt(array[j], array[lowest]) < 0) {
                    lowest = j;
                }
            }

            T temp = array[lowest];
            array[lowest] = array[i];
            array[i] = temp;
        }
    }
}
