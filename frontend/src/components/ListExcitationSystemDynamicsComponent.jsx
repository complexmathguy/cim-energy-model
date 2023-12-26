import React, { Component } from 'react'
import ExcitationSystemDynamicsService from '../services/ExcitationSystemDynamicsService'

class ListExcitationSystemDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excitationSystemDynamicss: []
        }
        this.addExcitationSystemDynamics = this.addExcitationSystemDynamics.bind(this);
        this.editExcitationSystemDynamics = this.editExcitationSystemDynamics.bind(this);
        this.deleteExcitationSystemDynamics = this.deleteExcitationSystemDynamics.bind(this);
    }

    deleteExcitationSystemDynamics(id){
        ExcitationSystemDynamicsService.deleteExcitationSystemDynamics(id).then( res => {
            this.setState({excitationSystemDynamicss: this.state.excitationSystemDynamicss.filter(excitationSystemDynamics => excitationSystemDynamics.excitationSystemDynamicsId !== id)});
        });
    }
    viewExcitationSystemDynamics(id){
        this.props.history.push(`/view-excitationSystemDynamics/${id}`);
    }
    editExcitationSystemDynamics(id){
        this.props.history.push(`/add-excitationSystemDynamics/${id}`);
    }

    componentDidMount(){
        ExcitationSystemDynamicsService.getExcitationSystemDynamicss().then((res) => {
            this.setState({ excitationSystemDynamicss: res.data});
        });
    }

    addExcitationSystemDynamics(){
        this.props.history.push('/add-excitationSystemDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcitationSystemDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcitationSystemDynamics}> Add ExcitationSystemDynamics</button>
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
                                    this.state.excitationSystemDynamicss.map(
                                        excitationSystemDynamics => 
                                        <tr key = {excitationSystemDynamics.excitationSystemDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editExcitationSystemDynamics(excitationSystemDynamics.excitationSystemDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcitationSystemDynamics(excitationSystemDynamics.excitationSystemDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcitationSystemDynamics(excitationSystemDynamics.excitationSystemDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcitationSystemDynamicsComponent
