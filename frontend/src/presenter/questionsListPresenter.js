import model from "../model/model";

class QuestionsListPresenter {
   onChooseAddQuestion(){
    window.location.assign("#/create-question");
   }

   onCreateQuestion() {
    model.addQuestion(model.state.newQuestion.titleQ, model.state.newQuestion.text, model.state.newQuestion.creationDate, model.state.newQuestion.author, model.state.newQuestion.tag)
    .then( ()=>{
      model.changeNewQuestionProperty("titleQ", "");
      model.changeNewQuestionProperty("text", "");
      model.changeNewQuestionProperty("creationDate", "");
      model.changeNewQuestionProperty("author", "");
      model.changeNewQuestionProperty("tag", "");
      window.location.assign("#/");
    });
    
   }

   onChange(property, value) {
    model.changeNewQuestionProperty(property, value);
   }

   onInit(){
    model.loadQuestions();
   }
   
}

const questionsListPresenter = new QuestionsListPresenter();

export default questionsListPresenter;