package com.epam.collections.queue;

import java.util.*;
import java.util.stream.Collectors;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        List<Integer> orderList = new ArrayList<>();
        LinkedList<Integer> dishList = new LinkedList<>();
        while (numberOfDishes > 0) {
            dishList.add(numberOfDishes);
            numberOfDishes--;
        }
        dishList = dishList.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toCollection(LinkedList::new));
        int i = 1;
        while (!dishList.isEmpty()) {
            int dishNumber = dishList.poll();
            if (i % everyDishNumberToEat == 0) {
                orderList.add(dishNumber);
            } else {
                dishList.add(dishNumber);
            }
            i++;
        }
        return orderList;
    }
}
