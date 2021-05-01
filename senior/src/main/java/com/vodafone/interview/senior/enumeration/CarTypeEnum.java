package com.vodafone.interview.senior.enumeration;


public enum CarTypeEnum {

    CAR("car", 1),
    JEEP("jeep", 2),
    TRUCK("truck", 4);

    private String carType;
    private int slotSize;

    CarTypeEnum(String carType, int slotSize) {
        this.carType = carType;
        this.slotSize = slotSize;
    }

    public String getCarType() {
        return this.carType;
    }

    public int getSlotSize() {
        return this.slotSize;
    }

    public static CarTypeEnum fromString(String carType) {
        for (CarTypeEnum carTypeEnum : CarTypeEnum.values()) {
            if (carTypeEnum.carType.equalsIgnoreCase(carType)) {
                return carTypeEnum;
            }
        }
        return null;
    }
}
