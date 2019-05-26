import React from "react";
import 'bootstrap/dist/css/bootstrap.css';

const ChooseOpQuestions = ({ onAddQuestion, onListQuestions, onFilterQuestions }) => (
    <div>
        <h1 class="text bg-secondary">Questions Operations</h1>
        <p>You can choose the operation you wish to perform:</p>
        <div class="d-inline-flex p-3 bg-secondary text-white">
            <button type="button" class="p-2 bg-info" onClick = {onAddQuestion}>Ask Question</button>
            <button type="button" class="p-2 bg-warning" onClick = {onListQuestions}>List All Questions</button>
            <button type="button" class="p-2 bg-primary" onClick = {onFilterQuestions}>Filter Questions</button>
        </div>
    </div>
);

export default ChooseOpQuestions;

