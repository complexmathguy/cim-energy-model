import React, { Component } from 'react'
import ACDCConverterDCTerminalService from '../services/ACDCConverterDCTerminalService'

class ListACDCConverterDCTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                aCDCConverterDCTerminals: []
        }
        this.addACDCConverterDCTerminal = this.addACDCConverterDCTerminal.bind(this);
        this.editACDCConverterDCTerminal = this.editACDCConverterDCTerminal.bind(this);
        this.deleteACDCConverterDCTerminal = this.deleteACDCConverterDCTerminal.bind(this);
    }

    deleteACDCConverterDCTerminal(id){
        ACDCConverterDCTerminalService.deleteACDCConverterDCTerminal(id).then( res => {
            this.setState({aCDCConverterDCTerminals: this.state.aCDCConverterDCTerminals.filter(aCDCConverterDCTerminal => aCDCConverterDCTerminal.aCDCConverterDCTerminalId !== id)});
        });
    }
    viewACDCConverterDCTerminal(id){
        this.props.history.push(`/view-aCDCConverterDCTerminal/${id}`);
    }
    editACDCConverterDCTerminal(id){
        this.props.history.push(`/add-aCDCConverterDCTerminal/${id}`);
    }

    componentDidMount(){
        ACDCConverterDCTerminalService.getACDCConverterDCTerminals().then((res) => {
            this.setState({ aCDCConverterDCTerminals: res.data});
        });
    }

    addACDCConverterDCTerminal(){
        this.props.history.push('/add-aCDCConverterDCTerminal/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ACDCConverterDCTerminal List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addACDCConverterDCTerminal}> Add ACDCConverterDCTerminal</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Polarity </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.aCDCConverterDCTerminals.map(
                                        aCDCConverterDCTerminal => 
                                        <tr key = {aCDCConverterDCTerminal.aCDCConverterDCTerminalId}>
                                             <td> { aCDCConverterDCTerminal.polarity } </td>
                                             <td>
                                                 <button onClick={ () => this.editACDCConverterDCTerminal(aCDCConverterDCTerminal.aCDCConverterDCTerminalId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteACDCConverterDCTerminal(aCDCConverterDCTerminal.aCDCConverterDCTerminalId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewACDCConverterDCTerminal(aCDCConverterDCTerminal.aCDCConverterDCTerminalId)} className="btn btn-info btn-sm">View </button>
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

export default ListACDCConverterDCTerminalComponent
