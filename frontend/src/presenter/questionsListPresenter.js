import model from "../model/model";
import modelUser from "../model/modelUser";

class QuestionsListPresenter {
   onCreateQuestion() {
      model.addQuestion(model.state.newQuestion.title,
       model.state.newQuestion.text,
       Date.now(),
       modelUser.state.currentUser.username,
       model.state.newQuestion.tag);
      
   }

   onAddQuestion(){
      window.location.assign("#/create-question");
   }

   onInit(){
      model.loadQuestions();
   }
   
   onListQuestions() {
      window.location.assign("#/list-questions");
   }
   
   onFilterQuestions() {
      window.location.assign("#/filter-questions");
   }

   onFilteredQuestions(){
      model.findByTitle();
      window.location.assign("#/filter-questions-yes");
   }

   changeToSearch(property, value){
      model.changeToSearch(property, value);

    }
   
}

const questionsListPresenter = new QuestionsListPresenter();

export default questionsListPresenter;