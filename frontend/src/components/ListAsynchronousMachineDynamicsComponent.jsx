import React, { Component } from 'react'
import AsynchronousMachineDynamicsService from '../services/AsynchronousMachineDynamicsService'

class ListAsynchronousMachineDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                asynchronousMachineDynamicss: []
        }
        this.addAsynchronousMachineDynamics = this.addAsynchronousMachineDynamics.bind(this);
        this.editAsynchronousMachineDynamics = this.editAsynchronousMachineDynamics.bind(this);
        this.deleteAsynchronousMachineDynamics = this.deleteAsynchronousMachineDynamics.bind(this);
    }

    deleteAsynchronousMachineDynamics(id){
        AsynchronousMachineDynamicsService.deleteAsynchronousMachineDynamics(id).then( res => {
            this.setState({asynchronousMachineDynamicss: this.state.asynchronousMachineDynamicss.filter(asynchronousMachineDynamics => asynchronousMachineDynamics.asynchronousMachineDynamicsId !== id)});
        });
    }
    viewAsynchronousMachineDynamics(id){
        this.props.history.push(`/view-asynchronousMachineDynamics/${id}`);
    }
    editAsynchronousMachineDynamics(id){
        this.props.history.push(`/add-asynchronousMachineDynamics/${id}`);
    }

    componentDidMount(){
        AsynchronousMachineDynamicsService.getAsynchronousMachineDynamicss().then((res) => {
            this.setState({ asynchronousMachineDynamicss: res.data});
        });
    }

    addAsynchronousMachineDynamics(){
        this.props.history.push('/add-asynchronousMachineDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AsynchronousMachineDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAsynchronousMachineDynamics}> Add AsynchronousMachineDynamics</button>
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
                                    this.state.asynchronousMachineDynamicss.map(
                                        asynchronousMachineDynamics => 
                                        <tr key = {asynchronousMachineDynamics.asynchronousMachineDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editAsynchronousMachineDynamics(asynchronousMachineDynamics.asynchronousMachineDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAsynchronousMachineDynamics(asynchronousMachineDynamics.asynchronousMachineDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAsynchronousMachineDynamics(asynchronousMachineDynamics.asynchronousMachineDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListAsynchronousMachineDynamicsComponent
