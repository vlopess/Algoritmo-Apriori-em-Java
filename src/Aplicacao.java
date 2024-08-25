import Models.Compra;

import java.util.*;

public class Aplicacao {

    private static int getNumeroRegistro(List<ArrayList<String>> transactions, List<String> items) {
        int num = 0;
        for (ArrayList<String> transaction : transactions) {
            if (transaction.containsAll(items)) {
                num++;
            }
        }
        return num;
    }

    private static double calcularSuporte(List<ArrayList<String>> transactions, List<String> items) {
        int num = getNumeroRegistro(transactions, items);
        return (double) num / transactions.size();
    }

    private static double calcularConfianca(List<ArrayList<String>> transactions, List<String> items) {
        int num = getNumeroRegistro(transactions, items);
        int numRegistros = (int) transactions.stream().filter(value -> value.contains(items.get(0))).count();
        return (double) num / numRegistros;
    }

    public static void main(String[] args) {
        List<ArrayList<String>> transactions = Arrays.asList(
                new ArrayList<>(new Compra.Builder().idCompra(1).hasCafe().hasPao().hasManteiga().build().toList()),
                new ArrayList<>(new Compra.Builder().idCompra(2).hasLeite().hasCerveja().hasPao().hasManteiga().build().toList()),
                new ArrayList<>(new Compra.Builder().idCompra(3).hasCafe().hasPao().hasManteiga().build().toList()),
                new ArrayList<>(new Compra.Builder().idCompra(4).hasCafe().hasLeite().hasPao().hasManteiga().build().toList()),
                new ArrayList<>(new Compra.Builder().idCompra(5).hasCerveja().build().toList()),
                new ArrayList<>(new Compra.Builder().idCompra(6).hasManteiga().build().toList()),
                new ArrayList<>(new Compra.Builder().idCompra(7).hasPao().build().toList()),
                new ArrayList<>(new Compra.Builder().idCompra(8).hasFeijao().build().toList()),
                new ArrayList<>(new Compra.Builder().idCompra(9).hasFeijao().hasArroz().build().toList()),
                new ArrayList<>(new Compra.Builder().idCompra(10).hasArroz().build().toList())
        );
        calcularFrequencia(transactions);
    }

    private static void calcularFrequencia(List<ArrayList<String>> transactions) {

        Set<String> allItems = new HashSet<>();
        for (ArrayList<String> transaction : transactions) {
            allItems.addAll(transaction);
        }

        List<String> itemsList = new ArrayList<>(allItems);
        for (int i = 0; i < itemsList.size(); i++) {
            for (int j = i + 1; j < itemsList.size(); j++) {
                List<String> items = new ArrayList<>();
                items.add(itemsList.get(i));
                items.add(itemsList.get(j));
                double support = calcularSuporte(transactions, items);
                double confidence = calcularConfianca(transactions, items);
                if (support > 0) {
                    System.out.println(items + " -> Suporte: " + support + " | Confidence: " + confidence);
                }
            }
        }
    }


}
