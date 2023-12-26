import React, { Component } from 'react'
import VoltageService from '../services/VoltageService'

class ListVoltageComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                voltages: []
        }
        this.addVoltage = this.addVoltage.bind(this);
        this.editVoltage = this.editVoltage.bind(this);
        this.deleteVoltage = this.deleteVoltage.bind(this);
    }

    deleteVoltage(id){
        VoltageService.deleteVoltage(id).then( res => {
            this.setState({voltages: this.state.voltages.filter(voltage => voltage.voltageId !== id)});
        });
    }
    viewVoltage(id){
        this.props.history.push(`/view-voltage/${id}`);
    }
    editVoltage(id){
        this.props.history.push(`/add-voltage/${id}`);
    }

    componentDidMount(){
        VoltageService.getVoltages().then((res) => {
            this.setState({ voltages: res.data});
        });
    }

    addVoltage(){
        this.props.history.push('/add-voltage/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Voltage List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVoltage}> Add Voltage</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.voltages.map(
                                        voltage => 
                                        <tr key = {voltage.voltageId}>
                                             <td> { voltage.multiplier } </td>
                                             <td> { voltage.unit } </td>
                                             <td> { voltage.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editVoltage(voltage.voltageId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVoltage(voltage.voltageId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVoltage(voltage.voltageId)} className="btn btn-info btn-sm">View </button>
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

export default ListVoltageComponent
