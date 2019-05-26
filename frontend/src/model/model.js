import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";
import WebSocketListener from "../ws/WebSocketListener";

const client = new RestClient("otto", "food");
const listener = new WebSocketListener("otto", "food");

class Model extends EventEmitter {
    constructor() {
        super();
        this.state = {
            questions: [{
                title: "Help",
                text: "I need to solve some errors",
                creationDate: "24/03/2019",
                author: "John",
                tag: "Java"
            }, {
                title: "Bug",
                text: "I need to solve a bug in my code",
                creationDate: "24/03/2019",
                author: "Andy",
                tag: "Python"
            }],
            newQuestion: {
                title: "",
                text: "",
                creationDate: "",
                author: "",
                tag: ""

            },
            selectedQuestionIndex: -1,
            searchQuestions:{},
            toSearch:""
        };
    }

    changeSelectedQuestionsIndex(index) {
        this.state = {
            ...this.state,
            selectedQuestionIndex: index
        };
        this.emit("change", this.state);
    }

    loadQuestions(){
        return client.loadAllQuestions().then(questions => {
            this.state = { 
                ...this.state, 
                questions: questions
            };
            this.emit("change", this.state);
        })
    }

    /*addQuestion(title, text, creationDate, author, tag){
        return client.createQuestion(title, text, creationDate, author, tag).then(question=>{
            this.state = {
                ...this.state,
                questions: this.state.questions.concat([question])
            };
            console.log(question)
            this.emit("change", this.state);
    });
    }*/

    addQuestion(title, text, creationDate, author, tag){
        return client.createQuestion(title, text, creationDate, author, tag)
            .then(question => this.appendQuestion(question));
    }

    appendQuestion(question) {
        this.state = { 
            ...this.state, 
            questions: this.state.questions.concat([question]) 
        };
        this.emit("change", this.state);
    }

    changeNewQuestionProperty(property, value) {
        this.state = {
            ...this.state,
            newQuestion: {
                ...this.state.newQuestion,
                [property]: value
            }
        };
        this.emit("change", this.state);
    }

    changeToSearch(property, value) {
        this.state = {
            ...this.state,
           [property]:value
        };
        this.emit("change", this.state);
    }

    findByTitle(){ 
        debugger;
        const result=this.state.questions.filter(post=>post.title===this.state.toSearch)
        this.state = {
     ...this.state,
     searchQuestions:result
        };
    }

    newQuestionList(questions){
        this.state = {
            ...this.state,
            questions:questions
        };
        this.emit("change", this.state);

    }

    changeTitleFilter(value){
        this.state = {
            ...this.state,
            searchTitle: value
            }
        
        this.emit("change", this.state);
    }
}

//singleton
const model = new Model();

listener.on("event", event => {
    if (event.type === "QUESTION_CREATED") {
        model.appendQuestion(event.question);
    }
});


export default model;