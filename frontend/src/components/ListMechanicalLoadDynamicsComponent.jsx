import React, { Component } from 'react'
import MechanicalLoadDynamicsService from '../services/MechanicalLoadDynamicsService'

class ListMechanicalLoadDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                mechanicalLoadDynamicss: []
        }
        this.addMechanicalLoadDynamics = this.addMechanicalLoadDynamics.bind(this);
        this.editMechanicalLoadDynamics = this.editMechanicalLoadDynamics.bind(this);
        this.deleteMechanicalLoadDynamics = this.deleteMechanicalLoadDynamics.bind(this);
    }

    deleteMechanicalLoadDynamics(id){
        MechanicalLoadDynamicsService.deleteMechanicalLoadDynamics(id).then( res => {
            this.setState({mechanicalLoadDynamicss: this.state.mechanicalLoadDynamicss.filter(mechanicalLoadDynamics => mechanicalLoadDynamics.mechanicalLoadDynamicsId !== id)});
        });
    }
    viewMechanicalLoadDynamics(id){
        this.props.history.push(`/view-mechanicalLoadDynamics/${id}`);
    }
    editMechanicalLoadDynamics(id){
        this.props.history.push(`/add-mechanicalLoadDynamics/${id}`);
    }

    componentDidMount(){
        MechanicalLoadDynamicsService.getMechanicalLoadDynamicss().then((res) => {
            this.setState({ mechanicalLoadDynamicss: res.data});
        });
    }

    addMechanicalLoadDynamics(){
        this.props.history.push('/add-mechanicalLoadDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">MechanicalLoadDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMechanicalLoadDynamics}> Add MechanicalLoadDynamics</button>
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
                                    this.state.mechanicalLoadDynamicss.map(
                                        mechanicalLoadDynamics => 
                                        <tr key = {mechanicalLoadDynamics.mechanicalLoadDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editMechanicalLoadDynamics(mechanicalLoadDynamics.mechanicalLoadDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMechanicalLoadDynamics(mechanicalLoadDynamics.mechanicalLoadDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMechanicalLoadDynamics(mechanicalLoadDynamics.mechanicalLoadDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListMechanicalLoadDynamicsComponent
