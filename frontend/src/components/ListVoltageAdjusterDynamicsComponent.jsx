import React, { Component } from 'react'
import VoltageAdjusterDynamicsService from '../services/VoltageAdjusterDynamicsService'

class ListVoltageAdjusterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                voltageAdjusterDynamicss: []
        }
        this.addVoltageAdjusterDynamics = this.addVoltageAdjusterDynamics.bind(this);
        this.editVoltageAdjusterDynamics = this.editVoltageAdjusterDynamics.bind(this);
        this.deleteVoltageAdjusterDynamics = this.deleteVoltageAdjusterDynamics.bind(this);
    }

    deleteVoltageAdjusterDynamics(id){
        VoltageAdjusterDynamicsService.deleteVoltageAdjusterDynamics(id).then( res => {
            this.setState({voltageAdjusterDynamicss: this.state.voltageAdjusterDynamicss.filter(voltageAdjusterDynamics => voltageAdjusterDynamics.voltageAdjusterDynamicsId !== id)});
        });
    }
    viewVoltageAdjusterDynamics(id){
        this.props.history.push(`/view-voltageAdjusterDynamics/${id}`);
    }
    editVoltageAdjusterDynamics(id){
        this.props.history.push(`/add-voltageAdjusterDynamics/${id}`);
    }

    componentDidMount(){
        VoltageAdjusterDynamicsService.getVoltageAdjusterDynamicss().then((res) => {
            this.setState({ voltageAdjusterDynamicss: res.data});
        });
    }

    addVoltageAdjusterDynamics(){
        this.props.history.push('/add-voltageAdjusterDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VoltageAdjusterDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVoltageAdjusterDynamics}> Add VoltageAdjusterDynamics</button>
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
                                    this.state.voltageAdjusterDynamicss.map(
                                        voltageAdjusterDynamics => 
                                        <tr key = {voltageAdjusterDynamics.voltageAdjusterDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editVoltageAdjusterDynamics(voltageAdjusterDynamics.voltageAdjusterDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVoltageAdjusterDynamics(voltageAdjusterDynamics.voltageAdjusterDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVoltageAdjusterDynamics(voltageAdjusterDynamics.voltageAdjusterDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListVoltageAdjusterDynamicsComponent
