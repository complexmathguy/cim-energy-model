import React, { Component } from 'react'
import AsynchronousMachineService from '../services/AsynchronousMachineService'

class ListAsynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                asynchronousMachines: []
        }
        this.addAsynchronousMachine = this.addAsynchronousMachine.bind(this);
        this.editAsynchronousMachine = this.editAsynchronousMachine.bind(this);
        this.deleteAsynchronousMachine = this.deleteAsynchronousMachine.bind(this);
    }

    deleteAsynchronousMachine(id){
        AsynchronousMachineService.deleteAsynchronousMachine(id).then( res => {
            this.setState({asynchronousMachines: this.state.asynchronousMachines.filter(asynchronousMachine => asynchronousMachine.asynchronousMachineId !== id)});
        });
    }
    viewAsynchronousMachine(id){
        this.props.history.push(`/view-asynchronousMachine/${id}`);
    }
    editAsynchronousMachine(id){
        this.props.history.push(`/add-asynchronousMachine/${id}`);
    }

    componentDidMount(){
        AsynchronousMachineService.getAsynchronousMachines().then((res) => {
            this.setState({ asynchronousMachines: res.data});
        });
    }

    addAsynchronousMachine(){
        this.props.history.push('/add-asynchronousMachine/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AsynchronousMachine List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAsynchronousMachine}> Add AsynchronousMachine</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> ConverterFedDrive </th>
                                    <th> Efficiency </th>
                                    <th> IaIrRatio </th>
                                    <th> NominalFrequency </th>
                                    <th> NominalSpeed </th>
                                    <th> PolePairNumber </th>
                                    <th> RatedMechanicalPower </th>
                                    <th> Reversible </th>
                                    <th> RxLockedRotorRatio </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.asynchronousMachines.map(
                                        asynchronousMachine => 
                                        <tr key = {asynchronousMachine.asynchronousMachineId}>
                                             <td> { asynchronousMachine.converterFedDrive } </td>
                                             <td> { asynchronousMachine.efficiency } </td>
                                             <td> { asynchronousMachine.iaIrRatio } </td>
                                             <td> { asynchronousMachine.nominalFrequency } </td>
                                             <td> { asynchronousMachine.nominalSpeed } </td>
                                             <td> { asynchronousMachine.polePairNumber } </td>
                                             <td> { asynchronousMachine.ratedMechanicalPower } </td>
                                             <td> { asynchronousMachine.reversible } </td>
                                             <td> { asynchronousMachine.rxLockedRotorRatio } </td>
                                             <td>
                                                 <button onClick={ () => this.editAsynchronousMachine(asynchronousMachine.asynchronousMachineId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAsynchronousMachine(asynchronousMachine.asynchronousMachineId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAsynchronousMachine(asynchronousMachine.asynchronousMachineId)} className="btn btn-info btn-sm">View </button>
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

export default ListAsynchronousMachineComponent
