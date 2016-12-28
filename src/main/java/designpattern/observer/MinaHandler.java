package designpattern.observer;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 监控端
 * Created by seyMour on 2016/12/28.
 */
public class MinaHandler extends Subject {

    private Set<String> devices = new HashSet<>();

    @Override
    public void addMonitorDevice(Device device, String str) {
        devices.add(str);
        this.notifyObserver(device, str);
    }

    @Override
    public void removeMonitorDevice(Device device, String str) {
        devices.remove(str);
    }

    void connect() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
            JobDetail jobDetail = JobBuilder.newJob(Jobs.class).withIdentity("s", "s").build();
            jobDetail.getJobDataMap().put("device", devices);
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger3", "group1")
                    .startAt(new Date())
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(1)// 重复间隔
                                    .withRepeatCount(100))     // 重复次数
                    .build();
            Date date = scheduler.scheduleJob(jobDetail, trigger);
            System.out.println("开始于 " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
