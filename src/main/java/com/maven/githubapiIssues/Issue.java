package com.maven.githubapiIssues;

import java.util.Date;

public class Issue implements Comparable<Issue> {
    int number, id;

    boolean state;
    String title, body;
    Date createdAt, closedAt;
    User user, assignee;

    public int compareTo(Issue o) {
        if (o == null) {
            throw new NullPointerException("object is null");
        }
        else if (this.getId() > o.getId()) {
            return 1;
        }
        else if (this.getId() < o.getId()) {
            return -1;
        }
        else if (this.getId() == o.getId()) {
            return 0;
        }
        return 0;
    }

    public Issue() {
        // no argument constructor

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        closedAt = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Issue other = (Issue) obj;

        if (id != other.id) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        String s;
        s = "Issue [number=" + number + ", id=" + id + ", state=" + state
                + ", title=" + title + ", body=" + body + ", createdAt="
                + createdAt + ", closedAt=" + closedAt + ", user=" + user
                + ", assignee=" + assignee + "]";
        return s;
    }

}