package designpattern.observer;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 触发动作端-被观察者
 * Created by seyMour on 2016/12/28.
 * ☞Keenyoda☜
 */
public class InitObservable extends SubjectObservable {

    private Set<String> devices = new HashSet<>();

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    protected synchronized void clearChanged() {
        super.clearChanged();
    }

    @Override
    public void addListenerDevice(String str) {
        System.out.println("收到移动端指令，需要增加监听设备");
        devices.add(str);
        notifyObservers();
    }

    @Override
    public void removeListenerDevice(String str) {
        System.out.println("收到移动端指令，需要移除监听设备");
        devices.remove(str);
        notifyObservers();
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
