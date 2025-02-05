package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.SrvcStatusChckDTO;
import com.example.demo.dto.TodoDTO;
import com.example.demo.model.TodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("fds_batch")
public class SrvcStatusChckContoller {

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody SrvcStatusChckDTO dto) {
        try {
            String temporaryUserId = "temporary-user";

            System.out.println("dto = " + dto.toString());

            return ResponseEntity.ok().body("");
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
