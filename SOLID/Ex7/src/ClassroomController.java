public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        InputConnectable display = reg.getFirst(InputConnectable.class);
        if (display instanceof Switchable) {
            ((Switchable) display).powerOn();
        }
        display.connectInput("HDMI-1");

        reg.getFirst(BrightnessControllable.class).setBrightness(60);
        reg.getFirst(TemperatureControllable.class).setTemperatureC(24);

        Scannable scanner = reg.getFirst(Scannable.class);
        System.out.println("Attendance scanned: present=" + scanner.scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        for (Switchable s : reg.getAll(Switchable.class)) {
            s.powerOff();
        }
    }
}
