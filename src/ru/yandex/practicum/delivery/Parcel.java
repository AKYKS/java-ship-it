package ru.yandex.practicum.delivery;

import java.util.Objects;

public abstract class Parcel {
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;
    protected int baseDeliveryCost = 1; //Базовая стоимость будет меняться для каждой посылки в классах наследниках.

    public int getBaseDeliveryCost() {
        return baseDeliveryCost;
    }

    public void setBaseDeliveryCost(int baseDeliveryCost) {
        this.baseDeliveryCost = baseDeliveryCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

    public void setSendDay(int sendDay) {
        this.sendDay = sendDay;
    }

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    };

    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    };

    public int calculateDeliveryCost() {
        return this.weight * baseDeliveryCost;
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return Double.compare(weight, parcel.weight) == 0 && sendDay == parcel.sendDay
                && Objects.equals(description, parcel.description)
                && Objects.equals(deliveryAddress, parcel.deliveryAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public String toString() {
        return "Посылка: " + description + " | Вес: " + weight + " | Адрес доставки: " + deliveryAddress
                + " | Дата отправки: " + sendDay;
    }
}
