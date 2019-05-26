import React, { Component } from "react";
import model from "../model/model";
import ChooseOpQuestions from "./ChooseOpQuestions";
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
    }

    componentWillUnmount() {
        model.removeListener("change", this.listener);
    }

    render() {
        return (
            <ChooseOpQuestions
                onAddQuestion={questionsListPresenter.onAddQuestion}
                onListQuestions={questionsListPresenter.onListQuestions}
                onFilterQuestions={questionsListPresenter.onFilterQuestions}
                questions={this.state.questions} />
        );
    }
}