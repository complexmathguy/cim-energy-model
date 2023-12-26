import React, { Component } from 'react'
import SynchronousMachineEquivalentCircuitService from '../services/SynchronousMachineEquivalentCircuitService'

class ListSynchronousMachineEquivalentCircuitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                synchronousMachineEquivalentCircuits: []
        }
        this.addSynchronousMachineEquivalentCircuit = this.addSynchronousMachineEquivalentCircuit.bind(this);
        this.editSynchronousMachineEquivalentCircuit = this.editSynchronousMachineEquivalentCircuit.bind(this);
        this.deleteSynchronousMachineEquivalentCircuit = this.deleteSynchronousMachineEquivalentCircuit.bind(this);
    }

    deleteSynchronousMachineEquivalentCircuit(id){
        SynchronousMachineEquivalentCircuitService.deleteSynchronousMachineEquivalentCircuit(id).then( res => {
            this.setState({synchronousMachineEquivalentCircuits: this.state.synchronousMachineEquivalentCircuits.filter(synchronousMachineEquivalentCircuit => synchronousMachineEquivalentCircuit.synchronousMachineEquivalentCircuitId !== id)});
        });
    }
    viewSynchronousMachineEquivalentCircuit(id){
        this.props.history.push(`/view-synchronousMachineEquivalentCircuit/${id}`);
    }
    editSynchronousMachineEquivalentCircuit(id){
        this.props.history.push(`/add-synchronousMachineEquivalentCircuit/${id}`);
    }

    componentDidMount(){
        SynchronousMachineEquivalentCircuitService.getSynchronousMachineEquivalentCircuits().then((res) => {
            this.setState({ synchronousMachineEquivalentCircuits: res.data});
        });
    }

    addSynchronousMachineEquivalentCircuit(){
        this.props.history.push('/add-synchronousMachineEquivalentCircuit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SynchronousMachineEquivalentCircuit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSynchronousMachineEquivalentCircuit}> Add SynchronousMachineEquivalentCircuit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> R1d </th>
                                    <th> R1q </th>
                                    <th> R2q </th>
                                    <th> Rfd </th>
                                    <th> X1d </th>
                                    <th> X1q </th>
                                    <th> X2q </th>
                                    <th> Xad </th>
                                    <th> Xaq </th>
                                    <th> Xf1d </th>
                                    <th> Xfd </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.synchronousMachineEquivalentCircuits.map(
                                        synchronousMachineEquivalentCircuit => 
                                        <tr key = {synchronousMachineEquivalentCircuit.synchronousMachineEquivalentCircuitId}>
                                             <td> { synchronousMachineEquivalentCircuit.r1d } </td>
                                             <td> { synchronousMachineEquivalentCircuit.r1q } </td>
                                             <td> { synchronousMachineEquivalentCircuit.r2q } </td>
                                             <td> { synchronousMachineEquivalentCircuit.rfd } </td>
                                             <td> { synchronousMachineEquivalentCircuit.x1d } </td>
                                             <td> { synchronousMachineEquivalentCircuit.x1q } </td>
                                             <td> { synchronousMachineEquivalentCircuit.x2q } </td>
                                             <td> { synchronousMachineEquivalentCircuit.xad } </td>
                                             <td> { synchronousMachineEquivalentCircuit.xaq } </td>
                                             <td> { synchronousMachineEquivalentCircuit.xf1d } </td>
                                             <td> { synchronousMachineEquivalentCircuit.xfd } </td>
                                             <td>
                                                 <button onClick={ () => this.editSynchronousMachineEquivalentCircuit(synchronousMachineEquivalentCircuit.synchronousMachineEquivalentCircuitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSynchronousMachineEquivalentCircuit(synchronousMachineEquivalentCircuit.synchronousMachineEquivalentCircuitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSynchronousMachineEquivalentCircuit(synchronousMachineEquivalentCircuit.synchronousMachineEquivalentCircuitId)} className="btn btn-info btn-sm">View </button>
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

export default ListSynchronousMachineEquivalentCircuitComponent
