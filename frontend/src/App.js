import React from 'react';
import SmartLogin from './view/SmartLogin';
import SmartListAllQuestions from './view/SmartListAllQuestions';
import SmartFilterQuestions from './view/SmartFilterQuestions';
import SmartFilteredQuestions from './view/SmartFilteredQuestions';
import SmartCreateQuestion from './view/SmartCreateQuestion';
import SmartChooseOpQuestions from './view/SmartChooseOpQuestions';

import './App.css';

import { HashRouter, Switch, Route} from "react-router-dom";

const App = () =>(
<div className="App">
        <HashRouter>
          <Switch>
            <Route exact={true} component={SmartLogin} path="/" />
            <Route exact={true} component={SmartChooseOpQuestions} path="/questions-ops" />
            <Route exact={true} component={SmartCreateQuestion} path="/create-question" />
            <Route exact={true} component={SmartListAllQuestions} path="/list-questions" />
            <Route exact={true} component={SmartFilterQuestions} path="/filter-questions" />
            <Route exact={true} component={SmartFilteredQuestions} path="/filter-questions-yes" />
          </Switch>
        </HashRouter>     
</div>
);


export default App;
