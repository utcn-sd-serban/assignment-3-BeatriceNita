import React, { Component } from "react";
import model from "../model/model";
import ListAllQuestions from "./ListAllQuestions";
import questionsListPresenter from "../presenter/questionsListPresenter";

const mapModelStateToComponentState = modelState => ({
    questions: modelState.questions
});

export default class SmartChooseOpQuestions extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(model.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        model.addListener("change", this.listener);
        questionsListPresenter.onInit();
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <ListAllQuestions
                onCreateQuestion={questionsListPresenter.onCreateQuestion}
                questions={this.state.questions} />
        );
    }
}