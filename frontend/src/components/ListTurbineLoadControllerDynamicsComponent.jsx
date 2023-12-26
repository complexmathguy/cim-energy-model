import React, { Component } from 'react'
import TurbineLoadControllerDynamicsService from '../services/TurbineLoadControllerDynamicsService'

class ListTurbineLoadControllerDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                turbineLoadControllerDynamicss: []
        }
        this.addTurbineLoadControllerDynamics = this.addTurbineLoadControllerDynamics.bind(this);
        this.editTurbineLoadControllerDynamics = this.editTurbineLoadControllerDynamics.bind(this);
        this.deleteTurbineLoadControllerDynamics = this.deleteTurbineLoadControllerDynamics.bind(this);
    }

    deleteTurbineLoadControllerDynamics(id){
        TurbineLoadControllerDynamicsService.deleteTurbineLoadControllerDynamics(id).then( res => {
            this.setState({turbineLoadControllerDynamicss: this.state.turbineLoadControllerDynamicss.filter(turbineLoadControllerDynamics => turbineLoadControllerDynamics.turbineLoadControllerDynamicsId !== id)});
        });
    }
    viewTurbineLoadControllerDynamics(id){
        this.props.history.push(`/view-turbineLoadControllerDynamics/${id}`);
    }
    editTurbineLoadControllerDynamics(id){
        this.props.history.push(`/add-turbineLoadControllerDynamics/${id}`);
    }

    componentDidMount(){
        TurbineLoadControllerDynamicsService.getTurbineLoadControllerDynamicss().then((res) => {
            this.setState({ turbineLoadControllerDynamicss: res.data});
        });
    }

    addTurbineLoadControllerDynamics(){
        this.props.history.push('/add-turbineLoadControllerDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TurbineLoadControllerDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTurbineLoadControllerDynamics}> Add TurbineLoadControllerDynamics</button>
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
                                    this.state.turbineLoadControllerDynamicss.map(
                                        turbineLoadControllerDynamics => 
                                        <tr key = {turbineLoadControllerDynamics.turbineLoadControllerDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editTurbineLoadControllerDynamics(turbineLoadControllerDynamics.turbineLoadControllerDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTurbineLoadControllerDynamics(turbineLoadControllerDynamics.turbineLoadControllerDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTurbineLoadControllerDynamics(turbineLoadControllerDynamics.turbineLoadControllerDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListTurbineLoadControllerDynamicsComponent
