package com.knitqueue.dto;

public record ProjectResponse(
        int projectId,
        String projectName,
        String notes,
        String referenceUrl,
        String imageUrl,
        String projectState)
{ }

