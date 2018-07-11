package net.aimeizi;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.StopWatch;

/**
 * Quartz需要执行的task
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobTask extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		System.out.println(Thread.currentThread().getName() + "Job started..:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		int i = 0;
		while (true) {
			i++;
			System.out.println("i:" + i);
			// try {
			// Thread.sleep(100);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			if (i == 100) {
				System.out.println("Job ended..");
				stopWatch.stop();
				System.out.println(stopWatch.prettyPrint());
				break;
			}
		}
	}

}
