package com.knitqueue.knitqueue.entity;

import jakarta.persistence.*;

@Entity
@Table(name="project")
public class Project {
    // Fields
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="project_id")
    private int projectId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private AppUser appUser;

    @Column(name="project_name")
    private String projectName;

    @Column(name="notes")
    private String notes;

    @Column(name="reference_url")
    private String referenceUrl;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="project_state")
    private String projectState;

    // Constructors
    public Project() {}

    public Project(AppUser appUser, String projectName, String notes, String referenceUrl, String imageUrl,
                   String projectState) {
        this.appUser = appUser;
        this.projectName = projectName;
        this.notes = notes;
        this.referenceUrl = referenceUrl;
        this.imageUrl = imageUrl;
        this.projectState = projectState;
    }

    // Getters and Setters
    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReferenceUrl() {
        return referenceUrl;
    }

    public void setReferenceUrl(String referenceUrl) {
        this.referenceUrl = referenceUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProjectState() {
        return projectState;
    }

    public void setProjectState(String projectState) {
        this.projectState = projectState;
    }

    public int getProjectId() {
        return projectId;
    }

    // toString
    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", appUser=" + appUser +
                ", projectName='" + projectName + '\'' +
                ", notes='" + notes + '\'' +
                ", referenceUrl='" + referenceUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", projectState='" + projectState + '\'' +
                '}';
    }
}
