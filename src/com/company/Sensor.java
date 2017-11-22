package com.company;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 22.11.2017.
 */
public class Sensor {
    private static int time;
    private static int temerature;

    List<Alarm> alarms;

    public Sensor() {
        alarms = new ArrayList<>();
    }

    public void addAlarm(Alarm alarm) {
        alarms.add(alarm);
    }

    public void removeAlarm(Alarm alarm) {
        alarms.remove(alarm);
    }

    private void notifyAlarm(int temp) {
        for (Alarm alarm : alarms)
            alarm.tempChange(temp);
    }

    public static void main(String[] args) {
        Sensor sens = new Sensor();
        sens.alarms.add(new Alarm() {
            @Override
            public void tempChange(int temp) {
                if (temp == 100) System.out.println("Зеленый");
            }
        });
        sens.alarms.add(new Alarm() {
            @Override
            public void tempChange(int temp) {
                if (temp == 300) System.out.println("Желтый");
            }
        });
        sens.alarms.add(new Alarm() {
            @Override
            public void tempChange(int temp) {
                if (temp == 500) System.out.println("Красный");
            }
        });

        for (temerature =0; temerature < 450; temerature++)
            sens.notifyAlarm(temerature);
    }
}

