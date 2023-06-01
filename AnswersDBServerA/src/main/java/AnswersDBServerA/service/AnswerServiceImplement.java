package AnswersDBServerA.service;

import AnswersDBServerA.model.Answer;
import AnswersDBServerA.model.AnswerServiceResponse;
import AnswersDBServerA.model.FetchedEmployee;
import AnswersDBServerA.model.ReceivedJsonAnswer;

import AnswersDBServerA.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnswerServiceImplement implements AnswerService{
@Autowired
    AnswerRepository answerRepository;
@Autowired FetchQuestionsAndEmployeeService fetchQuestionsAndEmployeeService;
    @Override
    public AnswerServiceResponse createAnswer(ReceivedJsonAnswer receivedJsonAnswer) {

        List<Answer> answerList = receivedJsonAnswer.getAnswerList();

        for (Answer answer : answerList) {
            Long fetchedQuestionNumber = fetchQuestionsAndEmployeeService.getQuestionById(answer.getQuestionId()).getId();

            if  (fetchedQuestionNumber ==null) {
                return new AnswerServiceResponse ("Check question numbers, you have a mistake - a question does not exist.");
            };
        }
        FetchedEmployee fetched = fetchQuestionsAndEmployeeService.getEmployeeDetailsById(receivedJsonAnswer.getEmployeeId());

        if (Objects.equals(fetched.getId(), receivedJsonAnswer.getEmployeeId())) {
            answerRepository.createAnswer(receivedJsonAnswer);
            return new AnswerServiceResponse("Answers created");
        } else {return new AnswerServiceResponse("wrong id");
        }

    }



    @Override
    public AnswerServiceResponse changeAnswer(Long employeeId, Long questionId, String EmployeeResponse) {
        return null;
    }

    @Override
    public List<Answer> getAllAnswersToAllQuestions() {
        return answerRepository.getAllAnswersToAllQuestions();
    }

    @Override
    public List<Answer> getAllAnswersByEmployeeId(Long employeeId) {
        List<Answer> answerList =  answerRepository.getAllAnswersByEmployeeId(employeeId);
        return answerList;
    }

    @Override
    public List<Answer> getAllAnswersByQuestionId(Long questionId) {
        List<Answer> answerList=  answerRepository.getAllAnswersByQuestionId(questionId);
        return answerList;

    }

    @Override
    public AnswerServiceResponse getSpecificAnswerByEmployee(Long employeeId, Long questionId) {
        return null;
    }

    @Override
    public AnswerServiceResponse getAllAnswersToSpecificQuestionByQuestionId(Long QuestionId) {
        return null;
    }

    @Override
    public AnswerServiceResponse deleteAnswer(Long employeeId, Long questionId, String EmployeeResponse) {
        return null;
    }

    @Override
    public AnswerServiceResponse deleteAllAnswersByEmployeeId(Long employeeId) {
        answerRepository.deleteAllAnswersByEmployeeId (employeeId);
        return new AnswerServiceResponse("Done. no more answers from that employee on our nice DB");
    }

    @Override
    public AnswerServiceResponse deleteAllAnswersByQuestionId(Long questionId) {
        answerRepository.deleteAllAnswersByQuestionId (questionId);
        return new AnswerServiceResponse("Done. all answers to question number "+ questionId + " have been deleted.");
    };

}
