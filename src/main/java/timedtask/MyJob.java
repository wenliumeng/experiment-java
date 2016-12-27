package timedtask;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 * Created by seyMour on 2016/12/26.
 */
public class MyJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sd.format(new Date()));
    }
}
