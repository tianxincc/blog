package  com.tianxin;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    //日志测试
    Logger log= LoggerFactory.getLogger(Logger.class);
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        log.info("测试info日志输出");
        log.debug("测试debug日志输出");
        log.warn("测试warn日志输出");
        log.trace("测试trace日志输出");
        log.error("测试error日志输出");
        assertTrue( true );
    }
}
