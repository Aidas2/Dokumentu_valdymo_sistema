//<input onclick={(event) -> this.onClick(event, papildomas)} />
import React from 'react';



class Komponentas extends React.Component {
    handleClick = (event) => {
        //this.props.onClick(this.props.papildomas);
        console.log(this.props.papildomas);
    }
    render() {
        return (
            <input onClick={this.handleClick} />
        );
    }
}


class Pasimokyti extends React.Component{
    render(){
        return (<Komponentas papildomas="Tekstas"/>
        )}
}

export default Pasimokyti;

//tuomet panaudojimas būtų toks
{/* <Komponentas papildomas={papildomas}
    onClick={this.onKomponentoClick} /> */}