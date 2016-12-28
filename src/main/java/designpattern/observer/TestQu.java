package designpattern.observer;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class TestQu {

    public static void main(String[] args) {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();

            JobDetail jobDetail = JobBuilder.newJob(Jobs.class).build();
            HashSet<String> s = new HashSet<>();
            s.add("d");
            jobDetail.getJobDataMap().put("device", s);
            Trigger trigger = TriggerBuilder.newTrigger()
                    .startAt(new Date())
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(1)// 重复间隔
                                    .withRepeatCount(20))     // 重复次数
                    .build();
            Date date = scheduler.scheduleJob(jobDetail, trigger);
            System.out.println("开始于 " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
