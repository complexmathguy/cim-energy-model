import React, { Component } from 'react'
import VoltageCompensatorDynamicsService from '../services/VoltageCompensatorDynamicsService'

class ListVoltageCompensatorDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                voltageCompensatorDynamicss: []
        }
        this.addVoltageCompensatorDynamics = this.addVoltageCompensatorDynamics.bind(this);
        this.editVoltageCompensatorDynamics = this.editVoltageCompensatorDynamics.bind(this);
        this.deleteVoltageCompensatorDynamics = this.deleteVoltageCompensatorDynamics.bind(this);
    }

    deleteVoltageCompensatorDynamics(id){
        VoltageCompensatorDynamicsService.deleteVoltageCompensatorDynamics(id).then( res => {
            this.setState({voltageCompensatorDynamicss: this.state.voltageCompensatorDynamicss.filter(voltageCompensatorDynamics => voltageCompensatorDynamics.voltageCompensatorDynamicsId !== id)});
        });
    }
    viewVoltageCompensatorDynamics(id){
        this.props.history.push(`/view-voltageCompensatorDynamics/${id}`);
    }
    editVoltageCompensatorDynamics(id){
        this.props.history.push(`/add-voltageCompensatorDynamics/${id}`);
    }

    componentDidMount(){
        VoltageCompensatorDynamicsService.getVoltageCompensatorDynamicss().then((res) => {
            this.setState({ voltageCompensatorDynamicss: res.data});
        });
    }

    addVoltageCompensatorDynamics(){
        this.props.history.push('/add-voltageCompensatorDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VoltageCompensatorDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVoltageCompensatorDynamics}> Add VoltageCompensatorDynamics</button>
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
                                    this.state.voltageCompensatorDynamicss.map(
                                        voltageCompensatorDynamics => 
                                        <tr key = {voltageCompensatorDynamics.voltageCompensatorDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editVoltageCompensatorDynamics(voltageCompensatorDynamics.voltageCompensatorDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVoltageCompensatorDynamics(voltageCompensatorDynamics.voltageCompensatorDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVoltageCompensatorDynamics(voltageCompensatorDynamics.voltageCompensatorDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListVoltageCompensatorDynamicsComponent
