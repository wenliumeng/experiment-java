package timedtask;

import org.quartz.DateBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * quartz DateBuilder实例
 * Created by seyMour on 2016/12/27.
 * ☞Keenyoda☜
 */
public class DateBuilderTest {

    public static void main(String[] args) {
        //间隔几天后
        Date date = DateBuilder.futureDate(1, DateBuilder.IntervalUnit.DAY);
        //前进一位加到满
        Date date1 = DateBuilder.evenHourDate(new Date());
        Date date2 = DateBuilder.evenMinuteDate(new Date());
        //整点分递进
        Date date3 = DateBuilder.nextGivenMinuteDate(new Date(), 2);
        Date date4 = DateBuilder.nextGivenMinuteDate(date3, 2);
        //构造时间
        Date date5 = DateBuilder.dateOf(3, 2, 33, 1, 12, 2011);
        //下一个准点小时，或上一个准点
        Date date6 = DateBuilder.evenHourDateAfterNow();
        Date date7 = DateBuilder.evenHourDateBefore(new Date());
        Date date8 = DateBuilder.evenMinuteDateAfterNow();
        Date date9 = DateBuilder.evenMinuteDateBefore(new Date());
        Date date10 = DateBuilder.evenSecondDateAfterNow();
        Date date11 = DateBuilder.evenSecondDateBefore(new Date());
        //今天的某个时间
        Date date12 = DateBuilder.todayAt(9, 22, 33);
        //明天的某个时间
        Date date13 = DateBuilder.tomorrowAt(9, 22, 33);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(date12.after(new Date()));
        System.out.println(sf.format(date));
    }

}
