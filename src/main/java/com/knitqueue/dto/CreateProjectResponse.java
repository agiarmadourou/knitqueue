package com.knitqueue.dto;

public record CreateProjectResponse(
        String projectName,
        String notes,
        String referenceUrl,
        String imageUrl,
        String projectState
) {}
