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
        Assertions.assertTrue(job3.getEmployer().getValue().equals("ACME"));

        Assertions.assertTrue(job3.getLocation() != null);
        Assertions.assertTrue(job3.getLocation().getValue().equals("Desert"));

        Assertions.assertTrue(job3.getPositionType() != null);
        Assertions.assertTrue(job3.getPositionType().getValue().equals("Quality control"));

        Assertions.assertTrue(job3.getCoreCompetency() != null);
        Assertions.assertTrue(job3.getCoreCompetency().getValue().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality() {
        Assertions.assertFalse(job4.equals(job5));
    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {
        Assertions.assertTrue(job5.toString().equals("\n" + job5.toString().trim() + "\n"));
    }

    @Test
    public void testToStringHasLabelsForEachField() {
        Assertions.assertTrue(job5.toString().equals("\nID: 5\nName: Product person\nEmployer: MARS\nLocation: Brazil\nPosition Type: Quality control\nCore Competency: Java\n"));
    }

    @Test
    public void testToStringDataNotAvailable() {
        Assertions.assertTrue(job6.toString().equals("\nID: 6\nName: Product person\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Quality control\nCore Competency: Java\n"));
    }

    @Test
    public void testOnlyIdField() {
        Assertions.assertTrue(job7.toString().equals("OOPS! This job does not seem to exist."));
        Assertions.assertTrue(job8.toString().equals("OOPS! This job does not seem to exist."));
    }
}
