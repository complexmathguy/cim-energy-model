import React, { Component } from 'react'
import DCTerminalService from '../services/DCTerminalService'

class ListDCTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCTerminals: []
        }
        this.addDCTerminal = this.addDCTerminal.bind(this);
        this.editDCTerminal = this.editDCTerminal.bind(this);
        this.deleteDCTerminal = this.deleteDCTerminal.bind(this);
    }

    deleteDCTerminal(id){
        DCTerminalService.deleteDCTerminal(id).then( res => {
            this.setState({dCTerminals: this.state.dCTerminals.filter(dCTerminal => dCTerminal.dCTerminalId !== id)});
        });
    }
    viewDCTerminal(id){
        this.props.history.push(`/view-dCTerminal/${id}`);
    }
    editDCTerminal(id){
        this.props.history.push(`/add-dCTerminal/${id}`);
    }

    componentDidMount(){
        DCTerminalService.getDCTerminals().then((res) => {
            this.setState({ dCTerminals: res.data});
        });
    }

    addDCTerminal(){
        this.props.history.push('/add-dCTerminal/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCTerminal List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCTerminal}> Add DCTerminal</button>
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
                                    this.state.dCTerminals.map(
                                        dCTerminal => 
                                        <tr key = {dCTerminal.dCTerminalId}>
                                             <td>
                                                 <button onClick={ () => this.editDCTerminal(dCTerminal.dCTerminalId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCTerminal(dCTerminal.dCTerminalId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCTerminal(dCTerminal.dCTerminalId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCTerminalComponent
