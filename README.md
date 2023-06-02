# SurveyProject

A survey project. consists two microservices - Employee service and the Survey service, both use API to communicate with eachother.

Can be used in a working place, in which the management wishes to run a survey among the employees. 
You add your employees on the employee service, remove them and amend their details - full CRUD supplied.
On the Survey service you add your questions, and employees suppy their answers (a chech is made on the employee service, to verify the employee is indeed 
employed there; on resigning a worker is removed from the employee service - and all of the corresponding answers are deleted as well). 
Services run on ports 8080, 8081. Question Json ought to include 4 posiible answers in which one answer of each question is to be selected upon answering.

queries on API:

*Employee service*

  Post -    employee/create
  put -     employee/update
  get -     employee/{personalId}
            employee/getAllEmployees
  delete -  employee/{personalId}/delete
            employee/deleteAllEmployees
   
*Survey service - Q&A*

Questions 

  Post -   question/create
  Put -    question/{questionId}/update
  Get -    question/{questionId}/get
           question/getAllQuestions
  Delete - question/{questionId}/delete
           question/all/delete
 
Answers
 
  Post -   answer/create
  Get -    answer/getAllAnswersByEmployeeId/{employeeId}
           answer/AllAnswersByQuestionId/{questionId}
           answer/getAllAnswersToAllQuestions
  Delete - answer/delete/{employeeId}/allAnswersByEmployeeId
           answer/delete/{questionId}/allAnswersByQuestionId
           answer/deleteSpecific/{questionId}/{employeeId}
  
