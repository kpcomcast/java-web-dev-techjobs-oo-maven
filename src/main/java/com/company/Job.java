package com.company;

import java.util.Objects;

public class Job {
    private static int nextId = 1;

    private int id;
    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: add two constructors - one to initialize a unique ID and a second to initialize the other five fields. The second constructor should also call the first in order to initialize the 'id' field

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID and id.

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Employer getEmployer() {
        return employer;
    }
    public Location getLocation() {
        return location;
    }
    public PositionType getPositionType() {
        return positionType;
    }
    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }
    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public String toString() {
        if (this.getName() == null) {
            return "OOPS! This job does not seem to exist.";
        }

        if (this.getName().equals("")) {
            this.setName("Data not available");
        }
        if (this.getEmployer().getValue() == null || this.getEmployer().getValue().equals("")) {
            this.getEmployer().setValue("Data not available");
        }
        if (this.getLocation().getValue() == null || this.getLocation().getValue().equals("")) {
            this.getLocation().setValue("Data not available");
        }
        if (this.getPositionType().getValue() == null || this.getPositionType().getValue().equals("")) {
            this.getPositionType().setValue("Data not available");
        }
        if (this.getCoreCompetency().getValue() == null || this.getCoreCompetency().getValue().equals("")) {
            this.getCoreCompetency().setValue("Data not available");
        }

        String message = "\n" + "ID: " + this.getId() + "\n" + "Name: " + this.getName() + "\n" + "Employer: " + this.getEmployer() + "\n" + "Location: " + this.getLocation() + "\n" + "Position Type: " + this.getPositionType() + "\n" + "Core Competency: " + this.getCoreCompetency() + "\n";

        if (message.equals("\n" + "ID: " + this.getId() + "\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n")) {
            message = "OOPS! This job does not seem to exist.";
        }

        return message;
    }
}
