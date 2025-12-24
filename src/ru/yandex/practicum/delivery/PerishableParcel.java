package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        super.setBaseDeliveryCost(3);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        return sendDay + timeToLive < currentDay;
    }

    @Override
    public String toString() {
        return super.toString() + " | Срок годности: " + timeToLive;
    }
}