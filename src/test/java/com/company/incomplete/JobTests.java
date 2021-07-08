package com.company.incomplete;

import com.company.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class JobTests {
    // you can rename the tests, or delete them and rewrite them from scratch, but I went ahead and provided you the names of tests I created -- I followed the writeup pretty honestly
    private static Job job1;
    private static Job job2;
    private static Job job3;
    private static Job job4;
    private static Job job5;
    private static Job job6;
    private static Job job7;
    private static Job job8;

    @BeforeAll
    public static void createJobs() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product person", new Employer("MARS"), new Location("Brazil"), new PositionType("Quality control"), new CoreCompetency("Java"));
        job5 = new Job("Product person", new Employer("MARS"), new Location("Brazil"), new PositionType("Quality control"), new CoreCompetency("Java"));
        job6 = new Job("Product person", new Employer(""), new Location(""), new PositionType("Quality control"), new CoreCompetency("Java"));
        job7 = new Job();
        job8 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId() {
        Assertions.assertTrue(job1.getId() != job2.getId() && job2.getId() - job1.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Assertions.assertEquals(3, job3.getId());
        Assertions.assertEquals("Product tester", job3.getName());

        Assertions.assertNotNull(job3.getEmployer());
        Assertions.assertTrue(job3.getEmployer() instanceof Employer);
        Assertions.assertEquals("ACME", job3.getEmployer().getValue());

        Assertions.assertNotNull(job3.getLocation());
        Assertions.assertTrue(job3.getLocation() instanceof Location);
        Assertions.assertEquals("Desert", job3.getLocation().getValue());

        Assertions.assertNotNull(job3.getPositionType());
        Assertions.assertTrue(job3.getPositionType() instanceof PositionType);
        Assertions.assertEquals("Quality control", job3.getPositionType().getValue());

        Assertions.assertNotNull(job3.getCoreCompetency());
        Assertions.assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        Assertions.assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Assertions.assertNotEquals(job4, job5);
    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {
        Assertions.assertEquals(job5.toString(), "\n" + job5.toString().trim() + "\n");
    }

    @Test
    public void testToStringHasLabelsForEachField() {
        Assertions.assertEquals("\nID: 5\nName: Product person\nEmployer: MARS\nLocation: Brazil\nPosition Type: Quality control\nCore Competency: Java\n", job5.toString());
    }

    @Test
    public void testToStringDataNotAvailable() {
        Assertions.assertEquals("\nID: 6\nName: Product person\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Quality control\nCore Competency: Java\n", job6.toString());
    }

    @Test
    public void testOnlyIdField() {
        Assertions.assertEquals("OOPS! This job does not seem to exist.", job7.toString());
        Assertions.assertEquals("OOPS! This job does not seem to exist.", job8.toString());
    }
}
