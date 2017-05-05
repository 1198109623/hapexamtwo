package job;

import com.hand.hap.job.AbstractJob;
import com.hand.hap.mail.service.IEmailService;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;

/**
 * Created by GuoMingLi on 2017/5/2.
 */
public class job extends AbstractJob {
    @Autowired
    private IEmailService emailService;
    @Override
    public void safeExecute(JobExecutionContext jobExecutionContext) throws Exception {
        //0 0 * * * ? 准点执行
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("准点报时：HH:mm:ss");
        String dd = sdf.format(d);
        System.out.println(dd);
    }
}