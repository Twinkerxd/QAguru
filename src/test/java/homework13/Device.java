package homework13;

public class Device {

    private String[] devices = new String[10];

    void addDeviceByIndex(int index, String name) {
        if (index < 0 || index > 9) {
            System.out.println("Индекс должен быть от 0 до 9");
        } else {
            devices[index] = name;
        }
    }

    void printAllDevices() {
        for (int i = 0; i < devices.length; i++) {
            System.out.println(devices[i]);
        }
    }
}
