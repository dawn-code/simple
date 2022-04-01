package com.ctl.simple.aspect;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @author Jxr
 */
@Log4j2
@Component
public class HumanServiceStudent implements HumanService {
    /**
     * display
     */
    public final void display() {
        log.info("我是学生");
    }
}
