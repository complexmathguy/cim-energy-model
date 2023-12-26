import React, { Component } from 'react'
import PowerSystemStabilizerDynamicsService from '../services/PowerSystemStabilizerDynamicsService'

class ListPowerSystemStabilizerDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                powerSystemStabilizerDynamicss: []
        }
        this.addPowerSystemStabilizerDynamics = this.addPowerSystemStabilizerDynamics.bind(this);
        this.editPowerSystemStabilizerDynamics = this.editPowerSystemStabilizerDynamics.bind(this);
        this.deletePowerSystemStabilizerDynamics = this.deletePowerSystemStabilizerDynamics.bind(this);
    }

    deletePowerSystemStabilizerDynamics(id){
        PowerSystemStabilizerDynamicsService.deletePowerSystemStabilizerDynamics(id).then( res => {
            this.setState({powerSystemStabilizerDynamicss: this.state.powerSystemStabilizerDynamicss.filter(powerSystemStabilizerDynamics => powerSystemStabilizerDynamics.powerSystemStabilizerDynamicsId !== id)});
        });
    }
    viewPowerSystemStabilizerDynamics(id){
        this.props.history.push(`/view-powerSystemStabilizerDynamics/${id}`);
    }
    editPowerSystemStabilizerDynamics(id){
        this.props.history.push(`/add-powerSystemStabilizerDynamics/${id}`);
    }

    componentDidMount(){
        PowerSystemStabilizerDynamicsService.getPowerSystemStabilizerDynamicss().then((res) => {
            this.setState({ powerSystemStabilizerDynamicss: res.data});
        });
    }

    addPowerSystemStabilizerDynamics(){
        this.props.history.push('/add-powerSystemStabilizerDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PowerSystemStabilizerDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPowerSystemStabilizerDynamics}> Add PowerSystemStabilizerDynamics</button>
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
                                    this.state.powerSystemStabilizerDynamicss.map(
                                        powerSystemStabilizerDynamics => 
                                        <tr key = {powerSystemStabilizerDynamics.powerSystemStabilizerDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editPowerSystemStabilizerDynamics(powerSystemStabilizerDynamics.powerSystemStabilizerDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePowerSystemStabilizerDynamics(powerSystemStabilizerDynamics.powerSystemStabilizerDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPowerSystemStabilizerDynamics(powerSystemStabilizerDynamics.powerSystemStabilizerDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListPowerSystemStabilizerDynamicsComponent
