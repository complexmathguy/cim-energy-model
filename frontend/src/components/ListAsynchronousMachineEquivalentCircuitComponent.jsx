import React, { Component } from 'react'
import AsynchronousMachineEquivalentCircuitService from '../services/AsynchronousMachineEquivalentCircuitService'

class ListAsynchronousMachineEquivalentCircuitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                asynchronousMachineEquivalentCircuits: []
        }
        this.addAsynchronousMachineEquivalentCircuit = this.addAsynchronousMachineEquivalentCircuit.bind(this);
        this.editAsynchronousMachineEquivalentCircuit = this.editAsynchronousMachineEquivalentCircuit.bind(this);
        this.deleteAsynchronousMachineEquivalentCircuit = this.deleteAsynchronousMachineEquivalentCircuit.bind(this);
    }

    deleteAsynchronousMachineEquivalentCircuit(id){
        AsynchronousMachineEquivalentCircuitService.deleteAsynchronousMachineEquivalentCircuit(id).then( res => {
            this.setState({asynchronousMachineEquivalentCircuits: this.state.asynchronousMachineEquivalentCircuits.filter(asynchronousMachineEquivalentCircuit => asynchronousMachineEquivalentCircuit.asynchronousMachineEquivalentCircuitId !== id)});
        });
    }
    viewAsynchronousMachineEquivalentCircuit(id){
        this.props.history.push(`/view-asynchronousMachineEquivalentCircuit/${id}`);
    }
    editAsynchronousMachineEquivalentCircuit(id){
        this.props.history.push(`/add-asynchronousMachineEquivalentCircuit/${id}`);
    }

    componentDidMount(){
        AsynchronousMachineEquivalentCircuitService.getAsynchronousMachineEquivalentCircuits().then((res) => {
            this.setState({ asynchronousMachineEquivalentCircuits: res.data});
        });
    }

    addAsynchronousMachineEquivalentCircuit(){
        this.props.history.push('/add-asynchronousMachineEquivalentCircuit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AsynchronousMachineEquivalentCircuit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAsynchronousMachineEquivalentCircuit}> Add AsynchronousMachineEquivalentCircuit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Rr1 </th>
                                    <th> Rr2 </th>
                                    <th> Xlr1 </th>
                                    <th> Xlr2 </th>
                                    <th> Xm </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.asynchronousMachineEquivalentCircuits.map(
                                        asynchronousMachineEquivalentCircuit => 
                                        <tr key = {asynchronousMachineEquivalentCircuit.asynchronousMachineEquivalentCircuitId}>
                                             <td> { asynchronousMachineEquivalentCircuit.rr1 } </td>
                                             <td> { asynchronousMachineEquivalentCircuit.rr2 } </td>
                                             <td> { asynchronousMachineEquivalentCircuit.xlr1 } </td>
                                             <td> { asynchronousMachineEquivalentCircuit.xlr2 } </td>
                                             <td> { asynchronousMachineEquivalentCircuit.xm } </td>
                                             <td>
                                                 <button onClick={ () => this.editAsynchronousMachineEquivalentCircuit(asynchronousMachineEquivalentCircuit.asynchronousMachineEquivalentCircuitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAsynchronousMachineEquivalentCircuit(asynchronousMachineEquivalentCircuit.asynchronousMachineEquivalentCircuitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAsynchronousMachineEquivalentCircuit(asynchronousMachineEquivalentCircuit.asynchronousMachineEquivalentCircuitId)} className="btn btn-info btn-sm">View </button>
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

export default ListAsynchronousMachineEquivalentCircuitComponent
