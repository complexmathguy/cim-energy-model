import React, { Component } from 'react'
import TurbineGovernorDynamicsService from '../services/TurbineGovernorDynamicsService'

class ListTurbineGovernorDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                turbineGovernorDynamicss: []
        }
        this.addTurbineGovernorDynamics = this.addTurbineGovernorDynamics.bind(this);
        this.editTurbineGovernorDynamics = this.editTurbineGovernorDynamics.bind(this);
        this.deleteTurbineGovernorDynamics = this.deleteTurbineGovernorDynamics.bind(this);
    }

    deleteTurbineGovernorDynamics(id){
        TurbineGovernorDynamicsService.deleteTurbineGovernorDynamics(id).then( res => {
            this.setState({turbineGovernorDynamicss: this.state.turbineGovernorDynamicss.filter(turbineGovernorDynamics => turbineGovernorDynamics.turbineGovernorDynamicsId !== id)});
        });
    }
    viewTurbineGovernorDynamics(id){
        this.props.history.push(`/view-turbineGovernorDynamics/${id}`);
    }
    editTurbineGovernorDynamics(id){
        this.props.history.push(`/add-turbineGovernorDynamics/${id}`);
    }

    componentDidMount(){
        TurbineGovernorDynamicsService.getTurbineGovernorDynamicss().then((res) => {
            this.setState({ turbineGovernorDynamicss: res.data});
        });
    }

    addTurbineGovernorDynamics(){
        this.props.history.push('/add-turbineGovernorDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TurbineGovernorDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTurbineGovernorDynamics}> Add TurbineGovernorDynamics</button>
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
                                    this.state.turbineGovernorDynamicss.map(
                                        turbineGovernorDynamics => 
                                        <tr key = {turbineGovernorDynamics.turbineGovernorDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editTurbineGovernorDynamics(turbineGovernorDynamics.turbineGovernorDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTurbineGovernorDynamics(turbineGovernorDynamics.turbineGovernorDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTurbineGovernorDynamics(turbineGovernorDynamics.turbineGovernorDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListTurbineGovernorDynamicsComponent
