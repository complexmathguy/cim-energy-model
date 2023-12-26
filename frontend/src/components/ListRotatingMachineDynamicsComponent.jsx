import React, { Component } from 'react'
import RotatingMachineDynamicsService from '../services/RotatingMachineDynamicsService'

class ListRotatingMachineDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                rotatingMachineDynamicss: []
        }
        this.addRotatingMachineDynamics = this.addRotatingMachineDynamics.bind(this);
        this.editRotatingMachineDynamics = this.editRotatingMachineDynamics.bind(this);
        this.deleteRotatingMachineDynamics = this.deleteRotatingMachineDynamics.bind(this);
    }

    deleteRotatingMachineDynamics(id){
        RotatingMachineDynamicsService.deleteRotatingMachineDynamics(id).then( res => {
            this.setState({rotatingMachineDynamicss: this.state.rotatingMachineDynamicss.filter(rotatingMachineDynamics => rotatingMachineDynamics.rotatingMachineDynamicsId !== id)});
        });
    }
    viewRotatingMachineDynamics(id){
        this.props.history.push(`/view-rotatingMachineDynamics/${id}`);
    }
    editRotatingMachineDynamics(id){
        this.props.history.push(`/add-rotatingMachineDynamics/${id}`);
    }

    componentDidMount(){
        RotatingMachineDynamicsService.getRotatingMachineDynamicss().then((res) => {
            this.setState({ rotatingMachineDynamicss: res.data});
        });
    }

    addRotatingMachineDynamics(){
        this.props.history.push('/add-rotatingMachineDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RotatingMachineDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRotatingMachineDynamics}> Add RotatingMachineDynamics</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Damping </th>
                                    <th> Inertia </th>
                                    <th> SaturationFactor </th>
                                    <th> SaturationFactor120 </th>
                                    <th> StatorLeakageReactance </th>
                                    <th> StatorResistance </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.rotatingMachineDynamicss.map(
                                        rotatingMachineDynamics => 
                                        <tr key = {rotatingMachineDynamics.rotatingMachineDynamicsId}>
                                             <td> { rotatingMachineDynamics.damping } </td>
                                             <td> { rotatingMachineDynamics.inertia } </td>
                                             <td> { rotatingMachineDynamics.saturationFactor } </td>
                                             <td> { rotatingMachineDynamics.saturationFactor120 } </td>
                                             <td> { rotatingMachineDynamics.statorLeakageReactance } </td>
                                             <td> { rotatingMachineDynamics.statorResistance } </td>
                                             <td>
                                                 <button onClick={ () => this.editRotatingMachineDynamics(rotatingMachineDynamics.rotatingMachineDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRotatingMachineDynamics(rotatingMachineDynamics.rotatingMachineDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRotatingMachineDynamics(rotatingMachineDynamics.rotatingMachineDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListRotatingMachineDynamicsComponent
