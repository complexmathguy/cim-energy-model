import React, { Component } from 'react'
import SynchronousMachineTimeConstantReactanceService from '../services/SynchronousMachineTimeConstantReactanceService'

class ListSynchronousMachineTimeConstantReactanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                synchronousMachineTimeConstantReactances: []
        }
        this.addSynchronousMachineTimeConstantReactance = this.addSynchronousMachineTimeConstantReactance.bind(this);
        this.editSynchronousMachineTimeConstantReactance = this.editSynchronousMachineTimeConstantReactance.bind(this);
        this.deleteSynchronousMachineTimeConstantReactance = this.deleteSynchronousMachineTimeConstantReactance.bind(this);
    }

    deleteSynchronousMachineTimeConstantReactance(id){
        SynchronousMachineTimeConstantReactanceService.deleteSynchronousMachineTimeConstantReactance(id).then( res => {
            this.setState({synchronousMachineTimeConstantReactances: this.state.synchronousMachineTimeConstantReactances.filter(synchronousMachineTimeConstantReactance => synchronousMachineTimeConstantReactance.synchronousMachineTimeConstantReactanceId !== id)});
        });
    }
    viewSynchronousMachineTimeConstantReactance(id){
        this.props.history.push(`/view-synchronousMachineTimeConstantReactance/${id}`);
    }
    editSynchronousMachineTimeConstantReactance(id){
        this.props.history.push(`/add-synchronousMachineTimeConstantReactance/${id}`);
    }

    componentDidMount(){
        SynchronousMachineTimeConstantReactanceService.getSynchronousMachineTimeConstantReactances().then((res) => {
            this.setState({ synchronousMachineTimeConstantReactances: res.data});
        });
    }

    addSynchronousMachineTimeConstantReactance(){
        this.props.history.push('/add-synchronousMachineTimeConstantReactance/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SynchronousMachineTimeConstantReactance List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSynchronousMachineTimeConstantReactance}> Add SynchronousMachineTimeConstantReactance</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Ks </th>
                                    <th> ModelType </th>
                                    <th> RotorType </th>
                                    <th> Tc </th>
                                    <th> Tpdo </th>
                                    <th> Tppdo </th>
                                    <th> Tppqo </th>
                                    <th> Tpqo </th>
                                    <th> XDirectSubtrans </th>
                                    <th> XDirectSync </th>
                                    <th> XDirectTrans </th>
                                    <th> XQuadSubtrans </th>
                                    <th> XQuadSync </th>
                                    <th> XQuadTrans </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.synchronousMachineTimeConstantReactances.map(
                                        synchronousMachineTimeConstantReactance => 
                                        <tr key = {synchronousMachineTimeConstantReactance.synchronousMachineTimeConstantReactanceId}>
                                             <td> { synchronousMachineTimeConstantReactance.ks } </td>
                                             <td> { synchronousMachineTimeConstantReactance.modelType } </td>
                                             <td> { synchronousMachineTimeConstantReactance.rotorType } </td>
                                             <td> { synchronousMachineTimeConstantReactance.tc } </td>
                                             <td> { synchronousMachineTimeConstantReactance.tpdo } </td>
                                             <td> { synchronousMachineTimeConstantReactance.tppdo } </td>
                                             <td> { synchronousMachineTimeConstantReactance.tppqo } </td>
                                             <td> { synchronousMachineTimeConstantReactance.tpqo } </td>
                                             <td> { synchronousMachineTimeConstantReactance.xDirectSubtrans } </td>
                                             <td> { synchronousMachineTimeConstantReactance.xDirectSync } </td>
                                             <td> { synchronousMachineTimeConstantReactance.xDirectTrans } </td>
                                             <td> { synchronousMachineTimeConstantReactance.xQuadSubtrans } </td>
                                             <td> { synchronousMachineTimeConstantReactance.xQuadSync } </td>
                                             <td> { synchronousMachineTimeConstantReactance.xQuadTrans } </td>
                                             <td>
                                                 <button onClick={ () => this.editSynchronousMachineTimeConstantReactance(synchronousMachineTimeConstantReactance.synchronousMachineTimeConstantReactanceId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSynchronousMachineTimeConstantReactance(synchronousMachineTimeConstantReactance.synchronousMachineTimeConstantReactanceId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSynchronousMachineTimeConstantReactance(synchronousMachineTimeConstantReactance.synchronousMachineTimeConstantReactanceId)} className="btn btn-info btn-sm">View </button>
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

export default ListSynchronousMachineTimeConstantReactanceComponent
