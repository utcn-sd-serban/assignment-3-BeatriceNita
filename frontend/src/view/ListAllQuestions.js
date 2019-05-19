import React from "react";

const ListAllQuestions = ({ questions, onChooseAddQuestion }) => (
    <div>
        <h1 class="text bg-warning">Questions</h1>
        <table class="table table-dark table-striped" border="1">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Text</th>
                    <th>Creation Date</th>
                    <th>Author</th>
                    <th>Tag</th>
                </tr>
            </thead>
            <tbody>
                {
                    questions.map((question, index) => (
                        <tr key={index}>
                            <td>{question.titleQ}</td>
                            <td>{question.text}</td>
                            <td>{question.creationDate}</td>
                            <td>{question.author}</td>
                            <td>{question.tag}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
        <button onClick = {onChooseAddQuestion}>Add new question</button>
    </div>
);

export default ListAllQuestions;