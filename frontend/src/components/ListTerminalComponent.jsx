import React, { Component } from 'react'
import TerminalService from '../services/TerminalService'

class ListTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                terminals: []
        }
        this.addTerminal = this.addTerminal.bind(this);
        this.editTerminal = this.editTerminal.bind(this);
        this.deleteTerminal = this.deleteTerminal.bind(this);
    }

    deleteTerminal(id){
        TerminalService.deleteTerminal(id).then( res => {
            this.setState({terminals: this.state.terminals.filter(terminal => terminal.terminalId !== id)});
        });
    }
    viewTerminal(id){
        this.props.history.push(`/view-terminal/${id}`);
    }
    editTerminal(id){
        this.props.history.push(`/add-terminal/${id}`);
    }

    componentDidMount(){
        TerminalService.getTerminals().then((res) => {
            this.setState({ terminals: res.data});
        });
    }

    addTerminal(){
        this.props.history.push('/add-terminal/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Terminal List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTerminal}> Add Terminal</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.terminals.map(
                                        terminal => 
                                        <tr key = {terminal.terminalId}>
                                             <td>
                                                 <button onClick={ () => this.editTerminal(terminal.terminalId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTerminal(terminal.terminalId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTerminal(terminal.terminalId)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListTerminalComponent
