package com.ntk.TaskFlow.DTO.Entities;

import java.util.List;

public record BoardDTO(int id, String name, String description, List<ProjectStageDTO> stages, List<TaskDTO> tasks) {
}
