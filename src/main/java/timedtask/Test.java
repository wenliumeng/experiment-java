package timedtask;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务-测试
 * Created by seyMour on 2016/12/26.
 * ☞Keenyoda☜
 */
public class Test {

    public static void main(String[] args) throws SchedulerException {
        Test t = new Test();
        t.start();
    }

    void start() throws SchedulerException {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("23 44 16 ? * *")).build();
        Date ft = scheduler.scheduleJob(job, trigger);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println(job.getKey() + "已被安排执行与：" + sdf.format(ft) + ",并且重复于：" + trigger.getCronExpression());

        // job 2将每2分钟执行一次（在该分钟的第15秒)
        job = JobBuilder.newJob(MyJob.class).withIdentity("job2", "group1").build();
        trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("15 0/2 * * * ?")).build();
        ft = scheduler.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " 已被安排执行于: " + sdf.format(ft) + "，并且以如下重复规则重复执行: " + trigger.getCronExpression());

        scheduler.start();

        try {
            Thread.sleep(60L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.shutdown(true);
    }

}
