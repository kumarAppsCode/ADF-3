/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testquatrtz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author DineshkumarP
 */
public class TestQuatrtz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
           JobDetail job1= (JobDetail) JobBuilder.newJob(TestJob.class).withIdentity("job1", "group1").build();
           
          Trigger trigger1 =TriggerBuilder.newTrigger().
                  withIdentity("cronTrigger1", "group1").
//                  withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build(); // every 1 min it will trigger
                   withSchedule(CronScheduleBuilder.cronSchedule("0 0 15 1/1 * ? *")).build(); // Every day 5pm mail
                  
          
          Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
          scheduler1.start();
          scheduler1.scheduleJob(job1, trigger1);
//          Thread.sleep(1000);
//          scheduler1.shutdown(); 
        }catch(Exception e){
          e.printStackTrace();
        }
    
    }
        
}

---------------
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testquatrtz;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author DineshkumarP
 */
public class TestJob implements Job{

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
    System.out.println("Job1 TEST--->>> Time is " + new Date());

    }
    
}

-----------------------------


