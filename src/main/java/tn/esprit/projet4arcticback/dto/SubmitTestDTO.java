package tn.esprit.projet4arcticback.dto;
import lombok.Data;

import java.util.List;


@Data

public class SubmitTestDTO {
    private long testId;

    private List<QuestionResponse> responses;
}
