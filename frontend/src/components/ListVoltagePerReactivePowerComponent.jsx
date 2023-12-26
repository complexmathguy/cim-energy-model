import React, { Component } from 'react'
import VoltagePerReactivePowerService from '../services/VoltagePerReactivePowerService'

class ListVoltagePerReactivePowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                voltagePerReactivePowers: []
        }
        this.addVoltagePerReactivePower = this.addVoltagePerReactivePower.bind(this);
        this.editVoltagePerReactivePower = this.editVoltagePerReactivePower.bind(this);
        this.deleteVoltagePerReactivePower = this.deleteVoltagePerReactivePower.bind(this);
    }

    deleteVoltagePerReactivePower(id){
        VoltagePerReactivePowerService.deleteVoltagePerReactivePower(id).then( res => {
            this.setState({voltagePerReactivePowers: this.state.voltagePerReactivePowers.filter(voltagePerReactivePower => voltagePerReactivePower.voltagePerReactivePowerId !== id)});
        });
    }
    viewVoltagePerReactivePower(id){
        this.props.history.push(`/view-voltagePerReactivePower/${id}`);
    }
    editVoltagePerReactivePower(id){
        this.props.history.push(`/add-voltagePerReactivePower/${id}`);
    }

    componentDidMount(){
        VoltagePerReactivePowerService.getVoltagePerReactivePowers().then((res) => {
            this.setState({ voltagePerReactivePowers: res.data});
        });
    }

    addVoltagePerReactivePower(){
        this.props.history.push('/add-voltagePerReactivePower/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VoltagePerReactivePower List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVoltagePerReactivePower}> Add VoltagePerReactivePower</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> DenominatorMultiplier </th>
                                    <th> DenominatorUnit </th>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.voltagePerReactivePowers.map(
                                        voltagePerReactivePower => 
                                        <tr key = {voltagePerReactivePower.voltagePerReactivePowerId}>
                                             <td> { voltagePerReactivePower.denominatorMultiplier } </td>
                                             <td> { voltagePerReactivePower.denominatorUnit } </td>
                                             <td> { voltagePerReactivePower.multiplier } </td>
                                             <td> { voltagePerReactivePower.unit } </td>
                                             <td> { voltagePerReactivePower.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editVoltagePerReactivePower(voltagePerReactivePower.voltagePerReactivePowerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVoltagePerReactivePower(voltagePerReactivePower.voltagePerReactivePowerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVoltagePerReactivePower(voltagePerReactivePower.voltagePerReactivePowerId)} className="btn btn-info btn-sm">View </button>
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

export default ListVoltagePerReactivePowerComponent
