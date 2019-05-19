import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";

const client = new RestClient("otto", "food");

class Model extends EventEmitter {
    constructor() {
        super();
        this.state = {
            questions: [],
            newQuestion: {
                titleQ: "",
                text: "",
                creationDate: "",
                author: "",
                tag: ""

            }
        };
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

    /*addQuestion(titleQ, text, creationDate, author, tag) {
        this.state = {
            ...this.state,
            questions: this.state.questions.concat([{
                titleQ: titleQ,
                text: text,
                creationDate: creationDate,
                author: author,
                tag: tag
            }])
        };
        this.emit("change", this.state);
    }*/

    addQuestion(titleQ, text, creationDate, author, tag) {
        return client.createQuestion(titleQ, text, creationDate, author, tag)
        .then(question => {this.state = {
            ...this.state,
            questions: this.state.questions.concat([{question}])
        };
        this.emit("change", this.state);
        });
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
        const result=this.state.questions.filter(post=>post.titleQ===this.state.toSearch)
        this.state = {
     ...this.state,
     searchQuestions:result
        };
    }

    updateQuestions(questions) {
        this.state = {
            ...this.state,
            questions: questions
        }
        this.emit("change", this.state);
    }
}

//singleton
const model = new Model();

export default model;