import React from "react";

const ListAllQuestions = ({ questions }) => (
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
                            <td>{question.title}</td>
                            <td>{question.text}</td>
                            <td>{question.creationDate}</td>
                            <td>{question.author}</td>
                            <td>{question.tag === null ? "": question.tag.name}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    </div>
);

export default ListAllQuestions;