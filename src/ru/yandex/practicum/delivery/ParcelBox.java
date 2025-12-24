package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    private ArrayList<T> parcels;
    private int currentWeight;
    private final int maxWeight;

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public ParcelBox(int maxWeight) {
        parcels = new ArrayList<>();
        this.maxWeight = maxWeight;
        currentWeight = 0;
    }

    public void addParcel(T parcel) {
        if (parcel.getWeight() + currentWeight <= maxWeight ) {
            parcels.add(parcel);
            currentWeight += (int) parcel.getWeight();
            System.out.println("Посылка добавлена в коробку");
        } else {
            System.out.println("Коробка переполнена!");
        }
    }

    public void getAllParcels() {
        System.out.println("Список посылок:");
        for (T parcel : parcels) {
            System.out.println(parcel.toString());
        }
    }
}
