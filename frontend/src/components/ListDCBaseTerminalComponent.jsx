import React, { Component } from 'react'
import DCBaseTerminalService from '../services/DCBaseTerminalService'

class ListDCBaseTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCBaseTerminals: []
        }
        this.addDCBaseTerminal = this.addDCBaseTerminal.bind(this);
        this.editDCBaseTerminal = this.editDCBaseTerminal.bind(this);
        this.deleteDCBaseTerminal = this.deleteDCBaseTerminal.bind(this);
    }

    deleteDCBaseTerminal(id){
        DCBaseTerminalService.deleteDCBaseTerminal(id).then( res => {
            this.setState({dCBaseTerminals: this.state.dCBaseTerminals.filter(dCBaseTerminal => dCBaseTerminal.dCBaseTerminalId !== id)});
        });
    }
    viewDCBaseTerminal(id){
        this.props.history.push(`/view-dCBaseTerminal/${id}`);
    }
    editDCBaseTerminal(id){
        this.props.history.push(`/add-dCBaseTerminal/${id}`);
    }

    componentDidMount(){
        DCBaseTerminalService.getDCBaseTerminals().then((res) => {
            this.setState({ dCBaseTerminals: res.data});
        });
    }

    addDCBaseTerminal(){
        this.props.history.push('/add-dCBaseTerminal/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCBaseTerminal List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCBaseTerminal}> Add DCBaseTerminal</button>
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
                                    this.state.dCBaseTerminals.map(
                                        dCBaseTerminal => 
                                        <tr key = {dCBaseTerminal.dCBaseTerminalId}>
                                             <td>
                                                 <button onClick={ () => this.editDCBaseTerminal(dCBaseTerminal.dCBaseTerminalId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCBaseTerminal(dCBaseTerminal.dCBaseTerminalId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCBaseTerminal(dCBaseTerminal.dCBaseTerminalId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCBaseTerminalComponent
