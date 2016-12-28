package designpattern.observer;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 测试
 * Created by seyMour on 2016/12/28.
 */
public class Jobs implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println((jobExecutionContext.getMergedJobDataMap().get("device")).toString());
    }
}
