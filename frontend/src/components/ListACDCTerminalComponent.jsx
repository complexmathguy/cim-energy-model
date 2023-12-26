import React, { Component } from 'react'
import ACDCTerminalService from '../services/ACDCTerminalService'

class ListACDCTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                aCDCTerminals: []
        }
        this.addACDCTerminal = this.addACDCTerminal.bind(this);
        this.editACDCTerminal = this.editACDCTerminal.bind(this);
        this.deleteACDCTerminal = this.deleteACDCTerminal.bind(this);
    }

    deleteACDCTerminal(id){
        ACDCTerminalService.deleteACDCTerminal(id).then( res => {
            this.setState({aCDCTerminals: this.state.aCDCTerminals.filter(aCDCTerminal => aCDCTerminal.aCDCTerminalId !== id)});
        });
    }
    viewACDCTerminal(id){
        this.props.history.push(`/view-aCDCTerminal/${id}`);
    }
    editACDCTerminal(id){
        this.props.history.push(`/add-aCDCTerminal/${id}`);
    }

    componentDidMount(){
        ACDCTerminalService.getACDCTerminals().then((res) => {
            this.setState({ aCDCTerminals: res.data});
        });
    }

    addACDCTerminal(){
        this.props.history.push('/add-aCDCTerminal/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ACDCTerminal List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addACDCTerminal}> Add ACDCTerminal</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> SequenceNumber </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.aCDCTerminals.map(
                                        aCDCTerminal => 
                                        <tr key = {aCDCTerminal.aCDCTerminalId}>
                                             <td> { aCDCTerminal.sequenceNumber } </td>
                                             <td>
                                                 <button onClick={ () => this.editACDCTerminal(aCDCTerminal.aCDCTerminalId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteACDCTerminal(aCDCTerminal.aCDCTerminalId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewACDCTerminal(aCDCTerminal.aCDCTerminalId)} className="btn btn-info btn-sm">View </button>
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

export default ListACDCTerminalComponent
