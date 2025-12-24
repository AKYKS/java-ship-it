package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static ArrayList<Parcel> allParcels = new ArrayList<>();
    private static ArrayList<Trackable> allTrackables = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(50);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(50);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(50);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel(allParcels, allTrackables, standardParcelBox, fragileParcelBox, perishableParcelBox);
                    break;
                case 2:
                    sendParcels(allParcels);
                    break;
                case 3:
                    calculateCosts(allParcels);
                    break;
                case 4:
                    reportStatus(allTrackables);
                    break;
                case 5:
                    System.out.println();
                    showTypeOfParcel();
                    int choiceParcelType = Integer.parseInt(scanner.nextLine());
                    switch (choiceParcelType) {
                        case 1:
                            showParcelBox(standardParcelBox);
                            break;
                        case 2:
                            showParcelBox(fragileParcelBox);
                            break;
                        case 3:
                            showParcelBox(perishableParcelBox);
                            break;
                        default:
                            System.out.println("Неверный выбор.");
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Показать, где находятся посылки");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel(ArrayList<Parcel> parcels, ArrayList<Trackable> trackables,
                                  ParcelBox<StandardParcel> standardParcelBox,
                                  ParcelBox<FragileParcel> fragileParcelBox,
                                  ParcelBox<PerishableParcel> perishableParcelBox) {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        Parcel newParcel = null;

        System.out.println();
        showTypeOfParcel();
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice < 1 || choice > 3) {
            System.out.println("Неверный выбор.");
            return;
        }

        System.out.print("Введите описание посылки: ");
        String description = scanner.nextLine();
        System.out.print("Введите адрес доставки: ");
        String deliveryAddress = scanner.nextLine();
        System.out.print("Введите дату отправки: ");
        int sendDay = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите вес посылки: ");
        int weight = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                newParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                standardParcelBox.addParcel((StandardParcel) newParcel);
                break;
            case 2:
                newParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                trackables.add((Trackable) newParcel);
                fragileParcelBox.addParcel((FragileParcel) newParcel);
                break;
            case 3:
                System.out.print("Введите срок годности посылки: ");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                newParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                perishableParcelBox.addParcel((PerishableParcel) newParcel);
                break;
            default:
        }
        parcels.add(newParcel);
    }

    private static void sendParcels(ArrayList<Parcel> parcels) {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : parcels) {
            System.out.println(("-").repeat(50));
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts(ArrayList<Parcel> parcels) {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int totalCost = 0;
        for (Parcel parcel : parcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок: " + totalCost);
    }

    private static void reportStatus(ArrayList<Trackable> trackables) {
        for (Trackable trackable : trackables) {
            System.out.println("Напишите местоположение посылки:");
            String newLocation = scanner.nextLine();
            trackable.reportStatus(newLocation);
        }
    }

    private static void showTypeOfParcel() {
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
    }

    private static void showParcelBox (ParcelBox<? extends Parcel> parcelBox) {
        parcelBox.getAllParcels();
    }

}

