package co.com.sofka.questions.utils;

import co.com.sofka.questions.collections.Answer;
import co.com.sofka.questions.collections.Question;
import co.com.sofka.questions.collections.Usuario;
import co.com.sofka.questions.model.AnswerDTO;
import co.com.sofka.questions.model.QuestionDTO;
import co.com.sofka.questions.model.UsuarioDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperUtils {

    public Function<AnswerDTO, Answer> mapperToAnswer() {
        return updateAnswer -> {
            var answer = new Answer();
            answer.setPosition(updateAnswer.getPosition());
            answer.setQuestionId(updateAnswer.getQuestionId());
            answer.setUserId(updateAnswer.getUserId());
            answer.setAnswer(updateAnswer.getAnswer());
            return answer;
        };
    }

    public Function<QuestionDTO, Question> mapperToQuestion(String id) {
        return updateQuestion -> {
            var question = new Question();
            question.setId(id);
            question.setUserId(updateQuestion.getUserId());
            question.setCategory(updateQuestion.getCategory());
            question.setQuestion(updateQuestion.getQuestion());
            question.setUserId(updateQuestion.getUserId());
            question.setType(updateQuestion.getType());
            return question;
        };
    }

    public Function<Question, QuestionDTO> mapEntityToQuestion() {
        return entity -> new QuestionDTO(
                entity.getId(),
                entity.getUserId(),
                entity.getQuestion(),
                entity.getType(),
                entity.getCategory()
        );
    }

    public Function<Answer, AnswerDTO> mapEntityToAnswer() {
        return entity -> new AnswerDTO(
                entity.getId(),
                entity.getUserId(),
                entity.getAnswer()
        );
    }

    public Function<UsuarioDTO, Usuario> mapperToUsuario(String id) {
        return usuarioDTO -> {
            var usuario = new Usuario();
            usuario.setId(id);
            usuario.setUid(usuarioDTO.getUid());
            usuario.setApellido(usuarioDTO.getApellido());
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setPath(usuarioDTO.getPath());
            return usuario;
        };
    }

    public Function<Usuario, UsuarioDTO> mapperToUsuarioDTO() {
        return usuario -> new UsuarioDTO(
                usuario.getId(),
                usuario.getUid(),
                usuario.getApellido(),
                usuario.getNombre(),
                usuario.getPath()
        );
    }


}
