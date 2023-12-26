import React, { Component } from 'react'
import VoltageLimitService from '../services/VoltageLimitService'

class ListVoltageLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                voltageLimits: []
        }
        this.addVoltageLimit = this.addVoltageLimit.bind(this);
        this.editVoltageLimit = this.editVoltageLimit.bind(this);
        this.deleteVoltageLimit = this.deleteVoltageLimit.bind(this);
    }

    deleteVoltageLimit(id){
        VoltageLimitService.deleteVoltageLimit(id).then( res => {
            this.setState({voltageLimits: this.state.voltageLimits.filter(voltageLimit => voltageLimit.voltageLimitId !== id)});
        });
    }
    viewVoltageLimit(id){
        this.props.history.push(`/view-voltageLimit/${id}`);
    }
    editVoltageLimit(id){
        this.props.history.push(`/add-voltageLimit/${id}`);
    }

    componentDidMount(){
        VoltageLimitService.getVoltageLimits().then((res) => {
            this.setState({ voltageLimits: res.data});
        });
    }

    addVoltageLimit(){
        this.props.history.push('/add-voltageLimit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VoltageLimit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVoltageLimit}> Add VoltageLimit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.voltageLimits.map(
                                        voltageLimit => 
                                        <tr key = {voltageLimit.voltageLimitId}>
                                             <td> { voltageLimit.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editVoltageLimit(voltageLimit.voltageLimitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVoltageLimit(voltageLimit.voltageLimitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVoltageLimit(voltageLimit.voltageLimitId)} className="btn btn-info btn-sm">View </button>
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

export default ListVoltageLimitComponent
