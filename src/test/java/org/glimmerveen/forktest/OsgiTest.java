package org.glimmerveen.forktest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.CoreOptions;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerMethod;

import static org.junit.Assert.assertTrue;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerMethod.class)
public class OsgiTest {

    @Configuration
    public Option[] options() {
        return CoreOptions.options(
                CoreOptions.junitBundles()
        );
    }

    @Test
    public void test() {
        assertTrue(true);
    }
}
