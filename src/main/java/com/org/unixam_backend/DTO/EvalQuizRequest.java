package com.org.unixam_backend.DTO;


import com.org.unixam_backend.model.exam.QuestionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EvalQuizRequest {

    private List<QuestionResponse> questionResponses;
}
