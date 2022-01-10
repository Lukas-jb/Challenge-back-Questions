package co.com.sofka.questions.usecases.Questions;

import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.repositories.QuestionRepository;
import co.com.sofka.questions.utils.Category;
import co.com.sofka.questions.utils.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreateUseCaseTest {

    @SpyBean
    private CreateUseCase createUseCase;

    @MockBean
    private QuestionRepository repository;

    @Test
    void createQuestion() {

        var questionDT0 = new QuestionDTO("1",
                "xxxx",
                "What is java?",
                Type.OPEN, Category.SCIENCES,
                "Se envio el Email");

        var question = new Question("1",
                "xxxx",
                "What is java?",
                Type.OPEN,
                Category.SCIENCES,
                "Se envio el Email");

        when(repository.save(Mockito.any())).thenReturn(Mono.just(question));

        var result = createUseCase.apply(questionDT0);

        Assertions.assertEquals(Objects.requireNonNull(result.block()), "1");
        Assertions.assertEquals(result.block(), question.getId());

        Mockito.verify(repository, Mockito.times(1)).save(any());

    }

    @Test
    void createUseCaseTest() {

        var questionDT0 = new QuestionDTO("1asd2153453",
                "1234",
                "What id DDD in software",
                Type.OPEN,
                Category.SCIENCES,
                "Se envio el Email");

        var question = new Question("1asd2153453",
                "1234",
                "What id DDD in software",
                Type.OPEN,
                Category.SOFTWARE_DEVELOPMENT,
                "Se envio el Email");

        when(repository.save(Mockito.any(Question.class))).thenReturn(Mono.just(question));

        var result = createUseCase.apply(questionDT0);
        Assertions.assertEquals(Objects.requireNonNull(result.block()), "1asd2153453");
    }

}