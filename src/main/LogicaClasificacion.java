package main;

import java.util.*;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {

        Stack<Character> invertirCadenaa = new Stack<>();
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            invertirCadenaa.push(caracter);
        }
        StringBuilder resultado = new StringBuilder();
        while (!invertirCadenaa.isEmpty()) {
            resultado.append(invertirCadenaa.pop());
        }

        return resultado.toString();
    }

    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();
        for (int i = 0; i < expresion.length(); i++) {
            char temp = expresion.charAt(i);
            if (temp == '{' || temp == '[' || temp == '(' ){
                pila.push(temp);
            }else if (temp == '}' || temp == ']' || temp == ')') {
                if (pila.isEmpty()) {
                    return false;
                }
                if (pila.peek() == '{' && temp == '}' ){
                    pila.pop();
                } else if (pila.peek() == '[' && temp == ']'){
                    pila.pop();
                } else if (pila.peek() == '(' && temp == ')') {
                    pila.pop();
                }
            } else {
                return false;
            }
        }
        if (pila.isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @return Lista ordenada.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> pilaOrdenar = new Stack<>();
        while (!pila.isEmpty()) {
            int temp = pila.pop();
            while (!pilaOrdenar.isEmpty() && pilaOrdenar.peek() > temp) {
                pila.push(pilaOrdenar.pop());
            }
            pilaOrdenar.push(temp);
        }
        while (!pilaOrdenar.isEmpty()) {
            pila.push(pilaOrdenar.pop());
        }

        List<Integer> resultado = new ArrayList<>();
        while (!pila.isEmpty()) {
            resultado.add(pila.pop());
        }
        return resultado;

    }

    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impares = new LinkedList<>();
        for (Integer numero : original) {
            if (numero % 2 == 0) {
                pares.add(numero);
            } else {
                impares.add(numero);
            }
        }
        List<Integer> resultado  = new ArrayList<>();
        while (!pares.isEmpty()) {
            resultado.add(pares.pop());

        }
        while (!impares.isEmpty()) {
            resultado.add(impares.pop());
        }
        return resultado;
    }
}
