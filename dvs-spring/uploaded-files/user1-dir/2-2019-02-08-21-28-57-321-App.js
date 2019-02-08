import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Vaisiai from './Vaisiai/Vaisiai';
import apple from './vaisiai_design/apple.png';
import banana from './vaisiai_design/banana.png';
import orange from './vaisiai_design/orange.png';

const visi_vaisiai = [
  {
    paveiksliukas: apple,
    pavadinimas: "Obuolys",
    aprasymas: "Obuolys – būdingas obelų vaisius, morfologiškai irgi vadinamas obuoliu.",
    nuoroda: "https://lt.wikipedia.org/wiki/Obuolys"
  },
  {
    paveiksliukas: banana,
    pavadinimas: "Bananas",
    aprasymas: "Bananas (lot. Musa) – bananinių (Musaceae) šeimos žolinių augalų gentis, kurioje yra apie 80 rūšių.",
    nuoroda: "https://lt.wikipedia.org/wiki/Bananas"
  },
  {
    paveiksliukas: orange,
    pavadinimas: "Apelsinas",
    aprasymas: "Apelsinai – citrinvaisiai, kuriuos mezga kai kurie citrinmedžiai (Citrus).",
    nuoroda: "https://lt.wikipedia.org/wiki/Apelsinas"
  }
]

class App extends Component {
  render() {
    return (
      <div className="container-fluid">
        <div>
          <Vaisiai vaisiai={visi_vaisiai}/>
        </div>
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <p>
            Edit <code>src/App.js</code> and save to reload.
          </p>
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
        </header>
      </div>
    );
  }
}

export default App;
