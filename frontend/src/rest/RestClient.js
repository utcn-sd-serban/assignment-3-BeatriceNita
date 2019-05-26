const BASE_URL = "http://localhost:8080";

export default class RestClient {
    constructor(username, password) {
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    loadAllQuestions() {
        return fetch(BASE_URL + "/questions", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }
    createQuestion(title, text, creationDate, author, tag) {
        return fetch(BASE_URL + "/questions", {
            method: "POST",
            body: JSON.stringify({
                id:null,
                title: title,
                text: text,
                creationDate: creationDate,
                author: author,
                tag:{id:null,name:tag}
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }
}