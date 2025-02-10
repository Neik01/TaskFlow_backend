package com.ntk.TaskFlow.DTO.Entities;

import java.util.List;

public record ProjectDTO(Integer id, String name, List<BoardDTO> boards) {
}
