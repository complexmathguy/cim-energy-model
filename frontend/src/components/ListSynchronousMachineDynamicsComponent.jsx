import React, { Component } from 'react'
import SynchronousMachineDynamicsService from '../services/SynchronousMachineDynamicsService'

class ListSynchronousMachineDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                synchronousMachineDynamicss: []
        }
        this.addSynchronousMachineDynamics = this.addSynchronousMachineDynamics.bind(this);
        this.editSynchronousMachineDynamics = this.editSynchronousMachineDynamics.bind(this);
        this.deleteSynchronousMachineDynamics = this.deleteSynchronousMachineDynamics.bind(this);
    }

    deleteSynchronousMachineDynamics(id){
        SynchronousMachineDynamicsService.deleteSynchronousMachineDynamics(id).then( res => {
            this.setState({synchronousMachineDynamicss: this.state.synchronousMachineDynamicss.filter(synchronousMachineDynamics => synchronousMachineDynamics.synchronousMachineDynamicsId !== id)});
        });
    }
    viewSynchronousMachineDynamics(id){
        this.props.history.push(`/view-synchronousMachineDynamics/${id}`);
    }
    editSynchronousMachineDynamics(id){
        this.props.history.push(`/add-synchronousMachineDynamics/${id}`);
    }

    componentDidMount(){
        SynchronousMachineDynamicsService.getSynchronousMachineDynamicss().then((res) => {
            this.setState({ synchronousMachineDynamicss: res.data});
        });
    }

    addSynchronousMachineDynamics(){
        this.props.history.push('/add-synchronousMachineDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SynchronousMachineDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSynchronousMachineDynamics}> Add SynchronousMachineDynamics</button>
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
                                    this.state.synchronousMachineDynamicss.map(
                                        synchronousMachineDynamics => 
                                        <tr key = {synchronousMachineDynamics.synchronousMachineDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editSynchronousMachineDynamics(synchronousMachineDynamics.synchronousMachineDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSynchronousMachineDynamics(synchronousMachineDynamics.synchronousMachineDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSynchronousMachineDynamics(synchronousMachineDynamics.synchronousMachineDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListSynchronousMachineDynamicsComponent
